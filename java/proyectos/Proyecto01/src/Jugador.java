import util.ConsolaStyles;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Carta> mano;
    private boolean usoCartaTrampa;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
        this.usoCartaTrampa = false;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public String getManoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mano.size(); i++) {
            sb.append(mano.get(i).toString());
            if (i < mano.size() - 1) {
                sb.append(ConsolaStyles.BOLD + " | " + ConsolaStyles.RESET);
            }
        }
        return ConsolaStyles.BOLD + "[" + ConsolaStyles.RESET + sb + ConsolaStyles.BOLD + "]" + ConsolaStyles.RESET;
    }

    public void mostrarCartas() {
        Carta.mostrarCartasEnLinea(this.mano);
    }

    public void mostrarCartas(int lines) {
        Carta.mostrarCartasEnLinea(this.mano, lines);
    }

    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    public void usarCartaTrampa(CartaTrampa cartaTrampa, int indice) {
        if (!usoCartaTrampa) {
            mano.set(indice, cartaTrampa);
            usoCartaTrampa = true;
        }
    }

    public void cambiarCartas(List<Carta> nuevasCartas, List<Integer> indices) {
        for (int i = 0; i < indices.size(); i++) {
            mano.set(indices.get(i), nuevasCartas.get(i));
        }
    }
}
