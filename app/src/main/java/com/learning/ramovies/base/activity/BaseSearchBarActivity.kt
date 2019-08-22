package com.learning.ramovies.base.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.ramovies.R
import com.learning.ramovies.adapters.SearchListAdapter
import com.learning.ramovies.base.viewmodel.BaseSearchViewModel
import com.learning.ramovies.models.ombd.Movie
import kotlinx.android.synthetic.main.app_bar_layout.*
import org.apache.commons.lang3.StringUtils


abstract class BaseSearchBarActivity : BaseNavBarActivity(), SearchView.OnQueryTextListener {
    private lateinit var searchView: SearchView
    private lateinit var recyclerViewAdapter: RecyclerView.Adapter<SearchListAdapter.SearchViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSearchView()
        searchViewModel().searchLiveData().observe(this, Observer {
            diplayResults(it)
        })
    }

    private fun setupSearchView() {
        searchView = findViewById(R.id.searchView)
        searchView.setOnSearchClickListener {
            nav_title_tv.visibility = View.GONE
        }

        searchView.setOnCloseListener {
            nav_title_tv.visibility = View.VISIBLE
            val emptyMovies: List<Movie> = ArrayList()
            diplayResults(emptyMovies)
            false
        }

        searchView.findViewById<ImageView>(R.id.search_button).setColorFilter(Color.WHITE)

        searchView.setOnQueryTextListener(this)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if(StringUtils.isNotBlank(newText)) {
            searchViewModel().sendSearchRequest(newText!!)
        }
        return false
    }

    private fun diplayResults(titles: List<Movie>) {
        val layoutManager = LinearLayoutManager(this)

        val recyclerView = findViewById<RecyclerView>(R.id.search_rv)
        recyclerView.layoutManager = layoutManager

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerViewAdapter = SearchListAdapter(this, titles)
        recyclerView.adapter = recyclerViewAdapter
    }

    protected abstract fun searchViewModel(): BaseSearchViewModel
}