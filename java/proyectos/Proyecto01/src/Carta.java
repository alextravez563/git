/*Proyecto 01 - Carta.java
        Alex Travez - Mateo Oviedo
        Fecha de realización: 18/11/2024
        Fecha de entrega: 20/11/2024
        */
//RESULTADOS:

import java.util.List;

// Clase abstracta que representa una Carta genérica en un juego de cartas.
// Esta clase no se puede instanciar directamente y sirve como base para otros tipos de cartas.
public abstract class Carta {
    protected String valor; // Valor de la carta, como "A", "K", "2", etc.
    protected CartaFamilia familia; // Familia o palo de la carta, como corazones o picas.

    // Constructor para inicializar una carta con un valor y una familia.
    public Carta(String valor, CartaFamilia familia) {
        this.valor = valor;
        this.familia = familia;
    }

    // Getter para obtener el valor de la carta.
    public String getValor() {
        return valor;
    }

    // Getter para obtener la familia o palo de la carta.
    public CartaFamilia getFamilia() {
        return familia;
    }

    // Sobrescribe el método toString para mostrar la carta en formato legible.
    @Override
    public String toString() {
        return valor + " de " + familia.getNombre() + " " + familia.getSimbolo();
    }

    // Método para generar una representación visual de una carta.
    // Incluye su índice y su valor visual en el mazo.
    public String mostrarCarta(int index) {
        StringBuilder sb = new StringBuilder();
        String simbolo = familia.getSimbolo(); // Obtiene el símbolo del palo.
        int valorNumerico = 1; // Representa una cantidad fija para ajustar diseño visual.

        // Construcción del diseño de la carta usando caracteres ASCII.
        sb.append("┌─────────┐\n");
        sb.append(String.format("│%2s       │\n", valor)); // Escribe el valor en la esquina superior izquierda.
        for (int i = 0; i < 3; i++) {
            sb.append("│         │\n"); // Espacios internos vacíos.
        }
        for (int i = 0; i < valorNumerico; i++) {
            sb.append(String.format("│    %s    │\n", simbolo)); // Simbolo central de la carta.
        }
        for (int i = 0; i < 3; i++) {
            sb.append("│         │\n"); // Más espacios internos vacíos.
        }
        sb.append(String.format("│       %2s│\n", valor)); // Escribe el valor en la esquina inferior derecha.
        sb.append("└─────────┘\n");
        sb.append(String.format("    [%1d]    ", index)); // Índice para referencia externa.

        return sb.toString(); // Retorna la representación completa de la carta.
    }

    // Método para mostrar múltiples cartas en una sola línea.
    public static void mostrarCartasEnLinea(List<Carta> cartas) {
        mostrarCartasEnLinea(cartas, 12); // Llama a la sobrecarga del método con 12 líneas como predeterminado.
    }

    // Método sobrecargado para mostrar múltiples cartas con un número de líneas configurable.
    public static void mostrarCartasEnLinea(List<Carta> cartas, int lines) {
        StringBuilder[] lineas = new StringBuilder[lines];
        for (int i = 0; i < lines; i++) {
            lineas[i] = new StringBuilder(); // Inicializa cada línea del diseño visual.
        }

        // Recorre cada carta y genera su representación visual.
        for (int i = 0; i < cartas.size(); i++) {
            Carta carta = cartas.get(i);
            String[] cartaLineas = carta.mostrarCarta(i).split("\n"); // Divide la carta en líneas.
            for (int j = 0; j < lines; j++) {
                lineas[j].append(cartaLineas[j]).append("  "); // Combina las cartas horizontalmente.
            }
        }

        // Imprime todas las líneas que forman las cartas.
        for (StringBuilder linea : lineas) {
            System.out.println(linea.toString());
        }
    }
}

/*
 Conclusiones
1-La abstracción de la clase Carta permite una clara organización del código, facilitando la creación de diferentes tipos de cartas y familias, lo cual es esencial para el diseño de juegos de cartas complejos.
2-El método mostrarCarta proporciona una representación visual detallada y creativa, haciendo más amigable la interacción con el programa, especialmente útil en juegos por consola.
3-El uso de la clase StringBuilder optimiza la manipulación de cadenas, mejorando el rendimiento en comparación con la concatenación directa mediante operadores.
4-El código demuestra un enfoque modular y reutilizable, separando responsabilidades, lo cual es crucial para mantener la escalabilidad y el mantenimiento del proyecto.
Recomendaciones
1-Implementar un método dinámico para asignar el número de símbolos en la carta (valorNumerico) basado en el valor real (por ejemplo, "2" muestra dos símbolos), para hacer la representación más precisa y realista.
2-Incorporar validaciones adicionales en el constructor de la clase Carta para verificar que los valores y las familias proporcionados sean válidos, evitando posibles inconsistencias o errores.
3-Documentar la clase Carta y sus métodos con comentarios en formato Javadoc para facilitar la comprensión del código a otros desarrolladores.
4-Añadir pruebas unitarias que validen el comportamiento de los métodos, como mostrarCarta y mostrarCartasEnLinea, para garantizar la funcionalidad y detectar errores durante futuros cambios.
 */