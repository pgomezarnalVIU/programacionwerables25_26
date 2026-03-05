fun main(){
    //Uso de funciones
    val valorX:Int = 2;
    val valorY:Int = 1;
    val resultDoble = simpleDouble(valorX)

    val resultSumaPon = sumaPon(valorX,valorY)
    println("La suma ponderada de $valorX,$valorY es $resultSumaPon")

    val sumaPonDef = sumaPonDef(valorX)

    //Usamos saludar
    saludar()                      // Hola, Mundo
    saludar("Ana", 2)              // Hola, Ana (x2)
    saludar(veces = 3, nombre = "Luis") // orden libre con nombres
}

//Kotlin functions are declared using the fun keyword:
fun simpleDouble(x: Int): Int {
    return 2 * x
}
fun double(x: Int): Int = x * 2 //Otra forma, _Single expresion

//Suma ponderada de dos parámetros
// Function parameters are defined using Pascal notation - name: type.
// Parameters are separated using commas, and each parameter must be explicitly typed:
fun sumaPon(x: Int,y:Int): Int {
    return (2 * x)+y
}

//Suma ponderada de dos parámetros con valor por defecto
fun sumaPonDef(x: Int,y:Int=0): Int {
    return (2 * x)+y
}

// Parámetros por defecto y argumentos con nombre
fun saludar(nombre: String = "Mundo", veces: Int = 1) {
    // repeat en Kotlin es una función estándar para ejecutar un bloque de código N veces.
    // repeat(times) { index ->código a repetir}
    repeat(veces) { println("Hola, $nombre") }
}
