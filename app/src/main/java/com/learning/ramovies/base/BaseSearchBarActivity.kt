package com.learning.ramovies.base

import android.content.ContentResolver
import android.content.Context
import android.database.CharArrayBuffer
import android.database.ContentObserver
import android.database.Cursor
import android.database.DataSetObserver
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import com.learning.ramovies.R
import com.learning.ramovies.adapters.SearchSuggestionAdapter
import kotlinx.android.synthetic.main.app_bar_layout.*
import timber.log.Timber

abstract class BaseSearchBarActivity : BaseNavBarActivity(), SearchView.OnQueryTextListener {
    private lateinit var searchView: SearchView

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

    class Asdf : Cursor {
        override fun setNotificationUri(p0: ContentResolver?, p1: Uri?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun copyStringToBuffer(p0: Int, p1: CharArrayBuffer?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getExtras(): Bundle {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setExtras(p0: Bundle?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun moveToPosition(p0: Int): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getLong(p0: Int): Long {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun moveToFirst(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getFloat(p0: Int): Float {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun moveToPrevious(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getDouble(p0: Int): Double {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun close() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun isClosed(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun isFirst(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun isNull(p0: Int): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun unregisterContentObserver(p0: ContentObserver?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getColumnIndexOrThrow(p0: String?): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun requery(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getWantsAllOnMoveCalls(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getColumnNames(): Array<String> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getInt(p0: Int): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun isLast(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getType(p0: Int): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun registerDataSetObserver(p0: DataSetObserver?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun moveToNext(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getPosition(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun isBeforeFirst(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun registerContentObserver(p0: ContentObserver?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun moveToLast(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun deactivate() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getNotificationUri(): Uri {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getColumnName(p0: Int): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getColumnIndex(p0: String?): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getBlob(p0: Int): ByteArray {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getShort(p0: Int): Short {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getString(p0: Int): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun move(p0: Int): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getColumnCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun respond(p0: Bundle?): Bundle {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun unregisterDataSetObserver(p0: DataSetObserver?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun isAfterLast(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}