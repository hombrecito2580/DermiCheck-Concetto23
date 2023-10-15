package com.example.masterstack23.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.masterstack23.R
import com.example.masterstack23.data.BlogData
import com.example.masterstack23.data.BlogDataMongo
import com.example.masterstack23.ui.BlogActivity

class BlogAdapter(private val blogList:ArrayList<BlogData>, val context: Context): RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    inner class BlogViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val title: TextView = v.findViewById(R.id.tvTitle)
        val tag: TextView = v.findViewById(R.id.tvTag)
        val img: ImageView = v.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val inflater= LayoutInflater.from(context)
        val v= inflater.inflate(R.layout.blogtile,parent,false)
        return BlogViewHolder(v)
    }

    override fun getItemCount(): Int {
        return blogList.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val newList = blogList[position]
        holder.title.text = newList.title
        holder.tag.text = newList.text1
        holder.img.setImageResource(newList.image)
        holder.itemView.setOnClickListener{
            val intent = Intent(context, BlogActivity::class.java)
            intent.putExtra("Title",newList.title)
            intent.putExtra("text1",newList.text1)
            intent.putExtra("text2",newList.text2)
            intent.putExtra("image",newList.image)
            context.startActivity(intent)
        }
    }

}