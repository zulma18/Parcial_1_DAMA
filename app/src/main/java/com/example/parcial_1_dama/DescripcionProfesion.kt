package com.example.parcial_1_dama

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DescripcionProfesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion_profesion)

        // Recuperar los datos del Intent
        val nombre = intent.getStringExtra("nombre")
        val foto = intent.getIntExtra("foto", R.drawable.doctora)
        val profesion = intent.getStringExtra("profesion")
        val acercaDe = intent.getStringExtra("acercaDe")
        val correo = intent.getStringExtra("correo")
        val telefono = intent.getStringExtra("telefono")

        // Establecer los datos en la interfaz
        findViewById<TextView>(R.id.tvNombre).text = nombre
        findViewById<TextView>(R.id.tvProfesion).text = profesion
        findViewById<TextView>(R.id.tvAcercaDe).text = acercaDe
        findViewById<TextView>(R.id.tvCorreo).text = correo
        findViewById<TextView>(R.id.tvTelefono).text = telefono
        findViewById<ImageView>(R.id.imvFoto).setImageResource(foto)

        // Configurar el botón de llamada
        findViewById<Button>(R.id.btnLlamar).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telefono"))
            startActivity(intent)
        }

        // Configurar el botón de WhatsApp
        findViewById<Button>(R.id.btnWhatsapp).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/$telefono"))
            startActivity(intent)
        }
    }
}
