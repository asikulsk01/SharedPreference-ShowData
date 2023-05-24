package com.example.sharedpreference_showdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(var studentList: ArrayList<Student>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView)
    }
    // it holds the view so views are not created everytime, so memory can be saved
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvRoll = itemView.findViewById<TextView>(R.id.tvRoll)


    }
    // how many list items are present in your array
    override fun getItemCount(): Int {
        return studentList.size
    }

    // populate items with data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]

        holder.tvName.text = currentItem.Name
        holder.tvRoll.text = currentItem.Roll
    }





    }
