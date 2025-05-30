package com.example.maykotlin.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maykotlin.R
import com.example.maykotlin.StudentInfoData

class RecyclerViewAdapter(private val list: List<StudentInfoData>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.rv_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item=list[position]
        holder.tvheading.text=item.name
        holder.tvdesc.text=item.enrollno

    }

    override fun getItemCount(): Int {
       return list.size;
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvheading : TextView = itemView.findViewById(R.id.tvName)
        val tvdesc : TextView = itemView.findViewById(R.id.tvDesc)

    }
}