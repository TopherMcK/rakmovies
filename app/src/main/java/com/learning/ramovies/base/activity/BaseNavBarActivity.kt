package com.learning.ramovies.base.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.learning.ramovies.R
import kotlinx.android.synthetic.main.app_bar_layout.*
import org.apache.commons.lang3.StringUtils

abstract class BaseNavBarActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    var menu: Menu? = null

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        updatedNavBar()
    }

    private fun updatedNavBar() {
            val toolBar = findViewById<Toolbar>(R.id.toolbar)
            toolBar.title = StringUtils.EMPTY

            setSupportActionBar(toolBar)
            val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
            val navView = findViewById<NavigationView>(R.id.nav_view)

            val hamburger = toolBar.findViewById<ImageButton>(R.id.hamburgerBtn)
            navView.setNavigationItemSelectedListener(this)
            hamburger.setOnClickListener {
                drawerLayout.openDrawer(navView)
            }
    }

    protected fun updateToolbarTitle(title: String?) {
        if(StringUtils.isNotEmpty(title)) {
            nav_title_tv.text = title
        }
    }

    protected fun updateMenu(isLoggedIn: Boolean) {
        if(isLoggedIn && menu != null) {
            menu!!.findItem(R.id.return_to_login).title = this.getString(R.string.sign_out)
        }
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        this.menu = menu
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val activityToStart: Class<*>? = getActivityToStart(item.itemId)
        var shouldActOnSelection = false

        if(activityToStart !== null) {
            shouldActOnSelection = true
            val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
            drawer.closeDrawer(GravityCompat.START)
            launchNewActivity(activityToStart)
        }

        return shouldActOnSelection
    }
}