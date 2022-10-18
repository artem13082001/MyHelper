package com.example.myhelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener(this)

        val test = Intent(this, TestDb::class.java)

        val btntest = findViewById<Button>(R.id.btntext)

        btntest.setOnClickListener{
            startActivity(test)
        }

        //val textView = findViewById<TextView>(R.id.textView)
//
        //val btn = findViewById<Button>(R.id.btn)
//
        //btn.setOnClickListener{
        //val intent = Intent(this, Calculate::class.java)
        //intent.putExtra(Constants.USERNAME, textView.text.toString())
        //startActivity(intent)
        //}
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val activity_calculate = Intent(this, Calculate::class.java)
        val activity_inventory = Intent(this, Inventory::class.java)
        val activity_grow = Intent(this, Grow::class.java)

        when(item.itemId){
            R.id.id_calculate ->{
                startActivity(activity_calculate)
            }
            R.id.id_inventory ->{
                startActivity(activity_inventory)
            }
            R.id.id_grow ->{
                startActivity(activity_grow)
            }
        }

        return true
    }
}