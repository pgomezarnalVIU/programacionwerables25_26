fun main(){
    // CREACIÓN DE ARRAYS
    val nombres = arrayOf("Paco","Francisco","Pancho","Pepe")
    val arrayVacio = emptyArray<Int>()

    println("nombres[0]=${nombres[0]}")

    /*El contenido del array es MUTABLE*/
    val nuevoArray = Array<Float>(10) {1.0f}
    val simpleArray = Array<Int>(3) { 0 }
    println("simpleArray="+simpleArray.joinToString())

    println("tamanyo de nombres="+nombres.size)

    // RECORRER UN ARRAY
    for (i in 0..nombres.size-1){
        println("nombres[$i]="+nombres[i])
    }
    for (i in nombres.indices){
        println("nombres[$i]="+nombres[i])
    }

    // Reorrer un array con forEach
    nombres.forEach { println(it) }
}