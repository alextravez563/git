package util;

// Clase que contiene utilidades para aplicar estilos y colores en texto de consola.
public class ConsolaStyles {
    // Códigos ANSI para reiniciar estilos y aplicar formatos de texto.
    public static final String RESET = "\033[0m";  // Reinicia cualquier estilo aplicado.
    public static final String BOLD = "\033[1m";   // Texto en negrilla.
    public static final String UNDERLINE = "\033[4m"; // Texto subrayado.

    // Códigos ANSI para colores de texto.
    public static final String BLACK = "\033[30m"; // Texto negro.
    public static final String WHITE = "\033[37m"; // Texto blanco.
    public static final String RED = "\033[31m";   // Texto rojo.
    public static final String GREEN = "\033[32m"; // Texto verde.
    public static final String YELLOW = "\033[33m"; // Texto amarillo.
    public static final String BLUE = "\033[34m";   // Texto azul.
    public static final String PURPLE = "\033[35m"; // Texto violeta.
    public static final String ORANGE = "\033[36m"; // Texto naranja (cyan en ANSI).

    // Códigos ANSI para colores de fondo.
    public static final String BLACK_BACKGROUND = "\033[40m"; // Fondo negro.
    public static final String WHITE_BACKGROUND = "\033[47m"; // Fondo blanco.
    public static final String RED_BACKGROUND = "\033[41m";   // Fondo rojo.
    public static final String GREEN_BACKGROUND = "\033[42m"; // Fondo verde.
    public static final String YELLOW_BACKGROUND = "\033[43m"; // Fondo amarillo.
    public static final String BLUE_BACKGROUND = "\033[44m";   // Fondo azul.
    public static final String PURPLE_BACKGROUND = "\033[45m"; // Fondo violeta.
    public static final String CYAN_BACKGROUND = "\033[46m";   // Fondo cyan.

    // Método para imprimir un título estilizado con caracteres de separación predeterminados ('-').
    public static void printTitle(String title) {
        printTitle('-', title); // Llama al método sobrecargado con un carácter predeterminado.
    }

    // Método para imprimir un título con un carácter específico como separador.
    public static void printTitle(char c, String title) {
        printTitle(35, c, title); // Llama al método sobrecargado con una longitud predeterminada de 35.
    }

    // Método para imprimir un título con un separador personalizado y una longitud específica.
    public static void printTitle(int n, char c, String title) {
        StringBuilder sb = new StringBuilder(); // Crea un `StringBuilder` para construir la línea de separación.
        sb.append(String.valueOf(c).repeat(Math.max(0, n))); // Repite el carácter `c` n veces.
        System.out.println(sb + " " + title + " " + sb); // Imprime la línea de separación, el título y otra línea de separación.
    }

    // Método para obtener texto estilizado con un color y formato específico.
    public static String getTextoEstilado(String text, String color) {
        return ConsolaStyles.BOLD + color + text + ConsolaStyles.RESET; // Aplica negrilla, color y resetea el estilo al final.
    }

    // Método `main` para probar los estilos y colores definidos.
    public static void main(String[] args) {
        // Ejemplos de texto con diferentes estilos y colores.
        System.out.println(BOLD + "NEGRILLA" + RESET);
        System.out.println(UNDERLINE + "SUBRRAYADO" + RESET);
        System.out.println(BLACK + "TEXTO NEGRO" + RESET);
        System.out.println(WHITE + "TEXTO BLANCO" + RESET);
        System.out.println(RED + "TEXTO ROJO" + RESET);
        System.out.println(GREEN + "TEXTO VERDE" + RESET);
        System.out.println(YELLOW + "TEXTO AMARILLO" + RESET);
        System.out.println(BLUE + "TEXTO AZUL" + RESET);
        System.out.println(PURPLE + "TEXTO VIOLETA" + RESET);
        System.out.println(ORANGE + "TEXTO NARANJA" + RESET);
        
        // Ejemplos de texto con diferentes colores de fondo.
        System.out.println(BLACK_BACKGROUND + "FONDO NEGRO" + RESET);
        System.out.println(WHITE_BACKGROUND + "FONDO BLANCO" + RESET);
        System.out.println(RED_BACKGROUND + "FONDO ROJO" + RESET);
        System.out.println(GREEN_BACKGROUND + "FONDO VERDE" + RESET);
        System.out.println(YELLOW_BACKGROUND + "FONDO AMARILLO" + RESET);
        System.out.println(BLUE_BACKGROUND + "FONDO AZUL" + RESET);
        System.out.println(PURPLE_BACKGROUND + "FONDO VIOLETA" + RESET);
        System.out.println(CYAN_BACKGROUND + "FONDO CYAN" + RESET);
    }
}
