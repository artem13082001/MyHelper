package com.example.myhelper.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.myhelper.Constants
import com.example.myhelper.ListItem

class MyDbManager(val context: Context) {
    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(name_item:String, quantity:String, buy:String, sell:String, grow:String, set_img:String){
        val values = ContentValues().apply {
            put(DbConst.NAME_ITEM, name_item)
            put(DbConst.QUANTITY, quantity)
            put(DbConst.BUY, buy)
            put(DbConst.SELL, sell)
            put(DbConst.GROW, grow)
            put(DbConst.SET_IMG, set_img)
        }
        db?.insert(DbConst.TABLE_NAME, null, values)

    }
    @SuppressLint("Range")
    fun readDbData():ArrayList<String>{
        val dataList = ArrayList<String>()
        val cursor = db?.query(DbConst.TABLE_NAME, null, null, null, null, null, null)
        with(cursor){
            while (cursor?.moveToNext()!!){
                val dataName = cursor.getString(cursor.getColumnIndex(DbConst.NAME_ITEM))
                val dataQuantity = cursor.getString(cursor.getColumnIndex(DbConst.QUANTITY))
                val dataBuy = cursor.getString(cursor.getColumnIndex(DbConst.BUY))
                val dataSell = cursor.getString(cursor.getColumnIndex(DbConst.SELL))
                val dataGrows = cursor.getString(cursor.getColumnIndex(DbConst.GROW))
                val dataSetImg = cursor.getString(cursor.getColumnIndex(DbConst.SET_IMG)).toInt()
                //list.add(ListItem(R.drawable.danger, "100", "Danger", "6p", "300p(200%)", "3p"))
                dataList.add(ListItem(dataSetImg, dataQuantity.toString(), dataName.toString(), dataSell.toString(), dataGrows.toString(), dataBuy.toString()).toString())
            }
        }
        cursor?.close()
        return dataList
    }

    fun closeDb(){
        myDbHelper.close()
    }
}