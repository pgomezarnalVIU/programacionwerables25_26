fun main(){
    // Creamos array con los productos básicos para hacer una tortilla de patatas
    val ingredientes = arrayOf("patatas","huevos","aceite","sal")

    // Array del mismo numero de elementos que el de ingredientes
    // para las cantidades
    val cantidades = Array<Int> (ingredientes.size) {0}

    // Recorrer un array
    ingredientes.forEach {
        // Preguntamos al usuario si tiene el ingrediente
        println("¿Tienes ${it}? [s|n]")
        val respuesta = readln()
        if (respuesta.equals("s", ignoreCase = true)){
            println("¿Cuantas unidades/cantidades tienes de ${it}")
            val cantidad = readln()
            cantidades[ingredientes.indexOf(it)] = cantidad.toInt()
        } else {
            println("¿Cuantas unidades/cantidades necesitas de ${it}")
            val cantidad = readln()
            cantidades[ingredientes.indexOf(it)] = -1*cantidad.toInt()
        }
    }

    // Imprimir los ingredientes y las cantidades
    println("----- INGREDIENTES Y CANTIDADES -----")
    for (i in ingredientes.indices){
        println("${ingredientes[i]}: ${cantidades[i]}")
    }
}