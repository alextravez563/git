
import java.util.*;

import util.ConsolaStyles;

// Clase que representa un juego entre dos jugadores utilizando cartas.
public class Juego {
    private final List<CartaJuego> baraja; // Baraja completa de cartas.
    private final Jugador jugador1; // Primer jugador.
    private final Jugador jugador2; // Segundo jugador.
    private final EstiloDeJuego estiloDeJuego;

    public Juego(String nombreJugador1, String nombreJugador2, EstiloDeJuego estiloDeJuego) {
        this.baraja = CartaJuego.crearBaraja(); // Crea una baraja completa.
        Collections.shuffle(baraja); // Mezcla las cartas para garantizar aleatoriedad.
        this.jugador1 = new Jugador(nombreJugador1); // Inicializa el primer jugador.
        this.jugador2 = new Jugador(nombreJugador2); // Inicializa el segundo jugador.
        this.estiloDeJuego = estiloDeJuego;
    }

    // Método que reparte 5 cartas a cada jugador.
    public void repartirCartas() {
        for (int i = 0; i < 5; i++) {
            jugador1.recibirCarta(baraja.removeFirst()); // Da una carta al jugador 1.
            jugador2.recibirCarta(baraja.removeFirst()); // Da una carta al jugador 2.
        }
    }

    // Método principal del juego que maneja turnos y lógica de victoria.
    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        // Turno del jugador 1
        ConsolaStyles.printTitle("Cartas de " + jugador1.getNombre());
        jugador1.mostrarCartas(estiloDeJuego);
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
        jugador2.mostrarCartas(estiloDeJuego);
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
        Puntos puntosJugador1 = calcularPuntos(jugador1);
        Puntos puntosJugador2 = calcularPuntos(jugador2);
        ConsolaStyles.printTitle("Cartas");
        System.out.println("[" + jugador1.getNombre() + "]:");
        jugador1.mostrarCartas(estiloDeJuego, 11);
        System.out.println("[" + jugador2.getNombre() + "]:");
        jugador2.mostrarCartas(estiloDeJuego, 11);
        ConsolaStyles.printTitle("Puntos");
        System.out.println(jugador1.getNombre() + ":");
        System.out.println(puntosJugador1);
        System.out.println(jugador2.getNombre() + ":");
        System.out.println(puntosJugador2);

        // Determina el resultado final del juego.
        if (puntosJugador1.getPuntosTotales() > puntosJugador2.getPuntosTotales()) {
            System.out.println(jugador1.getNombre() + " gana con " + puntosJugador1 + " puntos!");
        } else if (puntosJugador2.getPuntosTotales() > puntosJugador1.getPuntosTotales()) {
            System.out.println(jugador2.getNombre() + " gana con " + puntosJugador2 + " puntos!");
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

    // Método para obtener un número válido dentro de un rango específico.
    private int obtenerNumeroValido(Scanner scanner, String mensaje) {
        int numero = -1;
        while (numero < 0 || numero > 4) {
            System.out.println(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero < 0 || numero > 4) {
                    System.out.println("Número inválido. Por favor, ingresa un número entre " + 0 + " y " + 4 + ".");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingresa un número entre " + 0 + " y " + 4 + ".");
                scanner.next(); // Clear the invalid input
            }
        }
        return numero;
    }

    // Permite a un jugador cambiar cartas.
    private void realizarCambio(Jugador jugador, Scanner scanner) {
        int numCambios = obtenerNumeroValido(scanner, jugador.getNombre() + ", ¿Cuántas cartas deseas cambiar? (0-4)");

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < numCambios; i++) {
            int indice = obtenerNumeroValido(scanner, "[" + (i + 1) + "/" + numCambios + "] Ingresa el índice de la carta a cambiar (0-4)");
            indices.add(indice);
        }

        List<Carta> nuevasCartas = new ArrayList<>();
        for (int i = 0; i < numCambios; i++) {
            nuevasCartas.add(baraja.removeFirst());
        }
        jugador.cambiarCartas(nuevasCartas, indices);
        jugador.mostrarCartas(estiloDeJuego);
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
        jugador.mostrarCartas(estiloDeJuego);
    }

    // Calcula los puntos de un jugador con base en las cartas en su mano.
    private Puntos calcularPuntos(Jugador jugador) {
        Map<String, Integer> conteoValores = new HashMap<>();
        Map<String, Integer> conteoFamilias = new HashMap<>();
        for (Carta carta : jugador.getMano()) {
            conteoValores.put(carta.getValor(), conteoValores.getOrDefault(carta.getValor(), 0) + 1);
            conteoFamilias.put(carta.getFamilia().getNombre(), conteoFamilias.getOrDefault(carta.getFamilia().getNombre(), 0) + 1);
        }

        Puntos puntos = getPuntos(conteoValores, conteoFamilias);
        System.out.println(puntos); // Print the points details
        return puntos;
    }

    private static Puntos getPuntos(Map<String, Integer> conteoValores, Map<String, Integer> conteoFamilias) {
        Puntos puntos = new Puntos();
        for (Map.Entry<String, Integer> entry : conteoValores.entrySet()) {
            int conteo = entry.getValue();
            if (conteo == 2) {
                puntos.agregarPuntosValor(3, entry.getKey());
            } else if (conteo == 3) {
                puntos.agregarPuntosValor(6, entry.getKey());
            }
        }
        for (Map.Entry<String, Integer> entry : conteoFamilias.entrySet()) {
            int conteo = entry.getValue();
            if (conteo == 2) {
                puntos.agregarPuntosFamilia(1, entry.getKey());
            } else if (conteo == 3) {
                puntos.agregarPuntosFamilia(3, entry.getKey());
            }
        }
        return puntos;
    }
}

