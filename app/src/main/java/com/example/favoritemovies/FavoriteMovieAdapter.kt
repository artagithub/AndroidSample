package com.example.favoritemovies

import android.content.Context
import android.view.*
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.MovieEntity
import com.example.entities.Search
import com.example.service.R
import com.sematec.basic.utils.load
import kotlinx.android.synthetic.main.movie_item.view.*




class FavoriteMovieAdapter(val context: Context, val items: List<MovieEntity>) :
    RecyclerView.Adapter<FavoriteMovieAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val movieImage = view.imageView
        val movieTitle = view.movie_title_value
        val movieYear = view.movie_year_value
        val movieImdbId = view.movie_imdb_value
//        val likeImageView = view.like
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder = MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.movie_item, parent, false
            )
        )


        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = items.get(position)

        item.poster?.let { holder.movieImage.load(context, it) }
        holder.movieTitle.text = item.title
        holder.movieYear.text = item.year
        holder.movieImdbId.text = item.imdbID
    }

    override fun getItemCount(): Int {
        return items.size
    }

    lateinit var actionClickHandler: ClickOnAction

    interface ClickOnAction {
        fun onActionClickListener(item: String)
    }

}