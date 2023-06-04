package com.example.trabajoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabajoandroid.fragments.VistaUsers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager?.beginTransaction()
            ?.replace(R.id.mainContainer, VistaUsers())?.addToBackStack(null)?.commit()
        // Mostrar como cuadricula
    }
}