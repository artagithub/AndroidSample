package com.example.movie;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.entities.Search
import com.example.service.R
import com.sematec.basic.utils.load
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieRecyclerAdapter(val context: Context, val items: List<Search>) :
    RecyclerView.Adapter<MovieRecyclerAdapter.MyHolder>() {

    class MyHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val movieTitle: TextView = view.movie_title_value
        val movieYear: TextView = view.movie_year_value
        val movieImdb: TextView = view.movie_imdb_value
        val movieImage: ImageView = view.imageView
        val like: View = view.like
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val holder = MyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.movie_item, parent, false
            )
        )

        holder.like.setOnClickListener {
            onImageClickListener.onLikeClicked(items.get(holder.adapterPosition))
        }



        return holder
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = items.get(position)
        holder.movieTitle.text = item.title.toString()
        holder.movieYear.text = item.year.toString()
        holder.movieImdb.text = item.imdbID.toString()
        holder.movieImage.load(context, item.poster)


    }

    override fun getItemCount(): Int {
        return items.size
    }

    lateinit var onImageClickListener: ImageClickListener

    interface ImageClickListener {
        fun onLikeClicked(movie: Search)
    }
}