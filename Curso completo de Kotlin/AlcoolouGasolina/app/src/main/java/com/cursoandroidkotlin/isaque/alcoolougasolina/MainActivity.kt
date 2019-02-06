package com.cursoandroidkotlin.isaque.alcoolougasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun Calcular(view: View)
    {
        val precoAlcool = alcool.text.toString()
        val precoGasolina = gasolina.text.toString()
        var validaCampos = validarCampos(precoAlcool, precoGasolina)
        if(validaCampos){
            calcularMelhorPreço(precoAlcool, precoGasolina)
        }else{
            resultado.setText("Preencha os preços primeiros")
        }
    }
    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{
        var camposValidados: Boolean = true
        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if(precoGasolina == null || precoGasolina.equals(""))
        {
            camposValidados = false
        }
        return camposValidados
    }
    fun calcularMelhorPreço(precoAlcool: String, precoGasolina: String){
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()
        val resultadoPreco = valorAlcool/valorGasolina
        if(resultadoPreco >= 0.7){
            resultado.setText("Melhor utilizar Gasolina")
        }else{
            resultado.setText("Melhor utilizar Álcool")
        }
    }
}
