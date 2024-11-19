
import java.util.Scanner;

// Clase que representa una carta trampa, que extiende la funcionalidad de la clase base Carta.
public class CartaTrampa extends Carta {
    // Constructor que inicializa una carta trampa con un valor y una familia.
    public CartaTrampa(String valor, CartaFamilia familia) {
        super(valor, familia);
    }

    // Método para cambiar el valor y la familia de una carta trampa de manera dinámica.
    public void cambiarValor(String nuevoValor, CartaFamilia nuevaFamilia) {
        this.valor = nuevoValor; // Actualiza el valor de la carta.
        this.familia = nuevaFamilia; // Actualiza la familia de la carta.
    }

    // Método estático para leer una carta trampa desde la entrada del usuario.
    public static CartaTrampa scanCartaTrampa() {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer datos de entrada.
        
        // Instrucciones para el usuario.
        System.out.println("Ingrese el valor de la carta trampa: ");
        System.out.println("Formato: (Valor)(Familia)");
        System.out.println("Valores: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A");
        System.out.println("Familias: C = Corazones, D = Diamantes, T = Treboles, P = Picas");
        System.out.println("Ejemplo: 2C = 2 de Corazones");

        // Captura la entrada del usuario.
        String cartaTrampa = scanner.next();
        
        // Extrae el valor de la carta (todo menos el último carácter).
        String valor = cartaTrampa.substring(0, cartaTrampa.length() - 1);
        
        // Extrae la familia de la carta (el último carácter).
        String familia = cartaTrampa.substring(cartaTrampa.length() - 1);
        
        // Convierte la representación de la familia en un objeto CartaFamilia.
        CartaFamilia cartaFamilia = CartaFamilia.stringToFamilia(familia);
        
        // Crea y retorna una nueva instancia de CartaTrampa con los valores capturados.
        return new CartaTrampa(valor, cartaFamilia);
    }
}
