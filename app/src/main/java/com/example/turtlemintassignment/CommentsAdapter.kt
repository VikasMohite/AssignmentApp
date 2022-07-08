package com.example.turtlemintassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentsAdapter(
    val context: Context,
    val commentsList: List<CommentsData>
) :
    RecyclerView.Adapter<CommentsAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val tv_commentInfo = itemView.findViewById<TextView>(R.id.tv_commentInfo)

        fun displayData(context: Context, issues: CommentsData) {
            tv_commentInfo.text = issues.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(context).inflate(R.layout.comments_list_item, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.displayData(context, commentsList[position])
    }

    override fun getItemCount(): Int {
        return commentsList.count()
    }

}