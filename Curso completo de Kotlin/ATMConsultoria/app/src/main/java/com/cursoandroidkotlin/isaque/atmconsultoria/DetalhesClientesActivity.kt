package com.cursoandroidkotlin.isaque.atmconsultoria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalhes_clientes.*

class DetalhesClientesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_clientes)
        val dados: Bundle = intent.extras
        textView.setText(dados.getString("nome"))
        //textView.text = dados.getString("nome")
    }
}
