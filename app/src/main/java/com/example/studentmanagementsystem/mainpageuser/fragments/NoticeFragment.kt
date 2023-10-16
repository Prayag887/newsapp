package com.example.bussewa.amenities.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmanagementsystem.R
import com.example.studentmanagementsystem.StudentData.AppDatabase
import com.example.studentmanagementsystem.databinding.FragmentNewsBinding
import com.example.studentmanagementsystem.databinding.FragmentNoticeBinding
import com.example.studentmanagementsystem.mainpageuser.adapter.AmenitiesAdapter
import com.example.studentmanagementsystem.mainpageuser.adapter.NoticeAdapter
import kotlinx.coroutines.launch

class NoticeFragment : Fragment() {
    private lateinit var binding: FragmentNoticeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoticeBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            val userList = context?.let { AppDatabase(it).userDao().getAllUser() }
            binding.rvNotice.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = NoticeAdapter().apply {
                    if (userList != null) {
                        setData(userList)
                    }
                }

            }
        }
        return binding.root
    }
}
