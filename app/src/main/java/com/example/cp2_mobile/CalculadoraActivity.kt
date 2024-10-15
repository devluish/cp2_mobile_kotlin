package com.example.cp2_mobile

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        // Configura a seta de voltar
        val setaVoltar = findViewById<ImageView>(R.id.seta_voltar)
        setaVoltar.setOnClickListener {
            // Apenas finaliza a CalculadoraActivity, voltando automaticamente para a Home
            finish() // Finaliza a CalculadoraActivity e volta à HomeActivity
        }

        // Ajustes para as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
