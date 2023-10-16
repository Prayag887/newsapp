package com.example.agronepal

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.agronepal.mainpage.activity.MainPageUserActivity
import com.example.studentmanagementsystem.R


class MainUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_user)

        val viewPager = findViewById<ViewPager>(R.id.view_pager)
//        viewPager.adapter = ViewPagerAdapter(fa = supportFragmentManager)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val savedBoolean = sharedPreferences.getBoolean("first_time", true)
        if (savedBoolean) {
            val viewPager = findViewById<ViewPager>(R.id.view_pager)
//            viewPager.adapter = ViewPagerAdapter(fa = supportFragmentManager)
        } else {
            val intent = Intent(this@MainUserActivity, MainPageUserActivity::class.java)
            startActivity(intent)
        }
    }
}