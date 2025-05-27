package com.example.maykotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var edtname1 :EditText
    lateinit var edtenrollno:EditText
    lateinit var edtmobileno:EditText
    lateinit var btnsubmit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        edtname1=findViewById(R.id.edtname)
        edtenrollno=findViewById(R.id.edtenrollno)
        edtmobileno=findViewById(R.id.edtmobileno)
        btnsubmit=findViewById(R.id.btnsubmit)

        btnsubmit.setOnClickListener {
            val name=edtname1.text.toString()
            val enrollno=edtenrollno.text.toString()
            val mobileno=edtmobileno.text.toString()
            Log.e("name",name+enrollno+mobileno)
            val studentInfoData = StudentInfoData(name = name, enrollno = enrollno, mobileno = mobileno)
            GlobalScope.launch {
                MyApplication.database.studentInfoDao().insert(studentInfoData)
                edtname1.setText("")
                edtmobileno.setText("")
                edtenrollno.setText("")

            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}