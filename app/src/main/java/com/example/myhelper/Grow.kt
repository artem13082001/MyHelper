package com.example.myhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Grow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grow)

        val btn_back = findViewById<ImageView>(R.id.btn_back)

        btn_back.setOnClickListener{
            finish()
        }

    }
}