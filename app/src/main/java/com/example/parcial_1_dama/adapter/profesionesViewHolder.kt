package com.example.parcial_1_dama.adapter

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_1_dama.DescripcionProfesion
import com.example.parcial_1_dama.R
import com.example.parcial_1_dama.profesion

class profesionesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imgFoto: ImageView = view.findViewById(R.id.imvFoto)
    private val tvNombre: TextView = view.findViewById(R.id.tvNombre)
    private val tvProfesion: TextView = view.findViewById(R.id.tvProfesion)

    fun render(profesion: profesion, onClickListener: (profesion) -> Unit) {
        tvNombre.text = profesion.nombre
        tvProfesion.text = profesion.profesion
        imgFoto.setImageResource(profesion.foto)

        // Abrir la actividad de detalles cuando el usuario hace clic en un item
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, DescripcionProfesion::class.java).apply {
                putExtra("nombre", profesion.nombre)
                putExtra("profesion", profesion.profesion)
                putExtra("foto", profesion.foto)
                putExtra("acercaDe", profesion.acercaDe)
                putExtra("correo", profesion.correo)
                putExtra("telefono", profesion.telefono)
            }
            itemView.context.startActivity(intent)
        }
    }
}
