fun main(){
    imprimirTodos("hola", "qué", "tal")

    val total = suma(1, 2, 3, 4) // 10
    println("La suma es $total")

    //Pasar un array a un vararg (spread operator *)
    //Si ya tienes un array y quieres pasarlo como varargs, necesitas el *
    val arr = doubleArrayOf(1.0, 2.0, 3.0)
    val p = promedio(*arr)

    log("INFO", "Arrancando", "módulo", "X")
}

// Sintaxis básica de una función con varargs
// Dentro de la función, palabras se comporta como un array (Array<String>).
fun imprimirTodos(vararg palabras: String) {
    for (p in palabras) println(p)
}

// Ejemplo típico: sumar muchos números
fun suma(vararg nums: Int): Int = nums.sum()

fun promedio(vararg nums: Double) = nums.average()

// vararg con otros parámetros
fun log(tag: String, vararg msg: String) {
    println("[$tag] " + msg.joinToString(" "))
}