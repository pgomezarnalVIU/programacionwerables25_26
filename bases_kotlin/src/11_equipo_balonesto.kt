fun menu_principal():Int{
    println("Seleccione una opción:")
    println("1. Agregar jugador")
    println("2. Mostrar jugadores")
    println("3. Salir")
    return readlnOrNull()?.toIntOrNull() ?: 0
}


fun main(){
    //Nuevo diccionario que represente a un equipo de baloncesto
    val equipo_baloncesto = mutableMapOf<String, Int>()

    //Bucle infinito
    while (true){
        when (menu_principal()){
            1 -> {
                println("Introducir el nombre del jugador: ")
                val nombre_jugador:String = readln()
                val anotacion_jugador: Int = readln().toIntOrNull() ?: 0
                equipo_baloncesto[nombre_jugador] = anotacion_jugador
                println("Jugador $nombre_jugador agregado con anotacion $anotacion_jugador")
            }
            2 -> {
                println("Jugadores en el equipo:")
                for ((nombre,anotacion) in equipo_baloncesto){
                    println("$nombre: $anotacion puntos")
                }
            }
            3 -> {
                println("Saliendo del programa ...")
                break
            }
            else -> println("Opcion no válida. Por favor, intente de nuevo")
        }
    }
}