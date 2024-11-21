import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Clase que representa una carta trampa, la cual extiende la funcionalidad de la clase base Carta.
// Una carta trampa puede ser creada directamente o mediante entrada del usuario.
public class CartaTrampa extends Carta {

    // Constructor que inicializa una carta trampa con un valor y una familia.
    public CartaTrampa(String valor, CartaFamilia familia) {
        super(valor, familia); // Llama al constructor de la clase base (Carta).
    }

    // Lista de valores válidos para las cartas trampas.
    // Esto asegura que solo se acepten valores estándar del mazo.
    private static final List<String> VALID_VALUES = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");

    // Método estático que permite crear una CartaTrampa leyendo la entrada del usuario.
    public static CartaTrampa scanCartaTrampa() {
        Scanner scanner = new Scanner(System.in); // Abre un escáner para leer la entrada del usuario.
        String cartaTrampa; // Cadena para almacenar la entrada del usuario.
        String valor; // Cadena para almacenar el valor de la carta.
        String familia; // Cadena para almacenar la familia de la carta.
        CartaFamilia cartaFamilia; // Variable que almacena la familia como un objeto `CartaFamilia`.

        // Bucle infinito para solicitar al usuario una carta válida.
        while (true) {
            System.out.println("Ingrese el valor de la carta trampa: ");
            System.out.println("Formato: (Valor)(Familia)");
            System.out.println("Valores: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A");
            System.out.println("Familias: C = Corazones, D = Diamantes, T = Treboles, P = Picas");
            System.out.println("Ejemplo: 2C = 2 de Corazones");

            cartaTrampa = scanner.next(); // Lee la entrada del usuario.

            // Verifica que la longitud de la entrada sea válida (al menos dos caracteres).
            if (cartaTrampa.length() > 1) {
                // Extrae el valor y la familia de la entrada.
                valor = cartaTrampa.substring(0, cartaTrampa.length() - 1); // Todo excepto el último carácter.
                familia = cartaTrampa.substring(cartaTrampa.length() - 1); // Solo el último carácter.

                // Convierte la familia de texto a un objeto `CartaFamilia`.
                cartaFamilia = CartaFamilia.stringToFamilia(familia);

                // Verifica que el valor esté en la lista de valores válidos y que la familia sea válida.
                if (VALID_VALUES.contains(valor) && cartaFamilia != null) {
                    break; // Sale del bucle si los datos son válidos.
                }
            }

            // Si los datos son inválidos, muestra un mensaje de error y repite el proceso.
            System.out.println("Formato inválido. Por favor, ingrese nuevamente.");
        }

        // Crea y retorna una nueva instancia de CartaTrampa con los valores ingresados.
        return new CartaTrampa(valor, cartaFamilia);
    }
}
