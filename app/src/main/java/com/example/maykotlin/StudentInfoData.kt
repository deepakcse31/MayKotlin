package com.example.maykotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_info")
data class StudentInfoData(
    @PrimaryKey(autoGenerate = true) val id: Int =0, val name:String, val enrollno:String, val mobileno:String)
