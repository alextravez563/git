public class Carta21 extends Carta {
    public Carta21(String familia, String valor) {
        super(familia, valor);
    }

    // Método para obtener los puntos de la carta
    public int getPuntos() {
        switch (getValor()) {
            case "A":
                return 11;
            case "J":
            case "Q":
            case "K":
                return 10;
            default:
                return Integer.parseInt(getValor());
        }
    }
}
