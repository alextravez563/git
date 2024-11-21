import util.ConsolaStyles;

// Enumeración que representa las familias o palos de las cartas de un mazo estándar.
// Cada familia tiene un nombre (e.g., "Corazones"), un símbolo (e.g., "♡") y un color asociado.
public enum CartaFamilia {
    // Define las cuatro familias estándar de cartas con sus atributos:
    CORAZONES("Corazones", "♡", ConsolaStyles.RED),   // Corazones con símbolo "♡" y color rojo.
    DIAMANTES("Diamantes", "♢", ConsolaStyles.BLUE), // Diamantes con símbolo "♢" y color azul.
    TREBOLES("Tréboles", "♧", ConsolaStyles.GREEN),  // Tréboles con símbolo "♧" y color verde.
    PICAS("Picas", "♤", ConsolaStyles.BLACK);        // Picas con símbolo "♤" y color negro.

    private final String nombre; // Nombre legible del palo (e.g., "Corazones").
    private final String simbolo; // Representación visual del palo (e.g., "♡").
    private final String color; // Color asociado al palo (usando estilos de consola).

    // Constructor privado (propio de las enumeraciones) que inicializa los atributos.
    CartaFamilia(String nombre, String simbolo, String color) {
        this.nombre = nombre; // Asigna el nombre del palo.
        this.simbolo = simbolo; // Asigna el símbolo visual del palo.
        this.color = color; // Asigna el color asociado al palo.
    }

    // Devuelve el nombre del palo (e.g., "Corazones").
    public String getNombre() {
        return nombre;
    }

    // Devuelve el símbolo estilizado del palo, aplicando el color correspondiente.
    public String getSimbolo() {
        return ConsolaStyles.getTextoEstilado(simbolo, color);
    }

    // Devuelve el color asociado al palo.
    public String getColor() {
        return color;
    }

    // Método estático para convertir una cadena de texto en una instancia de CartaFamilia.
    // Útil para mapear abreviaturas de texto (e.g., "C" para Corazones) a las familias definidas.
    public static CartaFamilia stringToFamilia(String familia) {
        return switch (familia.toUpperCase()) { // Convierte el texto a mayúsculas para comparación.
            case "C" -> CORAZONES; // "C" corresponde a CORAZONES.
            case "D" -> DIAMANTES; // "D" corresponde a DIAMANTES.
            case "T" -> TREBOLES;  // "T" corresponde a TRÉBOLES.
            case "P" -> PICAS;     // "P" corresponde a PICAS.
            default -> null;       // Retorna null si no coincide con ninguna familia.
        };
    }
}
