package com.learning.ramovies.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.ramovies.R
import com.learning.ramovies.base.BaseActivity
import com.learning.ramovies.login.LoginActivity
import com.learning.ramovies.util.PARAM_HAS_ENTERED
import com.learning.ramovies.util.PARAM_IS_GUEST
import com.learning.ramovies.util.PARAM_UN
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityViewModel = getViewModel()

        if(intent.getBooleanExtra(PARAM_HAS_ENTERED, false)) {
            mainActivityViewModel.setUsername(intent.getStringExtra(PARAM_UN))
            mainActivityViewModel.setIsGuest(intent.getBooleanExtra(PARAM_IS_GUEST, true))
        } else {
            launchNewActivity(LoginActivity::class.java)
        }
    }

    override fun onResume() {
        super.onResume()

        updateToolbarTitle(mainActivityViewModel.getNavbarTitle())
        updateMenu(mainActivityViewModel.getMenuTitle(), mainActivityViewModel.isGuest())
    }

    /*
        Base Inherited Methods
     */
    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun currentActivity(): AppCompatActivity {
        return this
    }

    override fun getHeaderTitle(): String? {
        return mainActivityViewModel.getNavbarTitle()
    }
}
