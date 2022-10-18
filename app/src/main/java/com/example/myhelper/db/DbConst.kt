package com.example.myhelper.db

import android.provider.BaseColumns

object DbConst {
    const val TABLE_NAME ="my_table"
    const val COLUMN_NAME_TITLE ="title"
    const val COLUMN_NAME_CONTENT ="content"

    const val PRICE = "PRICE"
    const val PRICE_WITH_COMMISION = "PRICE_WITH_COMMISSION"
    const val NAME_ITEM = "NAME_ITEM"
    const val QUANTITY = "QUANTITY"
    const val BUY = "BUY"
    const val SELL = "SELL"
    const val GROW = "GROW"
    const val SET_IMG = "SET_IMG"

    //"${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME_TITLE TEXT, $COLUMN_NAME_CONTENT TEXT)"

    const val DATABASE_VERSION = 3
    const val DATABASE_NAME = "MyLessonDb.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY,$NAME_ITEM TEXT, $QUANTITY TEXT, $BUY TEXT, $SELL TEXT, $GROW TEXT, $SET_IMG TEXT)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}