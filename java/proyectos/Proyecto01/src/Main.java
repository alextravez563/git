
// Clase principal que contiene el método main para iniciar el programa.
public class Main {
    public static void main(String[] args) {
        // Crea un nuevo juego con dos jugadores.
        Juego juego = new Juego("Jugador 1", "Jugador 2", EstiloDeJuego.GRAFICO_SIMBOLO_MEDIO);
        
        // Reparte las cartas iniciales a ambos jugadores.
        juego.repartirCartas();
        
        // Inicia el flujo principal del juego.
        juego.jugar();
    }
}

