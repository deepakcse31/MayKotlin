package com.example.maykotlin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentInfoDao {

    @Insert
    suspend fun insert(studentInfo: StudentInfoData)

    @Query("SELECT * FROM student_info")
    suspend fun getAll(): List<StudentInfoData>
}