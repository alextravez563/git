import java.io.Serializable;
import java.util.Collections;
import java.util.Stack;

/**
 * Clase Baraja representa una baraja de cartas y permite realizar operaciones como barajar y sacar cartas.
 */
public class Baraja implements Serializable {

    // serialVersionUID para la serialización
    private static final long serialVersionUID = 1L;

    // Atributo privado que almacena las cartas de la baraja
    private Stack<Carta> cartas;

    /**
     * Constructor que inicializa la baraja y la baraja automáticamente.
     */
    public Baraja() {
        cartas = new Stack<>();
        inicializarBaraja();
        barajar();
    }

    /**
     * Inicializa la baraja con 52 cartas (13 valores por 4 familias).
     */
    private void inicializarBaraja() {
        String[] familias = {"Picas", "Corazones", "Tréboles", "Diamantes"};
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String familia : familias) {
            for (String valor : valores) {
                cartas.push(new Carta(valor, familia));
            }
        }
    }

    /**
     * Baraja las cartas utilizando el método shuffle de Collections.
     */
    public void barajar() {
        Collections.shuffle(cartas);
    }

    /**
     * Saca una carta de la baraja.
     *
     * @return la carta extraída
     */
    public Carta sacarCarta() {
        return cartas.pop();
    }
}
