import java.util.ArrayList;
import java.util.List;

public class baraja<T extends carta> {
    // Atributo privado que representa una lista de cartas de tipo genérico T.
    private List<T> cartas = new ArrayList<>();

    // Método para agregar una carta a la baraja.
    public void agregarCarta(T carta) {
        cartas.add(carta); // Añade la carta recibida como parámetro a la lista de cartas.
    }

    // Método para mostrar todas las cartas en la baraja.
    public void mostrarCartas() {
        for (T carta : cartas) { // Itera sobre cada carta en la lista de cartas.
            System.out.println(carta); // Imprime la representación en texto de cada carta.
        }
    }

    public boolean estaVacia() {
        return false;
    }
}
