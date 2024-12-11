import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Juego representa el flujo principal del juego "El 21".
 */
public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Jugador> jugadores; // Lista de jugadores en el juego
    private Baraja baraja;           // Baraja utilizada en el juego

    /**
     * Constructor que inicializa la lista de jugadores y la baraja.
     */
    public Juego() {
        jugadores = new ArrayList<>();
        baraja = new Baraja();
    }

    /**
     * Agrega un jugador al juego.
     *
     * @param jugador el jugador a agregar
     */
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    /**
     * Inicia el juego, reparte cartas y gestiona los turnos de los jugadores.
     */
    public void iniciar() {
        // Reparte dos cartas a cada jugador
        for (int i = 0; i < 2; i++) {
            for (Jugador jugador : jugadores) {
                jugador.recibirCarta(baraja.sacarCarta());
            }
        }

        // Cada jugador realiza su turno
        for (Jugador jugador : jugadores) {
            jugador.jugar();
        }

        // Muestra las manos y determina el ganador
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ": " + jugador.getMano() + " obtuvo : " + jugador.getPuntaje());
        }
    }
}
