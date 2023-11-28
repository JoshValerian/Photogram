package com.JMGames.photogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUser = findViewById<EditText>(R.id.etUser)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            val valor = etUser.text.toString()

            // Crear un Intent para pasar a la CreditActivity
            val intent = Intent(this@MainActivity, CreditActivity::class.java)

            // Agregar el valor del EditText como extra en el Intent
            intent.putExtra("user", valor)

            // Iniciar la CreditActivity
            startActivity(intent)
        }
    }
}