package com.example.myhelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.myhelper.db.MyDbManager

class AddNewItem : AppCompatActivity() {

    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_item)

        //intent.putExtra(Constants.USERNAME, textView.text.toString())

        val btn_back = findViewById<ImageView>(R.id.btn_back)
        val btn_send_item = findViewById<Button>(R.id.btn_send_item)
        val add_name = findViewById<EditText>(R.id.add_name)
        val add_quantity = findViewById<EditText>(R.id.add_quantity)
        val add_buy = findViewById<EditText>(R.id.add_buy)
        val add_sell = findViewById<EditText>(R.id.add_sell)
        val add_grow = findViewById<TextView>(R.id.add_grow)
        var list = ArrayList<ListItem>()

        val activity_inventory = Intent(this, Inventory::class.java)

        //    myDbManager.insertToDb(ed_title.text.toString(), ed_content.text.toString())
        //    val dataList = myDbManager.readDbData()
        //    for (item in dataList){
        //        tv_test.append(item)
        //        tv_test.append("\n")
        //    }
        //    myDbManager.closeDb()

        btn_back.setOnClickListener{
            finish()
        }

        btn_send_item.setOnClickListener{
            //if(add_name.text.isNullOrEmpty()) Toast.makeText(this, "Введите наименование предмета!", Toast.LENGTH_SHORT).show()
            //if(add_quantity.text.isNullOrEmpty()) Toast.makeText(this, "Введите количество!", Toast.LENGTH_SHORT).show()
                //if(add_buy.text.isNullOrEmpty()) Toast.makeText(this, "Введите стоимость покупки!", Toast.LENGTH_SHORT).show()
                    //if(add_sell.text.isNullOrEmpty()) Toast.makeText(this, "Введите стоимость продажи!", Toast.LENGTH_SHORT).show()
                        //if(add_grow.text.isNullOrEmpty()) Toast.makeText(this, "Введите рост!", Toast.LENGTH_SHORT).show()
            myDbManager.insertToDb(add_name.toString(), add_quantity.toString(), add_buy.toString(), add_sell.toString(), add_grow.toString(), "1")
        }

    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

}