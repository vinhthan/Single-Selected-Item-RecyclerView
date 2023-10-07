package com.example.singleselecteditemrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Adapter: RecyclerView.Adapter<Adapter.AdapterViewHolder>() {

    var listUser = mutableListOf<UserEntity>()

    var selectPosition = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return AdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(listUser[position])

        if (selectPosition == position) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.color_DC1A1A))
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
        }

        holder.itemView.setOnClickListener {
            val positions = position
            if (positions != RecyclerView.NO_POSITION) {
                notifyItemChanged(selectPosition)
                selectPosition = position
                notifyItemChanged(selectPosition)
            }
        }



    }

    class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvId = itemView.findViewById<TextView>(R.id.tv_id)
        var tvName = itemView.findViewById<TextView>(R.id.tv_name)
        fun bind(userEntity: UserEntity) {
            tvId.text = userEntity.id.toString()
            tvName.text = userEntity.name
        }
    }
}