package com.learning.ramovies.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learning.ramovies.R
import com.learning.ramovies.models.ombd.Movie
import com.squareup.picasso.Picasso
import timber.log.Timber

class SearchListAdapter(private val context: Context, private var movies: List<Movie>) : RecyclerView.Adapter<SearchListAdapter.SearchViewHolder>(){
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = layoutInflater.inflate(R.layout.item_search_suggestion, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val movie = movies.get(position)
        holder.searchItemText.text = movie.Title

//        Picasso.get().load(movie.Poster).into(holder.searchItemPoster)
    }


    class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val searchItemText: TextView = view.findViewById(R.id.search_item_text)
//        val searchItemPoster: ImageView = view.findViewById(R.id.search_item_poster)
    }
}