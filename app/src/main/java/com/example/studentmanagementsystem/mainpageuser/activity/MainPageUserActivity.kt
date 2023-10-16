package com.example.agronepal.mainpage.activity

import HomeFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.agronepal.mainpage.fragments.NewsFragment
import com.example.bussewa.amenities.fragment.NoticeFragment
import com.example.studentmanagementsystem.R
import com.example.studentmanagementsystem.databinding.ActivityMenuBinding
import com.example.studentmanagementsystem.mainpageuser.fragments.AboutUsFragment
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainPageUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var bottomBar: AnimatedBottomBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomBar = binding.bottomBar

        replaceFragment(HomeFragment())


        bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener{
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when(newIndex){
                    0->replaceFragment(HomeFragment())
                    1->replaceFragment(NoticeFragment())
                    2->replaceFragment(NewsFragment())
                    3->replaceFragment(AboutUsFragment())
                }
            }
        })
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragments, fragment).commit()
    }
}

