import java.util.Locale
import java.util.Locale.getDefault

fun main(){
    // Texto multilinea

    val text = """
            En Kotlin, las cadenas de texto se representan con el tipo String. 
            Las cadenas pueden contener caracteres Unicode y se pueden definir utilizando comillas dobles 
        """
    println(text)

    // Interpolación de cadenas
    val i = 10
    println("i = $i")

    val letters = arrayOf("a","b","c","d","e")
    println("Letters: $letters")


    // Concatena cadenas
    val firstName = "John"
    val lastName = "Doe"
    val fullName = "$firstName $lastName"
    val fullName2 = firstName + " " + lastName
    println("Full Name: $fullName")

    // Impmrime el tamaño de una cadena
    println("Length of fullName: ${fullName.length}")

    // Comprueba si una cadena está vacía
    val emptyString = ""
    println("Is emptyString empty? ${emptyString.isEmpty()}")

    // Conversión de mayúsculas y minúsculas
    val mixedCase = "Kotlin Programming"
    println("Uppercase: ${mixedCase.uppercase(getDefault())}")
    println("Lowercase: ${mixedCase.lowercase(getDefault())}")

    // Buscar una subcadena
    val sentence = "Kotlin is a great programming language"
    println("Does the sentence contain 'great'? ${sentence.contains("great")}")

    // Comparar dos cadenas
    val str1 = "Hello"
    val str2 = "hello"
    println("Are str1 and str2 equal? ${str1.equals(str2)}")
    println("Are str1 and str2 equal? ${str1.equals(str2, ignoreCase = true)}")

}