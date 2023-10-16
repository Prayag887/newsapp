package com.example.studentmanagementsystem

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.studentmanagementsystem.StudentData.AppDatabase
import com.example.studentmanagementsystem.StudentData.User
import com.example.studentmanagementsystem.databinding.FillUpFormBinding
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class InputActivity : AppCompatActivity() {
    private lateinit var binding: FillUpFormBinding
    private var user: User? = null
    var News_Content =
        ("[\\s\\S]*")

    var Notice_headline = ("[\\s\\S]*")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FillUpFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val source = intent.getStringExtra("source")
        if (source == "edit") {
            user = intent.getSerializableExtra("Data") as User
            binding.addOrUpdateBtn.text = "Update"
            binding.noBtn.text = "Cancel"
            binding.eTFullName.setText(user?.name.toString())
            binding.eTPhone.setText(user?.notice_headline.toString())
            binding.eTEmail.setText(user?.news_content.toString())
            binding.eTExamGrades.setText(user?.notice_content.toString())
        }

        binding.addOrUpdateBtn.setOnClickListener {
            addUser()
        }

        binding.noBtn.setOnClickListener {
            finish()
        }

    }

    private fun isValidEmail(email: String): Boolean {
        return Pattern.compile(News_Content).matcher(email).matches()
    }

    private fun isValidPhone(number: String): Boolean {
//        it returns true if the number of numeral in phone is 10
        return Pattern.matches(Notice_headline, number)
    }

    private fun addUser() {
        val News_Headline = binding.eTFullName.text.toString()
        val News_Content = binding.eTEmail.text.toString()
        val Notice_Headline = binding.eTPhone.text.toString()

//        val grade = binding.eTExamGrades.text.toString()
        val Notice_Content = binding.eTExamGrades.text.toString()
        val emailError = findViewById<EditText>(R.id.eTEmail)
        val phoneError = findViewById<EditText>(R.id.eTPhone)


        lifecycleScope.launch {
//            initializing the variables to store the input texts
            if (isValidEmail(News_Content) == false) {
                Toast.makeText(this@InputActivity, "Email address error", Toast.LENGTH_SHORT).show()
                emailError.setBackgroundColor(Color.RED)
                emailError.background.setTint(resources.getColor(R.color.error))
            } else if (isValidPhone(Notice_Headline) == false) {
                emailError.setBackgroundColor(Color.GREEN)
                emailError.background.setTint(resources.getColor(R.color.success))
                Toast.makeText(this@InputActivity, "Phone number error", Toast.LENGTH_SHORT).show()
                phoneError.setBackgroundColor(Color.RED)
                phoneError.background.setTint(resources.getColor(R.color.error))
            } else {
                if (user == null) {
                    val user = User(name = News_Headline, notice_headline = Notice_Headline, news_content = News_Content, notice_content =Notice_Content)
                    AppDatabase(this@InputActivity).userDao().addUser(user)
                } else {
                    val u = User(News_Headline, Notice_Headline, News_Content, Notice_Content)
                    u.roll_no = user?.roll_no ?: 0
                    AppDatabase(this@InputActivity).userDao().updateUser(u)
                }
                //return back to original page where we created
                val intent = Intent()
                intent.putExtra("MESSAGE", "Data Saved Successfully!!!!")
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}
