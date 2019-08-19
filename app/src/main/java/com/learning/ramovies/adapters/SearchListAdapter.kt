package com.learning.ramovies.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learning.ramovies.R

class SearchListAdapter(private var context: Context, private var searchItems: List<String>) : RecyclerView.Adapter<SearchListAdapter.SearchViewHolder>(){
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = layoutInflater.inflate(R.layout.item_search_suggestion, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchItems.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
    }


    class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }
}