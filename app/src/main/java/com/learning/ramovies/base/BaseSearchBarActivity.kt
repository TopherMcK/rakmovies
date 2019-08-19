package com.learning.ramovies.base

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.ramovies.R
import com.learning.ramovies.adapters.SearchListAdapter
import kotlinx.android.synthetic.main.app_bar_layout.*
import timber.log.Timber


abstract class BaseSearchBarActivity : BaseNavBarActivity(), SearchView.OnQueryTextListener {
    private lateinit var searchView: SearchView
    private lateinit var recyclerViewAdapter: RecyclerView.Adapter<SearchListAdapter.SearchViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSearchView()
    }

    private fun setupSearchView() {
        searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnSearchClickListener {
            nav_title_tv.visibility = View.GONE
        }

        searchView.setOnCloseListener {
            nav_title_tv.visibility = View.VISIBLE
            false
        }

        searchView.findViewById<ImageView>(R.id.search_button).setColorFilter(Color.WHITE)

        searchView.setOnQueryTextListener(this)

        val tempList = ArrayList<String>()
        tempList.add("hello 1")
        tempList.add("hello 2")

        val recyclerView = findViewById<RecyclerView>(R.id.search_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = SearchListAdapter(this, tempList)
        recyclerView.adapter = recyclerViewAdapter
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Timber.d("TODO")
        return false
    }

    private fun diplayResults() {
//        searchView.suggestionsAdapter = CursorAdapter(currentActivity().baseContext, Asdf()) {
//
//            fun newView(newContext: Context?, newCursor: Cursor?, parent: ViewGroup?): View {
//                return layoutInflater.inflate(R.layout.item_search_suggestion, parent, false)
//            }
//
//            fun bindView(bindingView: View?, bindingContext: Context?, bindingCursor: Cursor?) {
//                val movieTitle = "a result"//bindingCursor!!.getString(bindingCursor!!.getColumnIndex(""))
//                val titleTV = bindingView!!.findViewById<TextView>(R.id.search_item_text)
//                titleTV.text = movieTitle
//            }
//        }
    }

}