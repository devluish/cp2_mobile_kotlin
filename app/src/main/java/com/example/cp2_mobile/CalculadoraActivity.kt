package com.example.cp2_mobile

import android.os.Bundle
import android.widget.*
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
            finish() // Finaliza a CalculadoraActivity e volta à HomeActivity
        }

        // Ajustes para as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referência aos campos e botões
        val valor1EditText = findViewById<EditText>(R.id.valor1)
        val valor2EditText = findViewById<EditText>(R.id.valor2)
        val radioGroupOperacoes = findViewById<RadioGroup>(R.id.radioGroupOperacoes)
        val calcularButton = findViewById<Button>(R.id.button5)

        // Ação do botão calcular
        calcularButton.setOnClickListener {
            // Obter valores dos EditTexts
            val valor1Str = valor1EditText.text.toString()
            val valor2Str = valor2EditText.text.toString()

            if (valor1Str.isNotEmpty() && valor2Str.isNotEmpty()) {
                val valor1 = valor1Str.toDoubleOrNull()
                val valor2 = valor2Str.toDoubleOrNull()

                if (valor1 != null && valor2 != null) {
                    // Obter operação selecionada
                    val operacaoId = radioGroupOperacoes.checkedRadioButtonId
                    val resultado: Double // Declara a variável sem inicializar

                    when (operacaoId) {
                        R.id.radioButtonSoma -> resultado = valor1 + valor2
                        R.id.radioButtonSubtracao -> resultado = valor1 - valor2
                        R.id.radioButtonMultiplicacao -> resultado = valor1 * valor2
                        R.id.radioButtonDivisao -> {
                            if (valor2 != 0.0) {
                                resultado = valor1 / valor2
                            } else {
                                Toast.makeText(this, "Divisão por zero não permitida!", Toast.LENGTH_SHORT).show()
                                return@setOnClickListener
                            }
                        }
                        else -> {
                            Toast.makeText(this, "Selecione uma operação", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                    }

                    // Exibir o resultado em um Toast
                    Toast.makeText(this, "Resultado = $resultado", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this, "Insira valores válidos!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha ambos os valores", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
