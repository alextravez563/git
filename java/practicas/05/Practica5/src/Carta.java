// Practica05-Carta
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realización: 14/06/2024
// Fecha de entrega: 14/06/2024


/*
 * Resultados:
 * Se creó la clase Carta con atributos para la familia y el valor, un constructor
 * para inicializar estos atributos, y el método toString() que permite representar
 * cada carta en formato de texto.
 *
 * Conclusiones:
 * Esta clase representa una carta estándar de la baraja, facilitando la creación
 * y el manejo de cartas dentro del juego.
 *
 * Recomendaciones:
 * Verificar siempre los valores de entrada en caso de expansión para nuevas
 * cartas o valores.
 */

// Bibliografía
// Diapositivas del docente

// Clase Carta que representa una carta genérica en un juego de cartas
public class Carta {
    // Atributos privados de la carta
    private String familia; // Familia de la carta (e.g., Corazones, Tréboles)
    private String valor;   // Valor de la carta (e.g., "2", "K", "A")

    // Constructor que inicializa los atributos de la carta
    public Carta(String familia, String valor) {
        this.familia = familia;
        this.valor = valor;
    }

    // Método getter para obtener la familia de la carta
    public String getFamilia() {
        return familia;
    }

    // Método getter para obtener el valor de la carta
    public String getValor() {
        return valor;
    }

    // Sobrecarga del método toString para mostrar la carta como "valor de familia"
    @Override
    public String toString() {
        return valor + " de " + familia;
    }
}
