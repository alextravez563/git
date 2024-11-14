import java.util.Scanner;

// Clase Juego21 que controla la lógica del juego
public class Juego21 {
    private Baraja baraja;               // Objeto que representa la baraja de cartas
    private JugadorHumano jugador;       // Jugador humano
    private JugadorHumano juez;          // Juez del juego

    // Constructor que inicializa la baraja, el jugador y el juez
    public Juego21(String nombreJugador) {
        baraja = new Baraja();
        baraja.barajar(); // Mezcla la baraja al inicio
        jugador = new JugadorHumano(nombreJugador);
        juez = new JugadorHumano("Juez");
    }

    // Método para ejecutar una partida del juego
    public void jugar() {
        // Reparte dos cartas al jugador
        jugador.agregarCartaMano(baraja.repartirCarta());
        jugador.agregarCartaMano(baraja.repartirCarta());

        // Reparte dos cartas al juez
        juez.agregarCartaMano(baraja.repartirCarta());
        juez.agregarCartaMano(baraja.repartirCarta());

        // Muestra la mano y el puntaje del jugador
        System.out.println("Mano del jugador:");
        jugador.mostrarMano();
        System.out.println("Puntaje del jugador: " + jugador.calcularPuntaje());

        // Agrega una carta especial (Joker) al juez
        Baraja.CartaEspecial cartaEspecial = new Baraja.CartaEspecial();
        juez.agregarCartaMano(cartaEspecial);

        // Muestra la mano y el puntaje del juez
        System.out.println("Mano del juez:");
        juez.mostrarMano();
        System.out.println("Puntaje del juez: " + juez.calcularPuntaje());

        // Determina el ganador entre el jugador y el juez
        determinarGanador();
    }

    // Método privado para determinar el ganador del juego
    private void determinarGanador() {
        int puntajeJugador = jugador.calcularPuntaje();
        int puntajeJuez = juez.calcularPuntaje();

        if (puntajeJugador > puntajeJuez && puntajeJugador <= 21) {
            System.out.println(jugador.getNombre() + " gana!");
        } else if (puntajeJuez <= 21) {
            System.out.println("El juez gana!");
        } else {
            System.out.println("Empate!");
        }
    }

    // Método principal para iniciar el juego
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String nombreJugador = scanner.nextLine();

        Juego21 juego = new Juego21(nombreJugador);
        juego.jugar();
    }
}
