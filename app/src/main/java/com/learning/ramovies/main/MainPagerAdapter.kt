package com.learning.ramovies.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.learning.ramovies.main.tabs.*

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment?

        when(position) {
            0 -> fragment = HomeTabFragment()

            1 -> fragment = TrendingTabFragment()

            2 -> fragment = DumpsterTabFragment()

            3 -> fragment = FollowedTabFragment()

            4 -> fragment = HistoryTabFragment()

            else -> fragment = null // This shouldn't be reached but if it is questions need to be raised around this mystery.
        }

        return fragment
    }

    override fun getCount(): Int {
        return 5
    }
}