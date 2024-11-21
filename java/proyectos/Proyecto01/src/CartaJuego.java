
import java.util.ArrayList;
import java.util.List;

// Clase concreta que extiende la clase abstracta Carta.
// Diseñada para representar cartas en un juego específico.
public class CartaJuego extends Carta {

    // Constructor que inicializa una carta de juego con un valor y una familia.
    public CartaJuego(String valor, CartaFamilia familia) {
        super(valor, familia); // Llama al constructor de la clase base (Carta).
    }

    // Método estático que crea una baraja estándar de 52 cartas (sin comodines).
    public static List<CartaJuego> crearBaraja() {
        // Arreglo de valores estándar de las cartas en un mazo (números y figuras).
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        // Arreglo de las familias (palos) disponibles en un mazo estándar.
        CartaFamilia[] familias = {CartaFamilia.CORAZONES, CartaFamilia.DIAMANTES, CartaFamilia.TREBOLES, CartaFamilia.PICAS};
        
        // Lista para almacenar todas las combinaciones de cartas.
        List<CartaJuego> baraja = new ArrayList<>();

        // Bucle anidado para generar todas las combinaciones de valores y familias.
        for (String valor : valores) { // Itera sobre cada valor.
            for (CartaFamilia familia : familias) { // Itera sobre cada familia.
                baraja.add(new CartaJuego(valor, familia)); // Crea una carta con el valor y la familia.
            }
        }

        // Retorna la baraja completa de 52 cartas.
        return baraja;
    }
}
