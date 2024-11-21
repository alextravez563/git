
import java.util.ArrayList;
import java.util.List;

import util.ConsolaStyles;

// Clase que representa a un jugador en el juego.
public class Jugador {
    private final String nombre; // Nombre del jugador.
    private final List<Carta> mano; // Lista de cartas en la mano del jugador.
    private boolean usoCartaTrampa; // Indica si el jugador ya usó su carta trampa.

    // Constructor que inicializa al jugador con un nombre, una mano vacía y sin uso de carta trampa.
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
        this.usoCartaTrampa = false;
    }

    // Método para obtener el nombre del jugador.
    public String getNombre() {
        return nombre;
    }

    // Método para obtener la mano de cartas del jugador.
    public List<Carta> getMano() {
        return mano;
    }

    // Devuelve una representación en formato String de la mano del jugador.
    public String getManoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mano.size(); i++) {
            sb.append(mano.get(i).toString()); // Agrega la carta al StringBuilder.
            if (i < mano.size() - 1) {
                sb.append(ConsolaStyles.BOLD + " | " + ConsolaStyles.RESET); // Formato entre cartas.
            }
        }
        // Formato para encapsular la lista de cartas.
        return ConsolaStyles.BOLD + "[" + ConsolaStyles.RESET + sb + ConsolaStyles.BOLD + "]" + ConsolaStyles.RESET;
    }

    // Muestra las cartas del jugador en línea.
    public void mostrarCartas(EstiloDeJuego estiloDeJuego) {
        mostrarCartas(estiloDeJuego, 12);
    }

    public void mostrarCartas(EstiloDeJuego estiloDeJuego, int lines) {
        switch (estiloDeJuego) {
            case LISTA, TEXTO:
                System.out.println(getManoString());
                break;
            case GRAFICO_SIMBOLO_MEDIO:
                Carta.mostrarCartasEnLinea(this.mano, lines, true);
                break;
            default:
                Carta.mostrarCartasEnLinea(this.mano, lines, false);
                break;
        }

    }

    // Método para recibir una carta y añadirla a la mano.
    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    // Método para usar una carta trampa reemplazando una carta específica de la mano.
    public void usarCartaTrampa(CartaTrampa cartaTrampa, int indice) {
        if (!usoCartaTrampa) { // Verifica si no se ha usado la carta trampa previamente.
            mano.set(indice, cartaTrampa); // Reemplaza la carta en el índice indicado.
            usoCartaTrampa = true; // Marca que ya se usó la carta trampa.
        }
    }

    // Método para cambiar cartas específicas de la mano con nuevas cartas.
    public void cambiarCartas(List<Carta> nuevasCartas, List<Integer> indices) {
        for (int i = 0; i < indices.size(); i++) {
            mano.set(indices.get(i), nuevasCartas.get(i)); // Reemplaza las cartas según los índices.
        }
    }
}
