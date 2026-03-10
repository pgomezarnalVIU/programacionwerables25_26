// Clase Padre
// Todas las clases por defecto son finales
open class Personaje(val nombre:String){
    fun comoMeLlamo(){
        println("Me llamo $nombre")
    }
    open fun accion(){
        println("$nombre realiza una accion")
    }
}

// Clase hija de Personajes
class Heroe(nombre: String, val poder: String) : Personaje(nombre){
    // Sobreescribir la funcion accion
    override fun accion(){
        println("El heroe $nombre usa el superpoder $poder")
    }
}

// Clase hija para villanos
class Villano(nombre: String, val maldad: String) : Personaje(nombre) {
    // Sobrescribimos la función para definir el comportamiento del villano
    override fun accion() {
        println("$nombre, el villano, ejecuta su plan de $maldad.")
    }
}


// Lanzamos el programa
fun main(){
    val patriota = Heroe ("Patriota", "todos")
    patriota.accion()

    val villano = Villano("Oscuro", "fuerza")
    villano.maldad
}
