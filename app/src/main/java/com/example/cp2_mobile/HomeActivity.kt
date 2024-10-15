package com.example.cp2_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Ajustes para as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referência dos botões
        val buttonCalculadora = findViewById<Button>(R.id.button_calculadora)
        val buttonContaTelefonica = findViewById<Button>(R.id.button_conta_telefonica)
        val buttonAluno = findViewById<Button>(R.id.button_aluno)

        // Navegação para a página Calculadora
        buttonCalculadora.setOnClickListener {
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }

        // Navegação para a página Conta Telefônica
        buttonContaTelefonica.setOnClickListener {
            val intent = Intent(this, TelefoneActivity::class.java)
            startActivity(intent)
        }

        // Exibir caixa de diálogo com informações dos alunos
        buttonAluno.setOnClickListener {
            showAlunoInfoDialog()
        }
    }

        // Mensagem como caixa de diálogo para aparecer os desenvolvedores do app
    private fun showAlunoInfoDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Desenvolvido por:")
        builder.setMessage("Luis Henrique - RM552692\nSabrina Café - RM553568\nMatheus Duarte - RM554199")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }
}
