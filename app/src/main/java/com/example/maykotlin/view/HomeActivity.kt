package com.example.maykotlin.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.maykotlin.R
import com.example.maykotlin.ViewModel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var tvdescription : TextView
    lateinit var edtdescription : EditText
    lateinit var viewModel: HomeViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        tvdescription=findViewById(R.id.tv_description)
        edtdescription=findViewById(R.id.edt_description)

        edtdescription.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
               // TODO("Not yet implemented")
            }

            override fun onTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
                viewModel.updateDescription(p0.toString())
               // TODO("Not yet implemented")
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        viewModel.description.observe(this) {
            tvdescription.text = it
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}