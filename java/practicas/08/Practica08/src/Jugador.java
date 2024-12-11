import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta Jugador que sirve como base para los jugadores en el juego "El 21".
 * Implementa la interfaz Serializable.
 */
public abstract class Jugador implements Serializable {

    // serialVersionUID para la serialización
    private static final long serialVersionUID = 1L;

    // Atributos privados
    private String nombre;           // Nombre del jugador
    private List<Carta> mano;        // Lista de cartas que el jugador tiene en su mano

    /**
     * Constructor que inicializa el nombre y la mano del jugador.
     *
     * @param nombre el nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    /**
     * Devuelve el nombre del jugador.
     *
     * @return el nombre como cadena
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Agrega una carta a la mano del jugador.
     *
     * @param carta la carta a agregar
     */
    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    /**
     * Devuelve la lista de cartas en la mano del jugador.
     *
     * @return lista de cartas
     */
    public List<Carta> getMano() {
        return mano;
    }

    /**
     * Calcula el puntaje total de la mano del jugador.
     * Considera que el As puede valer 1 o 11 dependiendo del puntaje total.
     *
     * @return el puntaje total
     */
    public int getPuntaje() {
        int puntaje = 0;
        boolean tieneAs = false;

        for (Carta carta : mano) {
            puntaje += carta.getValorNumerico();
            if (carta.getValor().equals("As")) {
                tieneAs = true;
            }
        }

        // Si hay un As y el puntaje no supera 21, cuenta el As como 11
        if (tieneAs && puntaje + 10 <= 21) {
            puntaje += 10;
        }

        return puntaje;
    }

    /**
     * Método abstracto que define el comportamiento del jugador al jugar.
     */
    public abstract void jugar();
}
