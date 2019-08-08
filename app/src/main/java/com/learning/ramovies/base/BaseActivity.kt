package com.learning.ramovies.base

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.learning.ramovies.R
import com.learning.ramovies.main.MainActivity
import kotlinx.android.synthetic.main.nav_header.*

abstract class BaseActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    @LayoutRes
    protected abstract fun layoutRes():Int

    protected abstract fun currentActivity(): AppCompatActivity

    protected abstract fun getHeaderTitle(): String?

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())

        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onResume() {
        super.onResume()
        setHeaderTitle()
    }

    private fun setHeaderTitle() {
        if(getHeaderTitle() != null) {
            header_title.text = getHeaderTitle()
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
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val activityToStart: Class<*>? = getActivityToStart(item.getItemId())
        var shouldActOnSelection = false

        if(activityToStart !== null) {
            shouldActOnSelection = true
            val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
            drawer.closeDrawer(GravityCompat.START)
            launchPatternActivity(activityToStart)
        }

        return shouldActOnSelection
    }

    private fun getActivityToStart(menuItemId: Int): Class<*>? {
        if(menuItemId == R.id.home && currentActivity() !is MainActivity) {
            return MainActivity::class.java
        } else {
            return null
        }
    }

    private fun launchPatternActivity(@Nullable activityToStart: Class<*>) {
        val newActivity = Intent(this.currentActivity(), activityToStart)
        this.startActivity(newActivity)
    }
}