package com.example.myhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Calculate_history : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_history)

        var add_stroke = findViewById<TextView>(R.id.text_stroke)

        var price = arrayListOf<String>()
        var p:String = intent.getStringExtra(Constants.PRICE).toString()
        price.add(p)

        var price_with_commission = arrayListOf<String>()
        var c:String = intent.getStringExtra(Constants.PRICE_WITH_COMMISION).toString()
        price.add(c)

        add_stroke.text = p + "   ->   " + c

        val btn_back = findViewById<ImageView>(R.id.btn_back)

        btn_back.setOnClickListener{
            finish()
        }

    }
}