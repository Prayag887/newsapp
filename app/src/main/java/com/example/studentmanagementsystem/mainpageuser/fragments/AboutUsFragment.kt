package com.example.studentmanagementsystem.mainpageuser.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.studentmanagementsystem.R
import com.example.studentmanagementsystem.databinding.FragmentAboutUsBinding

class AboutUsFragment : Fragment() {
    private lateinit var binding: FragmentAboutUsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutUsBinding.inflate(inflater, container, false)


        binding.btnDirGenViewprofile.setOnClickListener {
            val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.director_general_custom, null)
            val dialog = Dialog(requireContext())
            dialog.setContentView(dialogView)

            val btnCloseDialog = dialogView.findViewById<Button>(R.id.btnCloseDialog)
            btnCloseDialog.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }

        binding.btnDDGViewprofile.setOnClickListener {
            val dialogViewDDG = LayoutInflater.from(requireContext()).inflate(R.layout.deputy_director_general_custom, null)
            val dialogDDG = Dialog(requireContext())
            dialogDDG.setContentView(dialogViewDDG)

            val btnCloseDialog = dialogViewDDG.findViewById<Button>(R.id.btnCloseDialogDDG)
            btnCloseDialog.setOnClickListener {
                dialogDDG.dismiss()
            }

            dialogDDG.show()
        }

        binding.btnSpokespersonViewprofile.setOnClickListener {
            val dialogViewSP = LayoutInflater.from(requireContext()).inflate(R.layout.spokesperson_custom, null)
            val dialogSP = Dialog(requireContext())
            dialogSP.setContentView(dialogViewSP)

            val btnCloseDialog = dialogViewSP.findViewById<Button>(R.id.btnCloseDialogSP)
            btnCloseDialog.setOnClickListener {
                dialogSP.dismiss()
            }
            dialogSP.show()
        }

        binding.btnInfoofficerViewprofile.setOnClickListener {
            val dialogViewIO = LayoutInflater.from(requireContext()).inflate(R.layout.info_officer_custom, null)
            val dialogIO = Dialog(requireContext())
            dialogIO.setContentView(dialogViewIO)

            val btnCloseDialog = dialogViewIO.findViewById<Button>(R.id.btnCloseDialogIO)
            btnCloseDialog.setOnClickListener {
                dialogIO.dismiss()
            }
            dialogIO.show()
        }

        return binding.root
    }
}

