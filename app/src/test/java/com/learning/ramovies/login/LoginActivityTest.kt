package com.learning.ramovies.login

import com.learning.ramovies.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.shadows.ShadowIntent

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

    @Test
    fun shouldStartMainActivityWhenSkipBtnIsClicked() {
        loginActivity.skipBtn.performClick()

        val shadowIntent = getNextStartedActivityShadowIntent()
        assertEquals(MainActivity::class.java.name, shadowIntent.intentClass.name)
    }

    private fun getNextStartedActivityShadowIntent(): ShadowIntent {
        val shadowActivity = shadowOf(loginActivity)
        val startedIntent = shadowActivity.nextStartedActivity
        return shadowOf(startedIntent)
    }
}