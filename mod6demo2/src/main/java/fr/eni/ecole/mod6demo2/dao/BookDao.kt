package fr.eni.ecole.mod6demo2.dao

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import fr.eni.ecole.mod6demo2.bo.Book
import fr.eni.ecole.mod6demo2.bo.BookContract

class BookDao(
    private val dbW: SQLiteDatabase,
    private val dbR: SQLiteDatabase
) {
    fun insertBook(book: Book): Boolean {
        val values = ContentValues().apply {
            put(BookContract.COLUMN_NAME, book.name)
            put(BookContract.COLUMN_ISBN, book.isbn)
            put(BookContract.COLUMN_RELEASE_DATE, book.releaseDate)
            put(BookContract.COLUMN_EDITOR, book.editor)
            put(BookContract.COLUMN_AUTHOR, book.author)
        }
        val newRowId = dbW.insert(BookContract.TABLE_NAME, null, values)
        //ceci n'est pas un litre (type Long)
        return newRowId != -1L
    }

    fun getAllBooks(): List<Book> {
        val projection = arrayOf(
            BaseColumns._ID,
            BookContract.COLUMN_NAME,
            BookContract.COLUMN_ISBN,
            BookContract.COLUMN_RELEASE_DATE,
            BookContract.COLUMN_EDITOR,
            BookContract.COLUMN_AUTHOR
        )
        var cursor = dbR.query(
            BookContract.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            "${BookContract.COLUMN_NAME} DESC"
        )
        val books = mutableListOf<Book>()
        with(cursor) {
            while (moveToNext()) {
                val book = Book(
                    id = getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    name = getString(getColumnIndexOrThrow(BookContract.COLUMN_NAME)),
                    isbn = getString(getColumnIndexOrThrow(BookContract.COLUMN_ISBN)),
                    releaseDate = getString(getColumnIndexOrThrow(BookContract.COLUMN_RELEASE_DATE)),
                    editor = getString(getColumnIndexOrThrow(BookContract.COLUMN_EDITOR)),
                    author = getString(getColumnIndexOrThrow(BookContract.COLUMN_AUTHOR)),
                )
                books.add(book)
            }
        }
        cursor.close()
        return books
    }
}