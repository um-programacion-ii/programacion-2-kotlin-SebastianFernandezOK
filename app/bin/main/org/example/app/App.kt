package org.example.app

interface Perimetrable {
    fun calcularPerimetro(): Double
}

class Coche(private var _marca: String = "Ford", private var _modelo: Int = 2020) {
    var marca: String
        get() = _marca
        set(value) {
            _marca = value
        }
    var modelo: Int
        get() = _modelo
        set(value) {
            _modelo = value
        }
}

fun main() {
    println("=== Ejemplo con Coche ===")
    val coche = Coche("Chevrolet", 2025)
    println("Marca ${coche.marca}")
    println("Modelo ${coche.modelo}")
    
    println("\n=== Ejemplo con Perimetrables ===")
    val rectangulo = Rectangulo(5.0, 3.0)
    val circulo = Circulo(4.0)
    
    val formasPerimetrables: List<Perimetrable> = listOf(rectangulo, circulo)
    
    println("\nCalculando perímetros:")
    formasPerimetrables.forEach { forma ->
        when (forma) {
            is Rectangulo -> {
                println("Rectángulo (${forma.ancho} x ${forma.alto}): Perímetro = ${forma.calcularPerimetro()}")
            }
            is Circulo -> {
                println("Círculo (radio ${forma.radio}): Perímetro = ${forma.calcularPerimetro()}")
            }
        }
    }
}

class Rectangulo(val ancho: Double, val alto: Double) : Perimetrable {
    var area: Double

    init {
        area = ancho * alto
        println("Se ha creado un rectángulo de $ancho x $alto con un área de $area")
    }

    fun describir() {
        println("Este es un rectángulo.")
    }

    override fun calcularPerimetro(): Double {
        return 2 * (ancho + alto)
    }
}

class Circulo(val radio: Double) : Perimetrable {
    var area: Double

    init {
        area = Math.PI * radio * radio
        println("Se ha creado un círculo de radio $radio con un área de $area")
    }

    fun describir() {
        println("Este es un círculo.")
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}
