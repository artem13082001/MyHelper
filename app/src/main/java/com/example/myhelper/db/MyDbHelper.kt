package com.example.myhelper.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myhelper.Constants

class MyDbHelper(context: Context) : SQLiteOpenHelper(context, DbConst.DATABASE_NAME,
    null, DbConst.DATABASE_VERSION) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(DbConst.CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(DbConst.SQL_DELETE_TABLE)
        onCreate(p0)
    }
}