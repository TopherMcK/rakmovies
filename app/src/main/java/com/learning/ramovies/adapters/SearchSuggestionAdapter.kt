package com.learning.ramovies.adapters

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.SearchView
import android.widget.TextView
import com.learning.ramovies.R

class SearchSuggestionAdapter(context: Context, cursor: Cursor, searchView: SearchView) : CursorAdapter(context, cursor, false) {
    private lateinit var layoutInflater: LayoutInflater

    init {
        layoutInflater = LayoutInflater.from(context)
    }

    override fun newView(newContext: Context?, newCursor: Cursor?, parent: ViewGroup?): View {
        return layoutInflater.inflate(R.layout.item_search_suggestion, parent, false)
    }

    override fun bindView(bindingView: View?, bindingContext: Context?, bindingCursor: Cursor?) {
        val movieTitle = "a result"//bindingCursor!!.getString(bindingCursor!!.getColumnIndex(""))
        val titleTV = bindingView!!.findViewById<TextView>(R.id.search_item_text)
        titleTV.text = movieTitle
    }

}