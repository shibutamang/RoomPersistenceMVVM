package com.shibu.roompersistenceapp.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.shibu.roompersistenceapp.R
import com.shibu.roompersistenceapp.ui.fragments.HomeFragment
import android.support.v4.app.Fragment
import com.shibu.roompersistenceapp.ui.fragments.DashboardFragment
import com.shibu.roompersistenceapp.ui.fragments.NotificationFragment


class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fm.beginTransaction().hide(active).show(fragment1).commit();
                active = fragment1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                fm.beginTransaction().hide(active).show(fragment2).commit();
                active = fragment2
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fm.beginTransaction().hide(active).show(fragment3).commit();
                active = fragment3
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    val fragment1: Fragment = HomeFragment()
    val fragment2: Fragment = DashboardFragment()
    val fragment3: Fragment = NotificationFragment()
    val fm = supportFragmentManager
    var active = fragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit()
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit()
        fm.beginTransaction().add(R.id.main_container,fragment1, "1").commit()
    }
}
