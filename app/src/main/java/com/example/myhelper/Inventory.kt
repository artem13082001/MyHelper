package com.example.myhelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myhelper.db.MyDbManager

class Inventory : AppCompatActivity() {

    val myDbManager = MyDbManager(this)
    var list = ArrayList<ListItem>()

    val rcView:RecyclerView by lazy { findViewById(R.id.rcView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        val btn_back = findViewById<ImageView>(R.id.btn_back)
        val btn_add_item = findViewById<Button>(R.id.btn_add_item)

        btn_back.setOnClickListener {
            finish()
        }

        btn_add_item.setOnClickListener {
            val activity_add_new_item = Intent(this, AddNewItem::class.java)
            startActivity(activity_add_new_item)
        }

        //list.add(ListItem(R.drawable.semafor_red, intent.getStringExtra(Constants.QUANTITY).toString(), intent.getStringExtra(Constants.NAME_ITEM).toString(), intent.getStringExtra(Constants.SELL).toString(), intent.getStringExtra(Constants.GROW).toString(), intent.getStringExtra(Constants.BUY).toString()))

        //val username = intent.getStringExtra(Constants.USERNAME)

        list.add(ListItem(R.drawable.danger, "100", "Danger", "6p", "300p(200%)", "3p"))
        //list.add(ListItem(R.drawable.chromo, "200", "Chroma 2", "10p", "2000p(400%)", "2.5p"))
        //list.add(ListItem(R.drawable.falshion, "100", "Falshion", "6p", "300p(200%)", "3p"))
        //list.add(ListItem(R.drawable.danger, "100", "Danger", "6p", "300p(200%)", "3p"))
        //list.add(ListItem(R.drawable.chromo, "200", "Chroma 2", "10p", "2000p(400%)", "2.5p"))
        //list.add(ListItem(R.drawable.falshion, "100", "Falshion", "6p", "300p(200%)", "3p"))
        //list.add(ListItem(R.drawable.danger, "100", "Danger", "6p", "300p(200%)", "3p"))
        //list.add(ListItem(R.drawable.chromo, "200", "Chroma 2", "10p", "2000p(400%)", "2.5p"))
        //list.add(ListItem(R.drawable.falshion, "100", "Falshion", "6p", "300p(200%)", "3p"))
        //list.add(ListItem(R.drawable.danger, "100", "Danger", "6p", "300p(200%)", "3p"))
        //list.add(ListItem(R.drawable.chromo, "200", "Chroma 2", "10p", "2000p(400%)", "2.5p"))
        //list.add(ListItem(R.drawable.falshion, "100", "Falshion", "6p", "300p(200%)", "3p"))

        //val rcView = findViewById<RecyclerView>(R.id.rcView)
        //rcView.hasFixedSize()
        //rcView.layoutManager = LinearLayoutManager(this)
        //rcView.adapter = MyAdapter(list, this)

    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        val dataList = myDbManager.readDbData()
        list.add(ListItem(R.drawable.danger, "100", "Danger", "6p", "300p(200%)", "3p"))
        for (item in dataList) {
            var Rlist = item
            list.add(ListItem(R.drawable.danger, Rlist[1].toString(), Rlist[2].toString(), Rlist[3].toString(), Rlist[4].toString(), Rlist[5].toString()))
        }
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = MyAdapter(list, this)
    }

    fun getItem (){

    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

}