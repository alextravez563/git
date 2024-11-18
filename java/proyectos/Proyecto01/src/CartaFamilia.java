import util.ConsolaStyles;

public enum CartaFamilia {
    CORAZONES("Corazones", ConsolaStyles.BOLD + ConsolaStyles.RED + "♡" + ConsolaStyles.RESET),
    DIAMANTES("Diamantes", ConsolaStyles.BOLD + ConsolaStyles.BLUE + "♢" + ConsolaStyles.RESET),
    TREBOLES("Tréboles", ConsolaStyles.BOLD + ConsolaStyles.GREEN + "♧" + ConsolaStyles.RESET),
    PICAS("Picas", ConsolaStyles.BOLD + ConsolaStyles.BLACK + "♤" + ConsolaStyles.RESET);

    private final String nombre;
    private final String simbolo;

    CartaFamilia(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public static CartaFamilia stringToFamilia(String familia) {
        return switch (familia.toUpperCase()) {
            case "C" -> CORAZONES;
            case "D" -> DIAMANTES;
            case "T" -> TREBOLES;
            case "P" -> PICAS;
            default -> null;
        };
    }

}
