package com.example.skiplineplayground

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Drawer
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val drawerNavView: NavigationView = findViewById(R.id.drawer_nav_view)
        val drawerNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.drawer_host_fragment) as NavHostFragment
        val drawerNavController = drawerNavHostFragment.navController
        drawerNavView.setupWithNavController(drawerNavController)
        appBarConfiguration = AppBarConfiguration(drawerNavController.graph, drawerLayout)
        setupActionBarWithNavController(drawerNavController, appBarConfiguration)


        //Bottom Nav
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val bottomNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.bottom_nav_host_fragment) as NavHostFragment
        val bottomNavController = bottomNavHostFragment.navController
        bottomNavView.setupWithNavController(bottomNavController)

        bottomNavView.setOnNavigationItemSelectedListener { item ->
            findViewById<View>(R.id.bottom_nav_host_fragment).visibility = View.GONE
            findViewById<View>(R.id.drawer_host_fragment).visibility = View.VISIBLE
            when (item.itemId) {
                R.id.menu -> {
                    drawerLayout.openDrawer(GravityCompat.START)
                    true
                }
                R.id.notifications -> {
                    findViewById<View>(R.id.drawer_host_fragment).visibility = View.GONE
                    findViewById<View>(R.id.bottom_nav_host_fragment).visibility = View.VISIBLE
                    bottomNavController.navigate(R.id.notifications_fragment)
                    true
                }
                R.id.home -> {
                    findViewById<View>(R.id.drawer_host_fragment).visibility = View.GONE
                    findViewById<View>(R.id.bottom_nav_host_fragment).visibility = View.VISIBLE
                    bottomNavController.navigate(R.id.home_fragment)
                    true
                }
                R.id.search -> {
                    findViewById<View>(R.id.drawer_host_fragment).visibility = View.GONE
                    findViewById<View>(R.id.bottom_nav_host_fragment).visibility = View.VISIBLE
                    bottomNavController.navigate(R.id.search_fragment)
                    true
                }
                R.id.profile -> {
                    findViewById<View>(R.id.drawer_host_fragment).visibility = View.GONE
                    findViewById<View>(R.id.bottom_nav_host_fragment).visibility = View.VISIBLE
                    bottomNavController.navigate(R.id.profile_fragment)
                    true
                }
                else -> {
                    findViewById<View>(R.id.bottom_nav_host_fragment).visibility = View.GONE
                    findViewById<View>(R.id.drawer_host_fragment).visibility = View.VISIBLE
                    false
                }
            }
        }
    }


    fun addToCart(view: View) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.drawer_host_fragment, CartFragment())
        transaction.disallowAddToBackStack()
        transaction.commit()
    }


}
