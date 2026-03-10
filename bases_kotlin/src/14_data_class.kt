import javax.swing.text.Position

// Representaria la plantilla de un jugador
// Que en otros lenguajes se denomina struct
data class Jugador(
    val nombre: String,
    val equipo: String,
    val position: String,
    val puntosPorPartido: Double
    )


fun main(){
    // Creación de instancias de jugadores
    val jugador1 = Jugador("LeBron James", "Lakers", "Alero", 25.3)
    val jugador2 = Jugador("Stephen Curry", "Warriors", "Base", 27.1)
    val jugador3 = Jugador("Kevin Durant", "Nets", "Alero", 26.9)

    // Lista de jugadores
    val jugadores = listOf(jugador1, jugador2, jugador3)

    // Imprimir la informacion
    jugadores.forEach { jugador ->
        println("Nombre: ${jugador.nombre}, Equipo: ${jugador.equipo} con Puntos por partido: ${jugador.puntosPorPartido} ")
    }

}