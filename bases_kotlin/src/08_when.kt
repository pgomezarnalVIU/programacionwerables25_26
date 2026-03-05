fun main(){
    // when como expresión
    val dia = 3
    val diaNombre = when (dia) {
        1 -> "Lunes"
        2 -> "Martes"
        3 -> "Miércoles"
        4 -> "Jueves"
        5 -> "Viernes"
        6 -> "Sábado"
        7 -> "Domingo"
        else -> "Día no válido"
    }
    println("El día $dia es: $diaNombre")

    // when como sentencia o declaración
    val numero = 5
    when (numero) {
        in 1..10 -> println("$numero está entre 1 y 10")
        in 11..20 -> println("$numero está entre 11 y 20")
        else -> println("$numero está fuera de rango")
    }

    // when con varios casos para el mismo resultado
    val letra = 'A'
    when (letra) {
        'A', 'E', 'I', 'O', 'U' -> println("$letra es una vocal")
        else -> println("$letra es una consonante")
    }

    // when con rangos de valores
    val edad = 25
    when (edad) {
        in 0..12 -> println("Niño")
        in 13..19 -> println("Adolescente")
        in 20..64 -> println("Adulto")
        else -> println("Anciano")
    }


    // when con condiciones booleanas
    val temperatura = 30
    when {
        temperatura < 0 -> println("Hace mucho frío")
        temperatura in 0..15 -> println("Hace frío")
        temperatura in 16..25 -> println("Hace una temperatura agradable")
        else -> println("Hace calor")
    }

    // when con comrobación de tipos
    val valor = "Hola"
    when (valor) {
        is String -> println("Es una cadena de texto: $valor")
        is Int -> println("Es un número entero: $valor")
        else -> println("Tipo desconocido")
    }
}