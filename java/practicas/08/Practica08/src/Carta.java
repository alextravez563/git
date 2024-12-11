import java.io.Serializable;

/**
 * Clase Carta representa una carta de una baraja y permite su serialización.
 * Implementa la interfaz Serializable para convertir los objetos en una secuencia de bytes.
 */
public class Carta implements Serializable {

    // serialVersionUID se utiliza para verificar la compatibilidad entre clases durante la serialización
    private static final long serialVersionUID = 1L;

    // Atributos privados de la carta
    private String valor;   // Valor de la carta (e.g., "As", "2", "10", "K")
    private String familia; // Familia de la carta (e.g., "Corazones", "Picas")

    /**
     * Constructor para inicializar los atributos de la carta.
     *
     * @param valor   el valor de la carta
     * @param familia la familia de la carta
     */
    public Carta(String valor, String familia) {
        this.valor = valor;
        this.familia = familia;
    }

    /**
     * Sobrescribe el método toString para presentar la información de la carta en formato amigable.
     *
     * @return descripción de la carta
     */
    @Override
    public String toString() {
        return valor + " de " + familia;
    }

    /**
     * Devuelve el valor de la carta.
     *
     * @return el valor como cadena
     */
    public String getValor() {
        return valor;
    }

    /**
     * Devuelve el valor numérico de la carta.
     * Si el valor no es un número (As, J, Q, K), asigna valores específicos:
     * - As vale 1 (o 11, según el cálculo externo del puntaje).
     * - J, Q, K valen 10.
     *
     * @return el valor numérico de la carta
     */
    public int getValorNumerico() {
        try {
            // Intenta convertir el valor de la carta a un número entero
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            // Si no es un número, asigna valores específicos
            if (valor.equals("As")) {
                return 1;
            } else {
                return 10;
            }
        }
    }
}
