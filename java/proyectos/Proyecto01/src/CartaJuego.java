
import java.util.ArrayList;
import java.util.List;

// Clase que extiende la clase abstracta Carta, diseñada para representar cartas de un juego específico.
public class CartaJuego extends Carta {
    // Constructor que inicializa una carta de juego con un valor y una familia.
    public CartaJuego(String valor, CartaFamilia familia) {
        super(valor, familia);
    }

    // Método estático para crear una baraja estándar de 52 cartas (sin comodines).
    public static List<CartaJuego> crearBaraja() {
        // Valores estándar de las cartas en un mazo.
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        // Familias o palos disponibles en un mazo estándar.
        CartaFamilia[] familias = {CartaFamilia.CORAZONES, CartaFamilia.DIAMANTES, CartaFamilia.TREBOLES, CartaFamilia.PICAS};
        
        // Lista donde se almacenarán todas las cartas generadas.
        List<CartaJuego> baraja = new ArrayList<>();

        // Itera sobre cada valor y cada familia para crear todas las combinaciones posibles.
        for (String valor : valores) {
            for (CartaFamilia familia : familias) {
                baraja.add(new CartaJuego(valor, familia)); // Crea una carta y la agrega a la lista.
            }
        }

        // Retorna la lista completa de cartas.
        return baraja;
    }
}
