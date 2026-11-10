package Model

import com.godsfa.movimientod_i_ar_ab.R

class Cuadrado (var color: Int, var ancho: Int, var alto: Int) {
//coordenadas
    var x: Int = 0
    var y: Int = 0
    //metodos
    fun moverArriba() {
        y -= 10
    }
    fun moverAbajo() {
        y += 10
    }
    fun moverIzquierda() {
        x -= 10
    }
    fun moverDerecha() {
        x += 10
    }

    fun cambiarTamano(nuevoAncho: Int, nuevoAlto: Int) {
        ancho = nuevoAncho
        alto = nuevoAlto
    }



}




