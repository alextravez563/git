import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {
    protected String nombre;
    protected List<Carta21> mano;

    // Constructor que inicializa el nombre y la mano del jugador
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    // Getter para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Método para agregar una carta a la mano
    public void agregarCartaMano(Carta21 carta) {
        mano.add(carta);
    }

    // Método abstracto para calcular el puntaje
    public abstract int calcularPuntaje();

    // Método para mostrar la mano del jugador
    public void mostrarMano() {
        for (Carta21 carta : mano) {
            System.out.println(carta);
        }
    }
}
