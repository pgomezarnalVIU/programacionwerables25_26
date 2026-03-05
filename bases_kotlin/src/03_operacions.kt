fun main(){

    //Creacion de variables
    var edad:Int = 40
    var intervalo:Int = 2
    val paso:Float = 2.5f
    var nombre:String = "Paco"
    var apellido:String = "Gómez"
    var numeroTxt:String = "40"

    //Operaciones aritméticas
    println("Edad+intervalo="+(edad+intervalo))
    println("Edad*intervalo="+(edad*intervalo))
    println("Edad/intervalo="+(edad/intervalo))
    println("Edad%intervalo="+(edad%intervalo))

    //Conversiones automática de operaciones

    println("Edad+paso=(Float)"+(edad+paso)) //Conversion a Float
    println("Edad+paso=(Int)"+(edad+paso.toInt())) //Conversión mediante funcion
    println("numeroTxt=(Int)"+(numeroTxt.toInt()))

    //Concatenación
    println(nombre+" "+apellido)
}