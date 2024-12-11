import java.io.Serializable;

/**
 * Clase JugadorHumano representa a un jugador humano en el juego.
 */
public class JugadorHumano extends Jugador implements Serializable {

    // serialVersionUID para la serialización
    private static final long serialVersionUID = 1L;

    /**
     * Constructor que inicializa el nombre del jugador humano.
     *
     * @param nombre el nombre del jugador
     */
    public JugadorHumano(String nombre) {
        super(nombre);
    }

    /**
     * Implementación del método jugar para un jugador humano.
     * Por ahora, simplemente imprime un mensaje indicando el turno.
     */
    @Override
    public void jugar() {
        System.out.println("Turno de: " + getNombre());
    }
}
