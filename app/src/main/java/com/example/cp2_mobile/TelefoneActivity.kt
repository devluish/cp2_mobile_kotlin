package com.example.cp2_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelefoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telefone)

        // Configura a seta de voltar
        val setaVoltar = findViewById<ImageView>(R.id.imageView)  // Usando o ID correto do layout
        setaVoltar.setOnClickListener {
            finish() // Finaliza a TelefoneActivity e volta à HomeActivity
        }

        // Ajustes para as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valorAssinaturaEditText = findViewById<EditText>(R.id.valor_assinatura)
        val chamadaCelularEditText = findViewById<EditText>(R.id.chamada_celular)
        val chamadaLocalEditText = findViewById<EditText>(R.id.chamada_local)
        val calcularButton = findViewById<Button>(R.id.button2)

        calcularButton.setOnClickListener {
            val valorAssinatura = valorAssinaturaEditText.text.toString().toDoubleOrNull() ?: 0.0
            val chamadasCelular = chamadaCelularEditText.text.toString().toIntOrNull() ?: 0
            val chamadasLocal = chamadaLocalEditText.text.toString().toIntOrNull() ?: 0

            val valorChamadaCelular = chamadasCelular * 0.20
            val valorChamadaLocal = chamadasLocal * 0.04
            val total = valorAssinatura + valorChamadaCelular + valorChamadaLocal

            val intent = Intent(this, TelefoneResultadoActivity::class.java).apply {
                putExtra("valor_assinatura", valorAssinatura)
                putExtra("valor_chamada_celular", valorChamadaCelular)
                putExtra("valor_chamada_local", valorChamadaLocal)
                putExtra("total", total)
            }
            startActivity(intent)
        }
    }
}
