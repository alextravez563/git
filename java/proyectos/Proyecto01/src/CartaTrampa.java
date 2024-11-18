import java.util.Scanner;

public class CartaTrampa extends Carta {
    public CartaTrampa(String valor, CartaFamilia familia) {
        super(valor, familia);
    }

    public void cambiarValor(String nuevoValor, CartaFamilia nuevaFamilia) {
        this.valor = nuevoValor;
        this.familia = nuevaFamilia;
    }

    public static CartaTrampa scanCartaTrampa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor de la carta trampa: ");
        System.out.println("Formato: (Valor)(Familia)");
        System.out.println("Valores: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A");
        System.out.println("Familias: C = Corazones, D = Diamantes, T = Treboles, P = Picas");
        System.out.println("Ejemplo: 2C = 2 de Corazones");
        String cartaTrampa = scanner.next();
        String valor = cartaTrampa.substring(0, cartaTrampa.length() - 1);
        String familia = cartaTrampa.substring(cartaTrampa.length() - 1);
        CartaFamilia cartaFamilia = CartaFamilia.stringToFamilia(familia);
        return new CartaTrampa(valor, cartaFamilia);
    }
}
