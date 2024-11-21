
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Clase que representa una carta trampa, que extiende la funcionalidad de la clase base Carta.
public class CartaTrampa extends Carta {
    // Constructor que inicializa una carta trampa con un valor y una familia.
    public CartaTrampa(String valor, CartaFamilia familia) {
        super(valor, familia);
    }
    private static final List<String> VALID_VALUES = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    // Método estático para leer una carta trampa desde la entrada del usuario.
    public static CartaTrampa scanCartaTrampa() {
            Scanner scanner = new Scanner(System.in);
            String cartaTrampa;
            String valor;
            String familia;
            CartaFamilia cartaFamilia;

            while (true) {
                System.out.println("Ingrese el valor de la carta trampa: ");
                System.out.println("Formato: (Valor)(Familia)");
                System.out.println("Valores: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A");
                System.out.println("Familias: C = Corazones, D = Diamantes, T = Treboles, P = Picas");
                System.out.println("Ejemplo: 2C = 2 de Corazones");

                cartaTrampa = scanner.next();

                if (cartaTrampa.length() > 1) {
                    valor = cartaTrampa.substring(0, cartaTrampa.length() - 1);
                    familia = cartaTrampa.substring(cartaTrampa.length() - 1);
                    cartaFamilia = CartaFamilia.stringToFamilia(familia);

                    if (VALID_VALUES.contains(valor) && cartaFamilia != null) {
                        break;
                    }
                }

                System.out.println("Formato inválido. Por favor, ingrese nuevamente.");
            }

            return new CartaTrampa(valor, cartaFamilia);
    }
}
