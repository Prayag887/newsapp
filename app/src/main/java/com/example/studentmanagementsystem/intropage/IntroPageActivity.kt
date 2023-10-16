package com.example.studentmanagementsystem.intropage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agronepal.mainpage.activity.MainPageUserActivity
import com.example.studentmanagementsystem.InputActivity
import com.example.studentmanagementsystem.LoginActivity
import com.example.studentmanagementsystem.StudentDataEntryActivity
import com.example.studentmanagementsystem.databinding.IntroPageActivityBinding


class IntroPageActivity : AppCompatActivity() {
    private lateinit var binding: IntroPageActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IntroPageActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdmin.setOnClickListener {
            val intent = Intent(this@IntroPageActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnUser.setOnClickListener {
            val intent = Intent(this@IntroPageActivity, MainPageUserActivity::class.java)
            startActivity(intent)
        }
    }
}