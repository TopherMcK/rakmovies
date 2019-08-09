package com.learning.ramovies.base

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.learning.ramovies.R
import com.learning.ramovies.login.LoginActivity
import com.learning.ramovies.main.MainActivity
import kotlinx.android.synthetic.main.app_bar_main.*

abstract class BaseActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var menu: Menu

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())

        if(shouldUseNav()) {
            val toolBar = findViewById<Toolbar>(R.id.toolbar)
            toolBar.title = this.getString(R.string.default_username)

            setSupportActionBar(toolBar)
            val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
            val navView = findViewById<NavigationView>(R.id.nav_view)

//            val toggle = ActionBarDrawerToggle(
//                this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
//            )

//            drawerLayout.addDrawerListener(toggle)
//            toggle.syncState()

            navView.setNavigationItemSelectedListener(this)
        }
    }

    protected fun updateToolbarTitle(title: String?) {
        if(toolbar != null && title != null) {
            toolbar.title = title
        }
    }

    protected fun updateMenu(title: String?, isGuest: Boolean) {
        if(!isGuest && title != null && menu != null) {
            currentActivity().findViewById<TextView>(R.id.header_title).text = title
            menu.findItem(R.id.return_to_login).title = this.getString(R.string.sign_out)
        }
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if(drawerLayout != null) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
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

    @LayoutRes
    protected abstract fun layoutRes():Int

    protected abstract fun currentActivity(): AppCompatActivity

    protected open fun getHeaderTitle(): String? {
        return null
    }

    protected open fun shouldUseNav(): Boolean {
        return true
    }

    private fun getActivityToStart(menuItemId: Int): Class<*>? {
        var classToStart: Class<*>? = null

        if(menuItemId == R.id.home && currentActivity() !is MainActivity) {
            classToStart = MainActivity::class.java
        } else if (menuItemId == R.id.return_to_login && currentActivity() !is LoginActivity) {
            classToStart = LoginActivity::class.java
        }

        return classToStart
    }

    protected fun launchNewActivity(@NonNull activityToStart: Class<*>) {
        val newActivity = Intent(this.currentActivity(), activityToStart)
        launchNewActivity(newActivity)
    }

    protected fun launchNewActivity(@NonNull newActivity: Intent) {
        this.startActivity(newActivity)
    }

    protected open fun isGuest(): Boolean {
        return true
    }
}