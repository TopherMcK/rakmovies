package com.learning.ramovies.base

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import com.learning.ramovies.R
import kotlinx.android.synthetic.main.app_bar_layout.*
import timber.log.Timber

abstract class BaseSearchBarActivity : BaseNavBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSearchView()
    }

    private fun setupSearchView() {
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnSearchClickListener {
            nav_title_tv.visibility = View.GONE
        }

        searchView.setOnCloseListener {
            nav_title_tv.visibility = View.VISIBLE
            false
        }

        searchView.findViewById<ImageView>(R.id.search_button).setColorFilter(Color.WHITE)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                Timber.d("TODO")
                return false
            }
        })
    }
}