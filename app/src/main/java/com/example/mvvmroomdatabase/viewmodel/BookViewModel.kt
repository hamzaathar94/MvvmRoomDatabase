package com.example.mvvmroomdatabase.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmroomdatabase.model.Books
import com.example.mvvmroomdatabase.repository.BooksRepository

class BookViewModel:ViewModel() {

    fun insert(context: Context,books: Books){
        BooksRepository.insert(context, books)
    }

    fun getAllBooksData(context: Context):LiveData<List<Books>>?{
        return BooksRepository.getAllBooksData(context)

    }
}