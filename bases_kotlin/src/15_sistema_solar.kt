class PlanetaVacio // Clase vacia que solo sirve como plantilla

class Planeta(val nombre: String, var diametro:Int){
    // Si se define radio, el valor que prevalece es el de radio
    var radio: Int = 0
        get() = this.diametro/2
        set(valor) {
            if (valor < 0){
                field = this.diametro / 2
            }else {
                this.diametro = valor * 2
                field  = valor
            }
        }

    // Segundo constructor
    var esGaseoso: Boolean = false
    constructor(nombre:String,diametro:Int, esGaseoso: Boolean):this(nombre,diametro){
        this.esGaseoso = esGaseoso
    }
}

fun main(){
    println("Cargando sistema solar ...")
    // Planeta desconocido
    val planeta_desconocido = PlanetaVacio()

    // Planeta marte
    val marte = Planeta("Marte",6779)
    marte.radio = -2000

    // Planeta tierra
    val tierra = Planeta("Tierra",12742)
    tierra.radio = 15000

    // Planeta Saturno
    val saturno = Planeta("Saturno",198567,true)

    // Imprimir sistema solar
    println("Nuestro primer planeta se llama ${marte.nombre} y su radio es ${marte.radio}")
    println("Nuestro segundo planeta se llama ${tierra.nombre} y su radio es ${tierra.radio}")
    println("Nuestro tercer planeta se llama ${saturno.nombre} y su radio es ${saturno.radio} y su estado es ${saturno.esGaseoso}")
}