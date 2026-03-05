fun main(){
    // Declaramos las variables que vamos a usar
    var huevos = false
    var patatas = false
    var cebollas = false

    // Preguntamos al usuario si tiene huevos
    println ("¿Tienes huevos? [s|n]?")
    val respuesta_huevos = readln()
    if (respuesta_huevos.equals("s", ignoreCase = true)){
        huevos = true
    }

    // Preguntamos al usuario si tiene patatas
    println ("¿Tienes patatas? [s|n]?")
    val respuesta_patatas = readln()
    if (respuesta_patatas.equals("s", ignoreCase = true)){
        patatas = true
    }

    // Preguntamos al usuario si tiene cebollas
    println ("¿Tienes cebollas? [s|n]?")
    val respuesta_cebollas = readln()
    if (respuesta_cebollas.equals("s", ignoreCase = true)){
        cebollas = true
    }

    // Verificamos si tenemos todos los ingredientes
    if ( huevos && patatas && cebollas ){
        println(" SALE TORTILLA!!!! ")
    } else{
        println("CORRE AL SUPER A POR LOS INGREDIENTES")
    }

}