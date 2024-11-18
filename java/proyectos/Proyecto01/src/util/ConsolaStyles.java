package util;

public class ConsolaStyles {
    // ANSI code para estilos de texto
    public static final String RESET = "\033[0m";  // RESET
    public static final String BOLD = "\033[1m";
    public static final String UNDERLINE = "\033[4m";

    // ANSI code para colores de texto
    public static final String BLACK = "\033[30m";
    public static final String WHITE = "\033[37m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String PURPLE = "\033[35m";
    public static final String ORANGE = "\033[36m";


    // ANSI code para colores de fondo
    public static final String BLACK_BACKGROUND = "\033[40m";
    public static final String WHITE_BACKGROUND = "\033[47m";
    public static final String RED_BACKGROUND = "\033[41m";
    public static final String GREEN_BACKGROUND = "\033[42m";
    public static final String YELLOW_BACKGROUND = "\033[43m";
    public static final String BLUE_BACKGROUND = "\033[44m";
    public static final String PURPLE_BACKGROUND = "\033[45m";
    public static final String CYAN_BACKGROUND = "\033[46m";

    public static void print(String text, String style) {
        System.out.println(style + text + RESET);
    }

    public static void print(String text, String style, String color) {
        System.out.println(style + color + text + RESET);
    }

    public static void print(String text, String style, String color, String background) {
        System.out.println(style + color + background + text + RESET);
    }

    public static void printCharts(int i, char c) {
        for (int j = 0; j < i; j++) {
            System.out.print(c);
        }
    }

    public static void printTitle(String title) {
        printTitle('-', title);
    }

    public static void printTitle(char c, String title) {
        printTitle(35, c, title);
    }

    public static void printTitle(int n, char c, String title) {

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(c).repeat(Math.max(0, n)));
        System.out.println(sb + " " + title + " " + sb);

    }


    public static void main(String[] args) {
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
