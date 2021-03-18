package com.example.ktapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

 class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
     private var userlist = emptyList<User>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.data_row,parent,false))
     }

     override fun getItemCount(): Int {
         return userlist.size
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         var currentItem = userlist[position]
         holder.itemView.findViewById<TextView>(R.id.idno).text = currentItem.id.toString()
         holder.itemView.findViewById<TextView>(R.id.fname_id).text = currentItem.firstName
         holder.itemView.findViewById<TextView>(R.id.lname_id).text = currentItem.lastName
         holder.itemView.findViewById<TextView>(R.id.age_id).text = currentItem.age.toString()

     }
     fun setData(user: List<User>){
         this.userlist = user
         notifyDataSetChanged()
     }
 }