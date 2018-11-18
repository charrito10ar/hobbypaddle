package com.marbit.hobbypaddle.presentation.ui.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.marbit.hobbypaddle.R
import com.marbit.hobbypaddle.presentation.presenters.DashboardPresenter
import com.marbit.hobbypaddle.presentation.ui.activities.interfaces.DashboardView
import com.marbit.hobbypaddle.presentation.ui.fragments.ClubsFragment
import com.marbit.hobbypaddle.presentation.ui.fragments.MenuFragment
import com.marbit.hobbypaddle.presentation.ui.fragments.ShopFragment
import kotlinx.android.synthetic.main.activity_main.*

class DashboardActivity : AppCompatActivity(), DashboardView {

    lateinit var presenter: DashboardPresenter

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                showSectionSelected(ClubsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                showSectionSelected(ShopFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                showSectionSelected(MenuFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun showSectionSelected(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

}