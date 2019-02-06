package com.cursoandroidkotlin.isaque.frasesdodia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var GerarNovaFrase: Button
    lateinit var Frase: TextView
    val frases = arrayOf("Frase 1", "Frase 2", "Frase 3", "Frase 4")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Frase = findViewById(R.id.textView) as TextView
        GerarNovaFrase = findViewById(R.id.button) as Button
    }
    fun gerarFrase(view: View)
    {
        val totalItensArray = frases.size
        val numeroAleatorio = Random.nextInt(4)
        //Frase.setText(frases[numeroAleatorio])
        Frase.text = frases[numeroAleatorio]
    }
}
