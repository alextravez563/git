import java.util.Scanner;

public class Juego21 {
    private Baraja baraja;
    private JugadorHumano jugador;
    private JugadorHumano juez;

    // Constructor que inicializa el juego, el jugador y el juez
    public Juego21(String nombreJugador) {
        baraja = new Baraja();
        baraja.barajar();
        jugador = new JugadorHumano(nombreJugador);
        juez = new JugadorHumano("Juez");
    }

    // Método para jugar el juego
    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        // Repartir dos cartas al jugador
        jugador.agregarCartaMano(baraja.repartirCarta());
        jugador.agregarCartaMano(baraja.repartirCarta());

        // Repartir dos cartas al juez
        juez.agregarCartaMano(baraja.repartirCarta());
        juez.agregarCartaMano(baraja.repartirCarta());

        // Mostrar la mano del jugador y su puntaje
        System.out.println("Mano del jugador:");
        jugador.mostrarMano();
        System.out.println("Puntaje del jugador: " + jugador.calcularPuntaje());

        // Preguntar al jugador si desea otra carta
        String respuesta;
        do {
            System.out.print("¿Quieres otra carta? (sí/no): ");
            respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("sí")) {
                jugador.agregarCartaMano(baraja.repartirCarta());
                System.out.println("Mano del jugador:");
                jugador.mostrarMano();
                System.out.println("Puntaje del jugador: " + jugador.calcularPuntaje());
            }
        } while (respuesta.equals("sí") && jugador.calcularPuntaje() <= 21);

        // El juez juega hasta tener al menos 17 puntos
        while (juez.calcularPuntaje() < 17) {
            juez.agregarCartaMano(baraja.repartirCarta());
        }

        // Mostrar la mano del juez y su puntaje
        System.out.println("\nMano del juez:");
        juez.mostrarMano();
        System.out.println("Puntaje del juez: " + juez.calcularPuntaje());

        // Determinar el ganador
        determinarGanador();
    }

    // Método para determinar el ganador
    private void determinarGanador() {
        int puntajeJugador = jugador.calcularPuntaje();
        int puntajeJuez = juez.calcularPuntaje();

        System.out.println("\n--- Resultado ---");
        if (puntajeJugador > 21) {
            System.out.println("Te has pasado de 21. El juez gana!");
        } else if (puntajeJuez > 21) {
            System.out.println("El juez se ha pasado de 21. " + jugador.getNombre() + " gana!");
        } else if (puntajeJugador > puntajeJuez) {
            System.out.println(jugador.getNombre() + " gana!");
        } else if (puntajeJuez > puntajeJugador) {
            System.out.println("El juez gana!");
        } else {
            System.out.println("Empate!");
        }
    }

    // Método principal para iniciar el juego
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            System.out.print("Ingresa tu nombre: ");
            String nombreJugador = scanner.nextLine();

            Juego21 juego = new Juego21(nombreJugador);
            juego.jugar();

            // Pregunta si desea jugar de nuevo
            System.out.print("¿Quieres jugar otra vez? (sí/no): ");
            respuesta = scanner.nextLine().toLowerCase();

        } while (respuesta.equals("sí"));

        System.out.println("Gracias por jugar!");
        scanner.close();
    }
}
