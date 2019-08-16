package com.learning.ramovies.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.learning.ramovies.R
import com.learning.ramovies.base.BaseSearchBarActivity
import com.learning.ramovies.login.LoginActivity
import com.learning.ramovies.util.UserConstants
import kotlinx.android.synthetic.main.content_main.*
import org.apache.commons.lang3.StringUtils
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseSearchBarActivity() {
    private val tabIcons: IntArray = intArrayOf(
        R.mipmap.home,
        R.mipmap.trending,
        R.mipmap.dumpster,
        R.mipmap.followed,
        R.mipmap.history
    )

    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityViewModel = getViewModel()

        if(savedInstanceState == null) {
            if (intent.getBooleanExtra(UserConstants.PARAM_HAS_ENTERED, false)) {
                mainActivityViewModel.setUsername(intent.getStringExtra(UserConstants.PARAM_UN))
            } else {
                launchNewActivity(LoginActivity::class.java)
            }
        }

        updateToolbarTitle(mainActivityViewModel.getNavbarTitle())
        updateMenu(StringUtils.isNotEmpty(mainActivityViewModel.getUsername()))
        setupPagerAdapter()
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

    private fun setupPagerAdapter(){
        val viewPager = pager as ViewPager
        val duckPagerAdapter = MainPagerAdapter(supportFragmentManager)
        viewPager.adapter = duckPagerAdapter
        val tabLayout = tablayout as TabLayout
        tabLayout.setupWithViewPager(viewPager)

        setupTabIcons()
    }

    private fun setupTabIcons() {
        for(i in 0..tablayout.tabCount) {
            if(i < tabIcons.size) {
                tablayout.getTabAt(i)?.icon = getDrawable(tabIcons[i])
            }
        }
    }

    companion object {
        private const val PARAM_HAS_ENTERED = "PARAM_HAS_ENTERED"
        private const val PARAM_UN = "PARAM_UN"

        fun createIntent(userName: String?, context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(PARAM_HAS_ENTERED, true)
            intent.putExtra(PARAM_UN, userName)

            return intent
        }
    }
}
