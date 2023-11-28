package com.JMGames.photogram

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        // Obtener el valor del Intent
        val nUser = intent.getStringExtra("user")
        val tvTus = findViewById<TextView>(R.id.tus)

        tvTus.apply {
            //toma el valor de la cadena "greeting" y le incorpora el valor del nombre.
            text = getString(R.string.tuser,nUser)
        }

        val btnEmail = findViewById<Button>(R.id.btnEmail)

        btnEmail.setOnClickListener {
            sendEmail()
        }
    }

    private fun sendEmail() {
        // Dirección de correo electrónico a la que se enviará el correo
        val email = "jlopcac0801@g.educaand.es"

        // Asunto del correo
        val subject = "Consulta de la app ${getString(R.string.app_name)}"

        // Crear un Intent con la acción ACTION_SENDTO
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$email")
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)

        // Verificar si hay una aplicación de correo electrónico disponible para manejar el Intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}