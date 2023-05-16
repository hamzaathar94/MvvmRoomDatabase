package com.example.mvvmroomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmroomdatabase.dao.BookDao
import com.example.mvvmroomdatabase.model.Books

@Database(entities = [Books::class], version = 1, exportSchema = false)
abstract class BooksDatabase: RoomDatabase() {

    abstract fun getDao():BookDao
    companion object{
        private val DATABASE_NAME="BooksDatabase"

        @Volatile
        var instance:BooksDatabase?=null

        fun getInstance(context: Context):BooksDatabase?{

            if (instance==null){
                synchronized(BooksDatabase::class.java){
                    if (instance==null){
                        instance= Room.databaseBuilder(context,BooksDatabase::class.java,
                            DATABASE_NAME).build()
                    }
                }
            }
            return instance
        }
    }

}