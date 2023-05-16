package com.example.mvvmroomdatabase.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvmroomdatabase.database.BooksDatabase
import com.example.mvvmroomdatabase.model.Books
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BooksRepository {

    companion object{
        private var booksDatabase:BooksDatabase?=null
        fun initialiseDB(context: Context):BooksDatabase?{
            return BooksDatabase.getInstance(context)

        }

        fun insert(context: Context,books: Books){

            booksDatabase= initialiseDB(context)
            CoroutineScope(Dispatchers.IO).launch {
                booksDatabase?.getDao()?.insert(books)

            }

        }

        fun getAllBooksData(context: Context):LiveData<List<Books>>{
            booksDatabase= initialiseDB(context)
            return booksDatabase?.getDao()!!.getAllBooksData()
        }
    }

}