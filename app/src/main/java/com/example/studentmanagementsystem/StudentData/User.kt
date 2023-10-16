package com.example.studentmanagementsystem.StudentData


//THIS IS DTO

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user")
data class User(
    val name: String,
    val notice_headline: String,
    val news_content: String,
    val notice_content: String,
//    val age: String,
//    val book_library: String
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var roll_no: Int = 0

    override fun toString(): String {
        return name
    }
}

