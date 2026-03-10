// Definimos una clase
class Car{

}
//Puede ser interesante crear clases vacias sobre cuando se definen plantillas
class Empty

// Todas las clases tienen un constructor por defecto
// propiedad publica name
class Customer(var name:String){
    val nameUpper = name.uppercase()
}

// Definir propiedades publicas y privadas directamente en el constructor
class Person(val firstName: String, val lastName: String, var isEmployed: Boolean = true){
    // publicas y mutables var
    // publicas y no mutables val
}
