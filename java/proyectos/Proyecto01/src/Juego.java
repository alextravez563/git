
import java.util.*;
import util.ConsolaStyles;

// Clase que representa un juego entre dos jugadores utilizando cartas.
public class Juego {
    private List<CartaJuego> baraja; // Baraja completa de cartas.
    private Jugador jugador1; // Primer jugador.
    private Jugador jugador2; // Segundo jugador.

    // Constructor que inicializa el juego, crea la baraja y asigna jugadores.
    public Juego(String nombreJugador1, String nombreJugador2) {
        this.baraja = CartaJuego.crearBaraja(); // Crea una baraja completa.
        Collections.shuffle(baraja); // Mezcla las cartas para garantizar aleatoriedad.
        this.jugador1 = new Jugador(nombreJugador1); // Inicializa el primer jugador.
        this.jugador2 = new Jugador(nombreJugador2); // Inicializa el segundo jugador.
    }

    // Método que reparte 5 cartas a cada jugador.
    public void repartirCartas() {
        for (int i = 0; i < 5; i++) {
            jugador1.recibirCarta(baraja.remove(0)); // Da una carta al jugador 1.
            jugador2.recibirCarta(baraja.remove(0)); // Da una carta al jugador 2.
        }
    }

    // Método principal del juego que maneja turnos y lógica de victoria.
    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        // Turno del jugador 1
        ConsolaStyles.printTitle("Cartas de " + jugador1.getNombre());
        jugador1.mostrarCartas();
        if (verificarGanador(jugador1)) { // Verifica si el jugador 1 gana.
            System.out.println(jugador1.getNombre() + " gana con 4 cartas iguales!");
            return;
        }
        realizarCambio(jugador1, scanner); // Permite cambiar cartas.
        if (verificarGanador(jugador1)) {
            System.out.println(jugador1.getNombre() + " gana con 4 cartas iguales!");
            return;
        }
        usarCartaTrampa(jugador1, scanner); // Permite usar carta trampa.
        if (verificarGanador(jugador1)) {
            System.out.println(jugador1.getNombre() + " gana con 4 cartas iguales!");
            return;
        }

        // Turno del jugador 2
        ConsolaStyles.printTitle("Turno de " + jugador2.getNombre());
        jugador2.mostrarCartas();
        if (verificarGanador(jugador2)) {
            System.out.println(jugador2.getNombre() + " gana con 4 cartas iguales!");
            return;
        }
        realizarCambio(jugador2, scanner);
        if (verificarGanador(jugador2)) {
            System.out.println(jugador2.getNombre() + " gana con 4 cartas iguales!");
            return;
        }
        usarCartaTrampa(jugador2, scanner);
        if (verificarGanador(jugador2)) {
            System.out.println(jugador2.getNombre() + " gana con 4 cartas iguales!");
            return;
        }

        // Determina el ganador con base en los puntos.
        int puntosJugador1 = calcularPuntos(jugador1);
        int puntosJugador2 = calcularPuntos(jugador2);
        ConsolaStyles.printTitle("Cartas");
        System.out.println("[" + jugador1.getNombre() + "]:");
        jugador1.mostrarCartas(11);
        System.out.println("[" + jugador2.getNombre() + "]:");
        jugador2.mostrarCartas(11);
        ConsolaStyles.printTitle("Puntos");
        System.out.println(jugador1.getNombre() + ": " + puntosJugador1 + " puntos");
        System.out.println(jugador2.getNombre() + ": " + puntosJugador2 + " puntos");

        // Determina el resultado final del juego.
        if (puntosJugador1 > puntosJugador2) {
            System.out.println(jugador1.getNombre() + " gana con " + puntosJugador1 + " puntos!");
        } else if (puntosJugador2 > puntosJugador1) {
            System.out.println(jugador2.getNombre() + " gana con " + puntosJugador2 + " puntos!");
        } else {
            System.out.println("Es un empate con " + puntosJugador1 + " puntos cada uno!");
        }
    }

    // Verifica si un jugador tiene 4 cartas iguales.
    private boolean verificarGanador(Jugador jugador) {
        Map<String, Integer> conteoValores = new HashMap<>();
        for (Carta carta : jugador.getMano()) {
            conteoValores.put(carta.getValor(), conteoValores.getOrDefault(carta.getValor(), 0) + 1);
        }
        for (int conteo : conteoValores.values()) {
            if (conteo >= 4) {
                return true;
            }
        }
        return false;
    }

    // Permite a un jugador cambiar cartas.
    private void realizarCambio(Jugador jugador, Scanner scanner) {
        System.out.println(jugador.getNombre() + ", ¿Cuántas cartas deseas cambiar? (0-4)");
        int numCambios = scanner.nextInt();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < numCambios; i++) {
            System.out.println("[" + (i + 1) + "/" + numCambios + "] " + "Ingresa el índice de la carta a cambiar (0-4):");
            indices.add(scanner.nextInt());
        }
        List<Carta> nuevasCartas = new ArrayList<>();
        for (int i = 0; i < numCambios; i++) {
            nuevasCartas.add(baraja.remove(0));
        }
        jugador.cambiarCartas(nuevasCartas, indices);
        jugador.mostrarCartas();
    }

    // Permite a un jugador usar una carta trampa.
    private void usarCartaTrampa(Jugador jugador, Scanner scanner) {
        System.out.println(jugador.getNombre() + ", ¿Deseas usar tu carta trampa? (s/n)");
        String respuesta = scanner.next();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingresa el índice de la carta a cambiar por la carta trampa (0-4):");
            int indice = scanner.nextInt();
            CartaTrampa cartaTrampa = CartaTrampa.scanCartaTrampa();
            jugador.usarCartaTrampa(cartaTrampa, indice);
        }
        jugador.mostrarCartas();
    }

    // Calcula los puntos de un jugador con base en las cartas en su mano.
    private int calcularPuntos(Jugador jugador) {
        Map<String, Integer> conteoValores = new HashMap<>();
        Map<String, Integer> conteoFamilias = new HashMap<>();
        for (Carta carta : jugador.getMano()) {
            conteoValores.put(carta.getValor(), conteoValores.getOrDefault(carta.getValor(), 0) + 1);
            conteoFamilias.put(carta.getFamilia().getNombre(), conteoFamilias.getOrDefault(carta.getFamilia().getNombre(), 0) + 1);
        }
        int puntos = 0;
        for (int conteo : conteoValores.values()) {
            if (conteo == 2) {
                puntos += 3;
            } else if (conteo == 3) {
                puntos += 6;
            }
        }
        for (int conteo : conteoFamilias.values()) {
            if (conteo == 2) {
                puntos += 1;
            } else if (conteo == 3) {
                puntos += 3;
            }
        }
        return puntos;
    }
}

