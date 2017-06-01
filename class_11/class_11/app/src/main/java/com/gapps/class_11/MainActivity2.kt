package com.gapps.class_11

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView

import com.gapps.class_11.dummy.DummyContent

class MainActivity2 : AppCompatActivity(), Fragment1.OnListFragmentInteractionListener, Fragment2.OnListFragmentInteractionListener, Fragment3.OnListFragmentInteractionListener {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var fragment: Fragment? = null
        var fragmentClass: Class<*>? = null
        when (item.itemId) {
            R.id.navigation_home -> fragmentClass = Fragment1::class.java
            R.id.navigation_dashboard -> fragmentClass = Fragment2::class.java
            R.id.navigation_notifications -> fragmentClass = Fragment3::class.java
            else -> fragmentClass = Fragment1::class.java
        }

        try {
            fragment = fragmentClass!!.newInstance() as Fragment
        } catch (e: Exception) {
            e.printStackTrace()
            return@OnNavigationItemSelectedListener false
        }

        // Insert the fragment by replacing any existing fragment
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit()
        title = item.title
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragmentClass = Fragment1::class.java
        var fragment: Fragment? = null
        try {
            fragment = fragmentClass!!.newInstance() as Fragment
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit()
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem) {
        startActivity(Intent(this@MainActivity2, Main3Activity::class.java))
    }
}
