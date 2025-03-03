package com.example.parcial_1_dama.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_1_dama.R
import com.example.parcial_1_dama.profesion

class profesionAdapter (private val profesionList: List<profesion>, private val onClickListener: (profesion) -> Unit) : RecyclerView.Adapter<profesionesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): profesionesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return profesionesViewHolder(layoutInflater.inflate(R.layout.item_profesion, parent, false))
    }

    override fun getItemCount(): Int {
        return profesionList.size
    }

    override fun onBindViewHolder(holder: profesionesViewHolder, position: Int) {
        val item = profesionList[position]
        holder.render(item, onClickListener)
    }

}