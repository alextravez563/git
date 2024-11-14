// Practica05-Carta21
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realización: 14/06/2024
// Fecha de entrega: 14/06/2024
/*
 * Resultados:
 * Esta clase hereda de Carta y añade la funcionalidad específica de puntaje
 * para el juego de 21, donde el As vale 11 y las cartas J, Q, y K valen 10.
 *
 * Conclusiones:
 * Permite calcular el puntaje necesario en el juego, adaptando la funcionalidad
 * de Carta a los requerimientos de puntaje del juego 21.
 *
 * Recomendaciones:
 * Añadir control para posibles valores inválidos si se agregan cartas especiales.
 */
// Bibliografía
// Diapositivas del docente

// Carta21.java

// Clase Carta21 que extiende Carta y agrega lógica específica para el juego 21
public class Carta21 extends Carta {
    // Constructor que llama al constructor de la superclase Carta
    public Carta21(String familia, String valor) {
        super(familia, valor);
    }

    // Método para obtener el valor en puntos de la carta según las reglas del juego 21
    public int getPuntos() {
        switch (getValor()) {
            case "A":
                return 11; // El As vale 11 puntos
            case "J":
            case "Q":
            case "K":
                return 10; // Las cartas J, Q y K valen 10 puntos
            default:
                return Integer.parseInt(getValor()); // Las demás cartas valen su número
        }
    }
}
