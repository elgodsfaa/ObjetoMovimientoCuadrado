package com.godsfa.movimientod_i_ar_ab

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val botonArriba = findViewById<Button>(R.id.botonArriba)
        val botonIzq = findViewById<Button>(R.id.botonIzq)
        val botonDrch = findViewById<Button>(R.id.botonDrch)
        val botonAbajo = findViewById<Button>(R.id.botonAbajo)
        val botonCambiarTamaño = findViewById<Button>(R.id.botonCambiarTamano)
        val botonCambiarColor = findViewById<Button>(R.id.botonCambiarColor)
        val cuadradoRojo = findViewById<View>(R.id.cuadradoRojo)

        botonArriba.setOnClickListener {
            cuadradoRojo.translationY = cuadradoRojo.translationY - 10


        }
        botonIzq.setOnClickListener {
            cuadradoRojo.translationX = cuadradoRojo.translationX - 10

        }
        botonDrch.setOnClickListener {
            cuadradoRojo.translationX = cuadradoRojo.translationX + 10

        }
        botonAbajo.setOnClickListener {
            cuadradoRojo.translationY = cuadradoRojo.translationY + 10

        }

        botonCambiarTamaño.setOnClickListener {
            val nuevoAncho = cuadradoRojo.width + 10
            val nuevoAlto = cuadradoRojo.height + 10
            cuadradoRojo.layoutParams.width = nuevoAncho
            cuadradoRojo.layoutParams.height = nuevoAlto
            cuadradoRojo.requestLayout()


        }

        botonCambiarColor.setOnClickListener {
            val colorAleatorio = android.graphics.Color.rgb(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )
            cuadradoRojo.setBackgroundColor(colorAleatorio)
        }
    }
}
