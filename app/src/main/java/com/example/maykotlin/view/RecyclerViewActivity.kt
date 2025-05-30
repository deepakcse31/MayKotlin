package com.example.maykotlin.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maykotlin.MyApplication
import com.example.maykotlin.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var rvlist : RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        rvlist=findViewById(R.id.rvlist)
        GlobalScope.launch {
            rvlist.layoutManager= LinearLayoutManager(this@RecyclerViewActivity)
            val adapter= RecyclerViewAdapter( MyApplication.database.studentInfoDao().getAll())
            rvlist.adapter=adapter

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}