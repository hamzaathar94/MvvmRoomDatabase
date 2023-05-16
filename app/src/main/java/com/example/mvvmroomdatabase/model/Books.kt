package com.example.mvvmroomdatabase.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Books(
    var name:String,
    var author:String){
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}
