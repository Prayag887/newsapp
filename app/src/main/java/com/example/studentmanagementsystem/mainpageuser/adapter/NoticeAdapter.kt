package com.example.studentmanagementsystem.mainpageuser.adapter

import android.app.AlertDialog
import android.content.Context
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanagementsystem.R
import com.example.studentmanagementsystem.StudentData.User

class NoticeAdapter : RecyclerView.Adapter<NoticeAdapter.ViewHolder>() {
    private var list = mutableListOf<User>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvHeadline: TextView = itemView.findViewById(R.id.tv_notice_headline)
        val tvNews: TextView = itemView.findViewById(R.id.notice)
        val btnNews: TextView = itemView.findViewById(R.id.btn_notice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.notice_rv_display, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = list[position]
        holder.tvHeadline.text = user.notice_headline
        holder.tvNews.text = user.notice_content
        holder.btnNews.setOnClickListener {
            val context = holder.itemView.context
            val message = user.notice_content
            val alerttitle = user.notice_headline
            showPopup(context, alerttitle, message)
    }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(data: List<User>) {
        list.apply {
            clear()
            addAll(data)
        }
    }

    fun showPopup(context: Context, title: String, message: String) {
//        val alertDialogBuilder = AlertDialog.Builder(context)
        val alertDialogBuilder = AlertDialog.Builder(context, R.style.CustomDialogStyle)
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("OK", null)

        // Set the dialog title
        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage(message)

        val alertDialog = alertDialogBuilder.create()

        // Set the text color for the message
//        val textColorWhite = context.resources.getColor(R.color.white)
//        alertDialog.setMessage(Html.fromHtml("<font color='$textColorWhite'>$message</font>"))

        // Apply the text color for the message
        val textColorWhite = context.resources.getColor(R.color.white)
        val spannableStringBuilder = SpannableStringBuilder(message)
        spannableStringBuilder.setSpan(ForegroundColorSpan(textColorWhite), 0, spannableStringBuilder.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        alertDialog.setMessage(spannableStringBuilder)

        // Set the text color for the title
        val textColorGreen = context.resources.getColor(R.color.green)
        alertDialog.setTitle(Html.fromHtml("<font color='$textColorGreen'>$title</font>"))

        alertDialog.show()
    }
}
