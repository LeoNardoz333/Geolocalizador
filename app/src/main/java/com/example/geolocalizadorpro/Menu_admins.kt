package com.example.geolocalizadorpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Menu_admins : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admins)

        Regresar()
    }
    fun Regresar(){
        val regresar: FloatingActionButton = findViewById(R.id.btnRegresar)
        regresar.setOnClickListener {
        }
    }
}