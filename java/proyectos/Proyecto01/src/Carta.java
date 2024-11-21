import util.ConsolaStyles;

import java.util.ArrayList;
import java.util.List;

// Clase abstracta que representa una Carta genérica en un juego de cartas.
// Esta clase se utiliza como base para otros tipos de cartas (e.g., cartas de póker, naipes españoles).
public abstract class Carta {
    protected String valor; // Valor de la carta (e.g., "A", "K", "2", etc.).
    protected CartaFamilia familia; // Familia o palo de la carta (e.g., corazones, tréboles, etc.).
    private List<String> patron; // Representación visual de la carta, en forma de patrón.

    // Constructor que inicializa los atributos de la carta.
    public Carta(String valor, CartaFamilia familia) {
        this.valor = valor; // Asigna el valor de la carta.
        this.familia = familia; // Asigna la familia de la carta.
        this.patron = generarPatron(valor); // Genera un patrón visual según el valor.
    }

    // Getter para obtener el valor de la carta.
    public String getValor() {
        return valor;
    }

    // Getter para obtener la familia de la carta.
    public CartaFamilia getFamilia() {
        return familia;
    }

    // Sobrescribe el método toString para devolver una descripción simple de la carta.
    @Override
    public String toString() {
        return valor + " de " + familia.getNombre() + " " + familia.getSimbolo();
    }

    // Método privado que genera un patrón visual basado en el valor de la carta.
    private List<String> generarPatron(String valor) {
        List<String> patron = new ArrayList<>(); // Lista que almacena el patrón.
        // Según el valor, agrega las líneas que forman el patrón de la carta.
        switch (valor) {
            case "A": // Patrón para el As.
                patron.add("         ");
                patron.add("    *    ");
                patron.add("         ");
                patron.add("         ");
                break;
            case "2": // Patrón para el número 2.
                patron.add("    *    ");
                patron.add("         ");
                patron.add("         ");
                patron.add("    *    ");
                break;
            case "3": // Patrón para el número 3.
                patron.add("    *    ");
                patron.add("    *    ");
                patron.add("    *    ");
                patron.add("         ");
                break;
            case "4": // Patrón para el número 4.
                patron.add("  *   *  ");
                patron.add("         ");
                patron.add("         ");
                patron.add("  *   *  ");
                break;
            case "5": // Patrón para el número 5.
                patron.add("  *   *  ");
                patron.add("    *    ");
                patron.add("         ");
                patron.add("  *   *  ");
                break;
            case "6": // Patrón para el número 6.
                patron.add("  *   *  ");
                patron.add("         ");
                patron.add("  *   *  ");
                patron.add("  *   *  ");
                break;
            case "7": // Patrón para el número 7.
                patron.add("  *   *  ");
                patron.add("    *    ");
                patron.add("  *   *  ");
                patron.add("  *   *  ");
                break;
            case "8": // Patrón para el número 8.
                patron.add("  *   *  ");
                patron.add("    *    ");
                patron.add("  * * *  ");
                patron.add("  *   *  ");
                break;
            case "9": // Patrón para el número 9.
                patron.add("  *   *  ");
                patron.add("  * * *  ");
                patron.add("  *   *  ");
                patron.add("  *   *  ");
                break;
            case "10", "J", "Q", "K": // Patrón para 10, Jota, Reina, Rey (similares).
                patron.add("  *   *  ");
                patron.add("  * * *  ");
                patron.add("  * * *  ");
                patron.add("  *   *  ");
                break;
            default: // Patrón por defecto (vacío).
                patron.add("         ");
                patron.add("         ");
                patron.add("         ");
                patron.add("         ");
                break;
        }
        return patron; // Retorna la lista con el patrón generado.
    }

    // Método que genera una representación visual de la carta.
    public String mostrarCarta(int index, boolean withSymbol) {

        // Si se solicita mostrar con símbolo, se regenera el patrón para el As como ejemplo.
        if (withSymbol) {
            patron = generarPatron("A");
        }

        StringBuilder sb = new StringBuilder(); // Usado para construir la representación.
        String simbolo = withSymbol ? familia.getSimbolo() : ConsolaStyles.getTextoEstilado(String.valueOf(familia.getNombre().charAt(0)), familia.getColor());
        int fixedHeight = 6; // Altura fija para el cuerpo de la carta.

        // Parte superior de la carta.
        sb.append("┌─────────┐\n");
        sb.append(String.format("│%2s       │\n", valor)); // Valor en la esquina superior izquierda.
        sb.append("│         │\n");

        // Parte central: patrón visual.
        int patternStart = (fixedHeight - patron.size()) / 2; // Centra el patrón dentro de la altura fija.
        for (int i = 0; i < fixedHeight; i++) {
            if (i >= patternStart && i < patternStart + patron.size()) {
                String linea = patron.get(i - patternStart); // Obtiene la línea correspondiente del patrón.
                sb.append("│");
                for (char c : linea.toCharArray()) {
                    sb.append(c == '*' ? simbolo : ' '); // Sustituye '*' por el símbolo, si corresponde.
                }
                sb.append("│\n");
            } else {
                sb.append("│         │\n"); // Espacios vacíos para las líneas restantes.
            }
        }

        // Parte inferior de la carta.
        sb.append(String.format("│       %2s│\n", valor)); // Valor en la esquina inferior derecha.
        sb.append("└─────────┘\n");
        sb.append(String.format("    [%1d]    ", index)); // Muestra el índice de la carta.

        return sb.toString(); // Retorna la representación completa de la carta.
    }

    // Método estático para mostrar varias cartas en una sola línea.
    public static void mostrarCartasEnLinea(List<Carta> cartas, int lines, boolean withSymbol) {
        StringBuilder[] lineas = new StringBuilder[lines];
        for (int i = 0; i < lines; i++) {
            lineas[i] = new StringBuilder(); // Inicializa cada línea del diseño visual.
        }

        // Itera sobre cada carta y construye su representación.
        for (int i = 0; i < cartas.size(); i++) {
            Carta carta = cartas.get(i);
            String[] cartaLineas = carta.mostrarCarta(i, withSymbol).split("\n"); // Divide la carta en líneas.
            for (int j = 0; j < lines; j++) {
                lineas[j].append(cartaLineas[j]).append("  "); // Une las cartas horizontalmente.
            }
        }

        // Imprime todas las líneas generadas.
        for (StringBuilder linea : lineas) {
            System.out.println(linea.toString());
        }
    }
}
