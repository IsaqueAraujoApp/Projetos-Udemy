package com.cursoandroidkotlin.isaque.primeiroprojetocurso

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun Jogar(view: View)
    {
        var texto = findViewById<TextView>(R.id.textosorteio)
        // var texto = findViewById(R.id.textosorteio) as TextView
        var numeroSorteado = Random.nextInt(11)
        texto.setText("Numéro sorteado é: $numeroSorteado")
    }
}
