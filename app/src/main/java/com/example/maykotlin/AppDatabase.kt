package com.example.maykotlin

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [StudentInfoData::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentInfoDao(): StudentInfoDao
}