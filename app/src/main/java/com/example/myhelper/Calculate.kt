package com.example.myhelper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class Calculate : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        //val username = intent.getStringExtra(Constants.USERNAME)

        val edit_calc = findViewById<EditText>(R.id.edit_calc)
        val btn_calculate = findViewById<Button>(R.id.btn_calculate)
        val text_view = findViewById<TextView>(R.id.calculated)
        val text_history = findViewById<TextView>(R.id.text_history)
        val btn_back = findViewById<ImageView>(R.id.btn_back)
        val activity_calculate_history = Intent(this, Calculate_history::class.java)
        val text_commission = findViewById<TextView>(R.id.text_commission)

        text_history.setOnClickListener{
            startActivity(activity_calculate_history)
        }

        btn_back.setOnClickListener{
            finish()
        }



        btn_calculate.setOnClickListener{
            if(edit_calc.text.isNullOrEmpty())
                Toast.makeText(this, "Введите стоимость!", Toast.LENGTH_SHORT).show()
            else{
                var result = "%.2f".format(edit_calc?.text.toString().toFloat() * 100 / 87)
                text_view.text = result
                var commission = "%.2f".format(edit_calc?.text.toString().toFloat() * 13 / 87)
                text_commission.text = "Комиссия составляет: ${commission.toString()}"
                activity_calculate_history.putExtra(Constants.PRICE, edit_calc.text.toString())
                activity_calculate_history.putExtra(Constants.PRICE_WITH_COMMISION, text_view.text.toString())
            }
        }
    }

}