package com.example.movieapp.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.example.domain.movies.model.Movie
import com.example.movieapp.MovieApplication
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.main.view.adapters.MovieAdapter
import com.example.movieapp.main.view.utils.LoadStateAdapter
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MovieApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bindAdapter(viewModel.getAllMovies())
    }

    @InternalCoroutinesApi
    private fun ActivityMainBinding.bindAdapter(
        movies: Flow<PagingData<Movie>>
    ) {

        val adapter = MovieAdapter()
        val header = LoadStateAdapter { adapter.retry() }
        movieRecycler.adapter = adapter.withLoadStateHeaderAndFooter(
            header = header,
            footer = LoadStateAdapter { adapter.retry() }
        )

        bindList(
            header = header,
            adapter = adapter,
            movies = movies
        )
    }

    //Method sets data into RecyclerView
    private fun ActivityMainBinding.bindList(
        header: LoadStateAdapter,
        adapter: MovieAdapter,
        movies: Flow<PagingData<Movie>>,
    ) {
        retry.setOnClickListener {
            adapter.retry()
        }

        lifecycleScope.launch {
            movies
                .distinctUntilChanged()
                .collectLatest {
                    adapter.submitData(it)
                }
        }
        //check status of loading to show progress in view
        lifecycleScope.launch {
            adapter.loadStateFlow.collect { loadState ->
                header.loadState = loadState.mediator
                    ?.refresh
                    ?.takeIf { it is LoadState.Error && adapter.itemCount > 0 }
                    ?: loadState.prepend

                movieRecycler.isVisible =
                    loadState.source.refresh is LoadState.NotLoading
                            || loadState.mediator?.refresh is LoadState.NotLoading

                progress.isVisible = loadState.source.refresh is LoadState.Loading

                retry.isVisible =
                    loadState.mediator?.refresh is LoadState.Error && adapter.itemCount == 0
            }
        }
    }
}