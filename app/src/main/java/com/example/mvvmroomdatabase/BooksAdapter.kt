package com.example.mvvmroomdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroomdatabase.databinding.EachRowBinding
import com.example.mvvmroomdatabase.model.Books

class BooksAdapter(private val context: Context,private var stdList:ArrayList<Books>): RecyclerView.Adapter<BooksAdapter.UserViewHolder>() {
    //private var stdList:ArrayList<Books> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //val view=EachRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

//    fun setOnClickItem(callback:(PostModel)->Unit){
//        this.onClickItem=callback
//    }
//    fun setOnClickDeleteItem(callback: (PostModel) -> Unit){
//        this.onClickDeleteItem=callback
//    }

    override fun getItemCount(): Int {
        return stdList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val std=stdList[position]
        holder.id.text= std.id.toString()
        holder.name.text=std.name
        holder.author.text=std.author

//        holder.binding.txtid.text=std.id.toString()
//        holder.binding.txtbookname.text=std.name
//        holder.binding.txtauthor.text=std.author


    }
    fun setData(stdList:ArrayList<Books>){
        stdList.apply {
            clear()
            addAll(stdList)
        }
    }


    class UserViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        var id:TextView=itemView.findViewById(R.id.txtid)
        val name:TextView=itemView.findViewById(R.id.txtbookname)
        val author:TextView=itemView.findViewById(R.id.txtauthor)
    }
}