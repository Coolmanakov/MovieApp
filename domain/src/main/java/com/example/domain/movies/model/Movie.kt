package com.example.domain.movies.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey var id: Int,
    @field:SerializedName("display_title") val title: String,
    @field:SerializedName("summary_short") val subtitle: String,
    val multimedia: @RawValue Multimedia

    //ignore this values, by the way we won't them to display
//    @Ignore @field:SerializedName("byline") val author: String,
//    @Ignore val critics_pick: Int,
//    @Ignore val date_updated: String,
//    @Ignore val headline: String,
//    @Ignore val link: @RawValue Link,
//    @Ignore @field:SerializedName("mpaa_rating") val rating: String,
//    @Ignore val opening_date: String,
//    @Ignore val publication_date: String
) : Parcelable