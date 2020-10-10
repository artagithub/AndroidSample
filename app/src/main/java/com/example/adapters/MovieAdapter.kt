package com.example.adapters

import android.content.Context
import android.view.*
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.entities.Search
import com.example.service.R
import com.sematec.basic.utils.load

class MovieAdapter(val context: Context, val items: MutableList<Search>) : BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.movie_item, p2, false)
        val item: Search = getItem(p0)

        val movieImage = view.findViewById<ImageView>(R.id.imageView)
        val movieTitle = view.findViewById<TextView>(R.id.movie_title_value)
        val movieYear = view.findViewById<TextView>(R.id.movie_year_value)
        val movieImdbId = view.findViewById<TextView>(R.id.movie_imdb_value)
        val likeImageView = view.findViewById<ImageView>(R.id.like)

        movieImage.load(context, item.poster)
        movieTitle.text = item.title
        movieYear.text = item.year
        movieImdbId.text = item.imdbID
        likeImageView.setOnTouchListener(object:View.OnTouchListener{

            val gestureDetector = GestureDetector(view.context,object : GestureDetector.SimpleOnGestureListener(){
                override fun onDoubleTap(e: MotionEvent?): Boolean {
                    likeImageView.setColorFilter(view.context.resources.getColor(R.color.red))
                    return super.onDoubleTap(e)
                }
            })

            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                gestureDetector.onTouchEvent(p1)
                return true
            }
        })
        view.setOnClickListener(View.OnClickListener {
            likeImageView.setColorFilter(context.resources.getColor(R.color.red))
        })

        return view

    }

    override fun getItem(position: Int): Search {
        return items.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}