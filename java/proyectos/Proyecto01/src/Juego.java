
import java.util.*;

import util.ConsolaStyles;

// Clase que representa un juego entre dos jugadores utilizando cartas.
public class Juego {
    private final List<CartaJuego> baraja; // Baraja completa de cartas.
    private final Jugador jugador1; // Primer jugador.
    private final Jugador jugador2; // Segundo jugador.
    private final EstiloDeJuego estiloDeJuego; // Configuración para mostrar cartas estilizadas.

    // Constructor que inicializa el juego.
    public Juego(String nombreJugador1, String nombreJugador2, EstiloDeJuego estiloDeJuego) {
        this.baraja = CartaJuego.crearBaraja(); // Genera una baraja estándar de 52 cartas.
        Collections.shuffle(baraja); // Mezcla las cartas para garantizar aleatoriedad.
        this.jugador1 = new Jugador(nombreJugador1); // Inicializa el primer jugador.
        this.jugador2 = new Jugador(nombreJugador2); // Inicializa el segundo jugador.
        this.estiloDeJuego = estiloDeJuego; // Estilo de juego (puede incluir visualización personalizada).
    }

    // Método que reparte 5 cartas a cada jugador.
    public void repartirCartas() {
        for (int i = 0; i < 5; i++) {
            jugador1.recibirCarta(baraja.remove(0)); // Da una carta al jugador 1.
            jugador2.recibirCarta(baraja.remove(0)); // Da una carta al jugador 2.
        }
    }

    // Método principal que contiene la lógica del juego.
    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        // Turno del jugador 1
        ConsolaStyles.printTitle("Turno de " + jugador1.getNombre());
        jugador1.mostrarCartas(estiloDeJuego); // Muestra las cartas del jugador.
        if (verificarGanador(jugador1)) { // Verifica si el jugador tiene 4 cartas iguales.
            System.out.println(jugador1.getNombre() + " gana con 4 cartas iguales!");
            return;
        }
        realizarCambio(jugador1, scanner); // Permite al jugador cambiar cartas.
        if (verificarGanador(jugador1)) {
            System.out.println(jugador1.getNombre() + " gana con 4 cartas iguales!");
            return;
        }
        usarCartaTrampa(jugador1, scanner); // Permite usar una carta trampa.
        if (verificarGanador(jugador1)) {
            System.out.println(jugador1.getNombre() + " gana con 4 cartas iguales!");
            return;
        }

        // Turno del jugador 2 (similar al del jugador 1).
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

        // Determina el ganador basado en los puntos obtenidos.
        Puntos puntosJugador1 = calcularPuntos(jugador1);
        Puntos puntosJugador2 = calcularPuntos(jugador2);

        ConsolaStyles.printTitle("Puntos Finales");
        System.out.println(jugador1.getNombre() + ": " + puntosJugador1);
        System.out.println(jugador2.getNombre() + ": " + puntosJugador2);

        // Declara el ganador final.
        if (puntosJugador1.getPuntosTotales() > puntosJugador2.getPuntosTotales()) {
            System.out.println(jugador1.getNombre() + " gana con " + puntosJugador1.getPuntosTotales() + " puntos!");
        } else if (puntosJugador2.getPuntosTotales() > puntosJugador1.getPuntosTotales()) {
            System.out.println(jugador2.getNombre() + " gana con " + puntosJugador2.getPuntosTotales() + " puntos!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }

    // Verifica si un jugador tiene 4 cartas con el mismo valor.
    private boolean verificarGanador(Jugador jugador) {
        Map<String, Integer> conteoValores = new HashMap<>();
        for (Carta carta : jugador.getMano()) {
            conteoValores.put(carta.getValor(), conteoValores.getOrDefault(carta.getValor(), 0) + 1);
        }
        // Si alguna carta tiene un conteo de 4, el jugador gana.
        for (int conteo : conteoValores.values()) {
            if (conteo >= 4) {
                return true;
            }
        }
        return false;
    }

    // Solicita al usuario un número válido dentro de un rango específico.
    private int obtenerNumeroValido(Scanner scanner, String mensaje) {
        int numero = -1;
        while (numero < 0 || numero > 4) {
            System.out.println(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero < 0 || numero > 4) {
                    System.out.println("Número inválido. Por favor, ingresa un número entre 0 y 4.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingresa un número válido.");
                scanner.next(); // Limpia la entrada inválida.
            }
        }
        return numero;
    }

    // Permite a un jugador cambiar cartas por nuevas de la baraja.
    private void realizarCambio(Jugador jugador, Scanner scanner) {
        int numCambios = obtenerNumeroValido(scanner, jugador.getNombre() + ", ¿Cuántas cartas deseas cambiar? (0-4)");

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < numCambios; i++) {
            int indice = obtenerNumeroValido(scanner, "Ingresa el índice de la carta a cambiar (0-4):");
            indices.add(indice);
        }

        List<Carta> nuevasCartas = new ArrayList<>();
        for (int i = 0; i < numCambios; i++) {
            nuevasCartas.add(baraja.remove(0)); // Obtiene nuevas cartas de la baraja.
        }
        jugador.cambiarCartas(nuevasCartas, indices); // Reemplaza las cartas seleccionadas.
    }

    // Permite a un jugador usar una carta trampa.
    private void usarCartaTrampa(Jugador jugador, Scanner scanner) {
        System.out.println(jugador.getNombre() + ", ¿Deseas usar tu carta trampa? (s/n)");
        String respuesta = scanner.next();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingresa el índice de la carta a cambiar por la carta trampa (0-4):");
            int indice = scanner.nextInt();
            CartaTrampa cartaTrampa = CartaTrampa.scanCartaTrampa(); // Crea una carta trampa desde la entrada del usuario.
            jugador.usarCartaTrampa(cartaTrampa, indice); // Usa la carta trampa en la posición especificada.
        }
    }

    // Calcula los puntos de un jugador según sus cartas.
    private Puntos calcularPuntos(Jugador jugador) {
        Map<String, Integer> conteoValores = new HashMap<>();
        Map<String, Integer> conteoFamilias = new HashMap<>();

        // Cuenta la cantidad de cartas por valor y familia.
        for (Carta carta : jugador.getMano()) {
            conteoValores.put(carta.getValor(), conteoValores.getOrDefault(carta.getValor(), 0) + 1);
            conteoFamilias.put(carta.getFamilia().getNombre(), conteoFamilias.getOrDefault(carta.getFamilia().getNombre(), 0) + 1);
        }

        return getPuntos(conteoValores, conteoFamilias); // Calcula los puntos.
    }

    // Método auxiliar para calcular los puntos basados en los conteos.
    private static Puntos getPuntos(Map<String, Integer> conteoValores, Map<String, Integer> conteoFamilias) {
        Puntos puntos = new Puntos();
        // Puntos por valores (pares o tríos).
        for (Map.Entry<String, Integer> entry : conteoValores.entrySet()) {
            int conteo = entry.getValue();
            if (conteo == 2) {
                puntos.agregarPuntosValor(3, entry.getKey());
            } else if (conteo == 3) {
                puntos.agregarPuntosValor(6, entry.getKey());
            }
        }
        // Puntos por familias (pares o tríos).
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
