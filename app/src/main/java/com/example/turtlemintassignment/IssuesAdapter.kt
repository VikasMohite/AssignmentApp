package com.example.turtlemintassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class IssuesAdapter(
    val context: Context,
    val issuesList: List<IssuesData>,
    val itemClick: (IssuesData) -> Unit
) :
    RecyclerView.Adapter<IssuesAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View, val itemCLick: (IssuesData) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        val tv_desc = itemView.findViewById<TextView>(R.id.tv_desc)
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name)
        val tv_updatedAt = itemView.findViewById<TextView>(R.id.tv_updatedAt)
        val iv_avatar = itemView.findViewById<ImageView>(R.id.iv_avatar)

        fun displayData(context: Context, issues: IssuesData) {
            tv_title.text = issues.title
            tv_desc.text = get200Chars(issues.body)
            tv_name.text = issues.username
            tv_updatedAt.text = convertDate(issues.updated_at, YYYY_MM_DD_T_HH_MM_SSZ, MM_DD_YYYY)

            Glide.with(context)
                .load(issues.avatar_url)
                .error(R.drawable.ic_profile)
                .placeholder(R.drawable.ic_profile)
                .into(iv_avatar)

            itemView.setOnClickListener { itemCLick(issues) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(context).inflate(R.layout.issues_list_item, parent, false)
        return MyViewHolder(inflater, itemClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.displayData(context, issuesList[position])
    }

    override fun getItemCount(): Int {
        return issuesList.count()
    }

}