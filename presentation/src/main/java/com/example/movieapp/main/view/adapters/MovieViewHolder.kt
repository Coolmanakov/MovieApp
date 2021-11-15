package com.example.movieapp.main.view.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.movies.model.Movie
import com.example.movieapp.R

class MovieViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.movieTitle)
    private val subtitle = view.findViewById<TextView>(R.id.movieSubtitle)
    private val image = view.findViewById<ImageView>(R.id.movieImage)

    fun bind(movie: Movie?) {
        if (movie != null) {
            title.text = movie.title
            subtitle.text = movie.subtitle
            Glide.with(view).load(movie.multimedia.src).into(image)
        }
    }
}
