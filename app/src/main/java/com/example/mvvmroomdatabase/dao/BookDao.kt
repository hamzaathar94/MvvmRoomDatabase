package com.example.mvvmroomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmroomdatabase.model.Books

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(books: Books)

    @Query("SELECT * FROM books ORDER BY id asc")
    fun getAllBooksData():LiveData<List<Books>>
}