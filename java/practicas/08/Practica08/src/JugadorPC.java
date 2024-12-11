import java.io.Serializable;

/**
 * Clase JugadorPC representa a un jugador controlado por la computadora.
 */
public class JugadorPC extends Jugador implements Serializable {

    // serialVersionUID para la serialización
    private static final long serialVersionUID = 1L;

    /**
     * Constructor que inicializa el nombre del jugador PC.
     *
     * @param nombre el nombre del jugador PC
     */
    public JugadorPC(String nombre) {
        super(nombre);
    }

    /**
     * Implementación del método jugar para el jugador PC.
     * Por ahora, simplemente imprime un mensaje indicando el turno del PC.
     */
    @Override
    public void jugar() {
        System.out.println("Turno del PC: " + getNombre());
    }
}
