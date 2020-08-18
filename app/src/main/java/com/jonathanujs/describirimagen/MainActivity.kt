package com.jonathanujs.describirimagen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnReinicar.isEnabled = false;
        btnComprobar.setOnClickListener { validateResp() }
        btnReinicar.setOnClickListener { restar() }
    }

    val listValues = arrayOf("Zorra", "Zorro", "zorra", "zorro", "ZORRO", "ZORRA");
    var counter:Int = 3
    fun validateResp(){
        if(editResponse.text.isEmpty())
            Toast.makeText(this,"Favor de ingresar una respuesta.",Toast.LENGTH_SHORT).show();
        else
        {
            if(editResponse.text.toString() in listValues){
                Toast.makeText(this,"Felicidades has ganado", Toast.LENGTH_LONG).show();
                btnComprobar.isEnabled = false;
                btnReinicar.isEnabled = true;
                editResponse.isEnabled = false;
            }
            else{
                counter -= 1;
                editResponse.text.clear();

                if (counter > 0){
                    Toast.makeText(this,"Lo sentimos, respuesta incorrecta, te quedan ${counter.toString()} intentos.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"Lo sentimos, no tienes más intentos pero puedes reiniciar el juego.", Toast.LENGTH_LONG).show();
                    btnComprobar.isEnabled = false;
                    btnReinicar.isEnabled = true;
                }
            }
        }
    }

    fun restar(){
        editResponse.text.clear();
        btnComprobar.isEnabled = true;
        btnReinicar.isEnabled = false;
        counter = 3;
    }
}