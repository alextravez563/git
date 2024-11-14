// Practica04-Persona
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realización: 13/06/2024
// Fecha de entrega: 14/06/2024
//Resultados:
//Se creó la clase Carta con los atributos familia y valor, un constructor que inicializa estos atributos y el método toString() para representar la carta en el formato de texto adecuado.

//Conclusiones:
//Esta clase permite almacenar información básica de una carta de baraja estándar, facilitando su uso en el juego y brindando una manera fácil de representar cada carta como una cadena de texto.

//Recomendaciones:
//Asegúrate de que los valores de las cartas sean correctos para evitar errores al representar el mazo completo.

// Bibliografía
// Diapositivas del docente

// Clase Carta - Representa una carta de la baraja
public class Carta {
    private String familia; // Atributo de la familia de la carta
    private String valor;   // Atributo del valor de la carta

    // Constructor para inicializar la familia y el valor de la carta
    public Carta(String familia, String valor) {
        this.familia = familia;
        this.valor = valor;
    }

    // Getter para obtener la familia de la carta
    public String getFamilia() {
        return familia;
    }

    // Getter para obtener el valor de la carta
    public String getValor() {
        return valor;
    }

    // Sobrecarga del método toString para representar la carta como "valor de familia"
    @Override
    public String toString() {
        return valor + " de " + familia;
    }
}
