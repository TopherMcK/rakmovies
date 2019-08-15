package com.learning.ramovies.main

import androidx.fragment.app.FragmentManager
import com.learning.ramovies.main.tabs.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPagerAdapterTest {
    @Mock
    private lateinit var fragmentManager: FragmentManager

    private lateinit var testObject: MainPagerAdapter

    @Before
    fun setup(){
        testObject = MainPagerAdapter(fragmentManager)
    }

    @Test
    fun countShouldBe5() {
        val expectedCount = 5

        assertEquals(expectedCount, testObject.count)
    }

    @Test
    fun getItemWhenPositionIs1FragmentShouldBeHomeTabFragment() {
        val actualFragment = testObject.getItem(0)

        assertTrue(actualFragment is HomeTabFragment)
    }

    @Test
    fun getItemWhenPositionIs2FragmentShouldBeTrendingTabFragment() {
        val actualFragment = testObject.getItem(1)

        assertTrue(actualFragment is TrendingTabFragment)
    }

    @Test
    fun getItemWhenPositionIs3FragmentShouldBeDumpsterTabFragment() {
        val actualFragment = testObject.getItem(2)

        assertTrue(actualFragment is DumpsterTabFragment)
    }

    @Test
    fun getItemWhenPositionIs4FragmentShouldBeFollowedTabFragment() {
        val actualFragment = testObject.getItem(3)

        assertTrue(actualFragment is FollowedTabFragment)
    }

    @Test
    fun getItemWhenPositionIs5FragmentShouldBeHistoryTabFragment() {
        val actualFragment = testObject.getItem(4)

        assertTrue(actualFragment is HistoryTabFragment)
    }
}