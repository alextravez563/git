import java.util.Collections;
import java.util.Stack;

public class Baraja implements Repartidor {
    private Stack<Carta21> mazo;

    // Constructor que inicializa el mazo con 52 cartas
    public Baraja() {
        mazo = new Stack<>();
        String[] familias = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String familia : familias) {
            for (String valor : valores) {
                mazo.push(new Carta21(familia, valor));
            }
        }
    }

    // Método para barajar el mazo
    @Override
    public void barajar() {
        Collections.shuffle(mazo);
    }

    // Método para repartir una carta del mazo
    @Override
    public Carta21 repartirCarta() {
        return mazo.pop();
    }

    // Clase anidada para manejar cartas especiales
    public static class CartaEspecial extends Carta21 {
        public CartaEspecial() {
            super("Especial", "Joker");
        }

        @Override
        public int getPuntos() {
            return 0;
        }
    }
}
