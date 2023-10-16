package com.example.agronepal.mainpage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmanagementsystem.StudentData.AppDatabase
import com.example.studentmanagementsystem.databinding.FragmentNewsBinding
import com.example.studentmanagementsystem.mainpageuser.adapter.AmenitiesAdapter
import kotlinx.coroutines.launch

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            val userList = context?.let { AppDatabase(it).userDao().getAllUser() }
            binding.rvNews.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = AmenitiesAdapter().apply {
                    if (userList != null) {
                        setData(userList)
                    }
                }

            }
        }
        return binding.root
    }
}

