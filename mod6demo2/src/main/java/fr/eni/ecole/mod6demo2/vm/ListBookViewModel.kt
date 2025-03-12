package fr.eni.ecole.mod6demo2.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import fr.eni.ecole.mod6demo2.bo.Book
import fr.eni.ecole.mod6demo2.dao.BookDao
import fr.eni.ecole.mod6demo2.helper.BookDbHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListBookViewModel(dbHelper: BookDbHelper) : ViewModel() {
    private val dao = BookDao(dbHelper.writableDatabase, dbHelper.readableDatabase)

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books = _books

    init {
        viewModelScope.launch {
            insertBook(
                Book(
                    0L,
                    "Le meilleur des mondes",
                    "1234564876",
                    "19/05/2025",
                    "Gallimard",
                    "Albert Camus"
                )
            )
            getAllBooks()
        }
    }

    suspend fun insertBook(book: Book) {
        withContext(Dispatchers.IO) {
            dao.insertBook(book)
        }
    }

    suspend fun getAllBooks() {
        withContext(Dispatchers.IO) {
            val booksDB = dao.getAllBooks()
            _books.value = booksDB
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return ListBookViewModel(BookDbHelper(application.applicationContext)) as T
            }
        }
    }
}
