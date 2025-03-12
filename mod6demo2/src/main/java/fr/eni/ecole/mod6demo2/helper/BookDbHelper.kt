package fr.eni.ecole.mod6demo2.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import fr.eni.ecole.mod6demo2.bo.BookContract
import fr.eni.ecole.mod6demo2.bo.BookContract.DATABASE_NAME
import fr.eni.ecole.mod6demo2.bo.BookContract.DATABASE_VERSION

class BookDbHelper(context: Context) :
    SQLiteOpenHelper(
        context,
        BookContract.DATABASE_NAME,
        null,
        BookContract.DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(BookContract.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(BookContract.SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}