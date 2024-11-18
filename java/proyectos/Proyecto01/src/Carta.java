import java.util.List;

public abstract class Carta {
    protected String valor;
    protected CartaFamilia familia;

    public Carta(String valor, CartaFamilia familia) {
        this.valor = valor;
        this.familia = familia;
    }

    public String getValor() {
        return valor;
    }

    public CartaFamilia getFamilia() {
        return familia;
    }

    @Override
    public String toString() {
        return valor + " de " + familia.getNombre() + " " + familia.getSimbolo();
    }

    public String mostrarCarta(int index) {
        StringBuilder sb = new StringBuilder();
        String simbolo = familia.getSimbolo();
        int valorNumerico = 1;

        sb.append("┌─────────┐\n");
        sb.append(String.format("│%2s       │\n", valor));
        for (int i = 0; i < 3; i++) {
            sb.append("│         │\n");
        }
        for (int i = 0; i < valorNumerico; i++) {
            sb.append(String.format("│    %s    │\n", simbolo));
        }
        for (int i = 0; i < 3; i++) {
            sb.append("│         │\n");
        }
        sb.append(String.format("│       %2s│\n", valor));
        sb.append("└─────────┘\n");
        sb.append(String.format("    [%1d]    ", index));

        return sb.toString();
    }

    public static void mostrarCartasEnLinea(List<Carta> cartas) {
        mostrarCartasEnLinea(cartas, 12);
    }

    public static void mostrarCartasEnLinea(List<Carta> cartas, int lines) {

        StringBuilder[] lineas = new StringBuilder[lines];
        for (int i = 0; i < lines; i++) {
            lineas[i] = new StringBuilder();
        }

        for (int i = 0; i < cartas.size(); i++) {
            Carta carta = cartas.get(i);
            String[] cartaLineas = carta.mostrarCarta(i).split("\n");
            for (int j = 0; j < lines; j++) {
                lineas[j].append(cartaLineas[j]).append("  ");
            }
        }

        for (StringBuilder linea : lineas) {
            System.out.println(linea.toString());
        }
    }
}
