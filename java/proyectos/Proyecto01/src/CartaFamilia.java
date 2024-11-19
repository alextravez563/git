

import util.ConsolaStyles;

// Enumeración que representa las familias o palos de las cartas de un mazo estándar.
// Cada familia tiene un nombre y un símbolo estilizado para representación visual.
public enum CartaFamilia {
    CORAZONES("Corazones", ConsolaStyles.BOLD + ConsolaStyles.RED + "♡" + ConsolaStyles.RESET),
    DIAMANTES("Diamantes", ConsolaStyles.BOLD + ConsolaStyles.BLUE + "♢" + ConsolaStyles.RESET),
    TREBOLES("Tréboles", ConsolaStyles.BOLD + ConsolaStyles.GREEN + "♧" + ConsolaStyles.RESET),
    PICAS("Picas", ConsolaStyles.BOLD + ConsolaStyles.BLACK + "♤" + ConsolaStyles.RESET);

    private final String nombre; // Nombre legible del palo (e.g., "Corazones").
    private final String simbolo; // Representación estilizada del palo (e.g., "♡").

    // Constructor de la enumeración que inicializa el nombre y el símbolo de cada familia.
    CartaFamilia(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    // Devuelve el nombre de la familia.
    public String getNombre() {
        return nombre;
    }

    // Devuelve el símbolo estilizado de la familia.
    public String getSimbolo() {
        return simbolo;
    }

    // Método estático que convierte una cadena de texto en una familia de cartas.
    // Útil para interpretar entradas de usuario o configuraciones externas.
    public static CartaFamilia stringToFamilia(String familia) {
        return switch (familia.toUpperCase()) { // Convierte la cadena a mayúsculas para comparación.
            case "C" -> CORAZONES; // "C" corresponde a CORAZONES.
            case "D" -> DIAMANTES; // "D" corresponde a DIAMANTES.
            case "T" -> TREBOLES;  // "T" corresponde a TRÉBOLES.
            case "P" -> PICAS;     // "P" corresponde a PICAS.
            default -> null;       // Retorna null si no hay coincidencia.
        };
    }
}

