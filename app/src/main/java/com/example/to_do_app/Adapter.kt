package com.example.todo

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.animated.R

class Adapter(private val data: List<Adapter.viewHolder>) : RecyclerView.Adapter<Adapter.viewHolder>() {

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.title)
        var priority = itemView.findViewById<TextView>(R.id.priority)
        var layout = itemView.findViewById<LinearLayout>(R.id.mylayout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(com.example.to_do_app.R.layout.view, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        when (data[position].priority.toLowerCase()) {
            "high" -> holder.layout.setBackgroundColor(Color.parseColor("#F05454"))
            "medium" -> holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#00917C"))
        }

        holder.title.text = data[position].title
        holder.priority.text = data[position].priority
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateCard::class.java)
            intent.putExtra("id", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
