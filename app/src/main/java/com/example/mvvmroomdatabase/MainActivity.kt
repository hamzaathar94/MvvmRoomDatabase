package com.example.mvvmroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.mvvmroomdatabase.databinding.ActivityMainBinding
import com.example.mvvmroomdatabase.model.Books
import com.example.mvvmroomdatabase.viewmodel.BookViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
//    private var binding:ActivityMainBinding?=null
    private var bookViewModel:BookViewModel?=null
    var button:FloatingActionButton?=null
    private var builder:AlertDialog.Builder?=null
    private var dialog:AlertDialog?=null
    private var name:EditText?=null
    private var author:EditText?=null
    private var save:Button?=null
    private var recyclerView:RecyclerView?=null
    private var booksAdapter:BooksAdapter?=null
//    private var books:Books?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

    booksAdapter=BooksAdapter(this@MainActivity,ArrayList<Books>())

    recyclerView=findViewById(R.id.recyclerview)
    recyclerView?.apply {
        layoutManager=LinearLayoutManager(this@MainActivity)
        adapter=booksAdapter
    }

        bookViewModel= ViewModelProvider(this)[BookViewModel::class.java]
        bookViewModel!!.getAllBooksData(applicationContext)?.observe(this, Observer {

            booksAdapter!!.setData(it as ArrayList<Books>)
        })

    button=findViewById(R.id.btnadd)
    button!!.setOnClickListener {
        openDialog()
    }


    }

    private fun openDialog() {
        builder=AlertDialog.Builder(this)
        var itemView:View=LayoutInflater.from(applicationContext).inflate(R.layout.dialog,null)
        dialog=builder?.create()
        dialog?.setView(itemView)

        name=itemView.findViewById(R.id.edtxtbookname)
        author=itemView.findViewById(R.id.edtxtauthor)
        save=itemView.findViewById(R.id.btnsave)

        save?.setOnClickListener {
            storedata()
        }
        dialog?.show()
    }

    private fun storedata() {
        val getName=name?.text.toString()
        val getAuthor=name?.text.toString()

        bookViewModel?.insert(this,Books(getName,getAuthor))

        dialog?.dismiss()
    }

//    private fun showBooks() {
//        booksAdapter=BooksAdapter(this,ArrayList<Books>())
//        binding?.recyclerview?.apply {
//            layoutManager=LinearLayoutManager(this@MainActivity)
//            adapter=booksAdapter.apply {
//                setData(List<Books>)
//            }
//        }
//    }
//
//    private fun saveData() {
//        val bookname=binding?.editTextTextPersonName?.text.toString()
//        val author=binding?.editTextTextPersonName2?.text.toString()
//
//        if (binding?.editTextTextPersonName?.text!!.isEmpty() &&
//                binding?.editTextTextPersonName2?.text!!.isEmpty()){
//            Toast.makeText(this,"Fields are empty...",Toast.LENGTH_SHORT).show()
//        }
//        else{
//
//        }
//    }

}