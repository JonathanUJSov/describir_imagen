package com.jonathanujs.describirimagen

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado);
        val palabraIngresada = intent.extras!!["palabra_ingresada"] as String;
        resultado.text = palabraIngresada;
    }
}