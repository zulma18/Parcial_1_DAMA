package com.example.parcial_1_dama

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_1_dama.adapter.profesionAdapter
import com.example.parcial_1_dama.profesionesProvider
import com.example.parcial_1_dama.profesion

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar RecyclerView
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val provider = profesionesProvider()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_profesionales)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = profesionAdapter(provider.profesionalesList) { profesion ->
            onItemSelected(profesion)
        }

        // Agregar una línea divisoria entre elementos
        val decoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(decoration)
    }

    private fun onItemSelected(profesion: profesion) {
        // Crear un Intent para abrir la actividad de descripción de la profesión
        val intent = Intent(this, DescripcionProfesion::class.java).apply {
            putExtra("nombre", profesion.nombre)
            putExtra("foto", profesion.foto) // Asumiendo que 'foto' es un recurso de imagen
            putExtra("profesion", profesion.profesion)
            putExtra("acercaDe", profesion.acercaDe)
            putExtra("correo", profesion.correo)
            putExtra("telefono", profesion.telefono)
        }
        startActivity(intent)
    }
}
