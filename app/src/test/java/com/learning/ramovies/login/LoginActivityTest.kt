package com.learning.ramovies.login

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class LandingActivityTest {
    private lateinit var loginActivity: LoginActivity

    @Before
    fun setup() {
        loginActivity = Robolectric
            .buildActivity(LoginActivity::class.java)
            .create()
            .resume()
            .get()
    }



    private fun assertActivityStarted(activityToStart: Class<*>){
        val shadowActivity = shadowOf(loginActivity)
        val startedIntent = shadowActivity.nextStartedActivity
        val shadowIntent = shadowOf(startedIntent)
        assertEquals(activityToStart.name, shadowIntent.intentClass.name)
    }
}