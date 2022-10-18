package com.example.myhelper

import android.provider.BaseColumns

object Constants {
    val USERNAME = "UserName"
    val PRICE = "PRISE"
    val PRICE_WITH_COMMISION = "PRICE_WITH_COMMISSION"
    val NAME_ITEM = "NAME_ITEM"
    val QUANTITY = "QUANTUTY"
    val BUY = "BUY"
    val SELL = "SELL"
    val GROW = "GROW"

    const val TABLE_NAME ="my_table"
    const val COLUMN_NAME_TITLE ="title"
    const val COLUMN_NAME_CONTENT ="content"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyLessonDb.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME_TITLE TEXT, $COLUMN_NAME_CONTENT TEXT)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}