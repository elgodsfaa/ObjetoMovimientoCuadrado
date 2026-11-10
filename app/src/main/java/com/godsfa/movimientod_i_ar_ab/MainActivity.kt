package com.godsfa.movimientod_i_ar_ab

import Model.Cuadrado
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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


        val cuadradoRojo = findViewById<View>(R.id.cuadradoRojo)
        //
        cuadradoRojo.post {
            val inicialX = cuadradoRojo.x.toInt()
            val inicialY = cuadradoRojo.y.toInt()
            val iniciaAncho = cuadradoRojo.layoutParams.width
            val inicialAlto = cuadradoRojo.layoutParams.height

            //creamos  el objeto cuadrado
            val cuadrado: Cuadrado = Cuadrado(ContextCompat.getColor(this, R.color.red), iniciaAncho, inicialAlto).apply {
                x = inicialX
                y = inicialY
            }
            val botonArriba = findViewById<Button>(R.id.botonArriba)
            val botonAbajo = findViewById<Button>(R.id.botonAbajo)
            val botonIzq = findViewById<Button>(R.id.botonIzq)
            val botonDrch = findViewById<Button>(R.id.botonDrch)
            val botonCambiarTamano = findViewById<Button>(R.id.botonCambiarTamano)
            val botonCambiarColor = findViewById<Button>(R.id.botonCambiarColor)
            //actualizamos la vista o listeners
            botonArriba.setOnClickListener {
                cuadrado.moverArriba()
                actualizarVista(cuadradoRojo, cuadrado)

            }
            botonAbajo.setOnClickListener {
                cuadrado.moverAbajo()
                actualizarVista(cuadradoRojo, cuadrado)

            }
            botonIzq.setOnClickListener {
                cuadrado.moverIzquierda()
                actualizarVista(cuadradoRojo, cuadrado)
            }
            botonDrch.setOnClickListener {
                cuadrado.moverDerecha()
                actualizarVista(cuadradoRojo, cuadrado)
            }
            botonCambiarTamano.setOnClickListener {
                cuadrado.cambiarTamano(200,200)
                actualizarVista(cuadradoRojo, cuadrado)

            }
            botonCambiarColor.setOnClickListener {
                cuadrado.color = generarColorAleatorio()
                //cuadrado.color = ContextCompat.getColor(this, R.color.blue)
                cuadradoRojo.setBackgroundColor(cuadrado.color)

            }
        }
        }

    fun actualizarVista(cuadradoRojo : View, cuadrado : Cuadrado) {
        cuadradoRojo.layoutParams.width = cuadrado.ancho
        cuadradoRojo.layoutParams.height = cuadrado.alto
        cuadradoRojo.setBackgroundColor(cuadrado.color)
        cuadradoRojo.y = cuadrado.y.toFloat()
        cuadradoRojo.x = cuadrado.x.toFloat()
        //para que se ejecuten los cambios
        cuadradoRojo.requestLayout()

    }
    fun generarColorAleatorio(): Int {
        //Genarar numeros aleatorios
        val random = Random.Default
        //asignamos valores comprendidos entre o y 255
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)
        return Color.rgb(red, green, blue)
    }
}
