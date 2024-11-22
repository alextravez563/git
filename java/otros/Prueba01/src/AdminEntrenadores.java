import java.util.ArrayList;
import java.util.List;

public class AdminEntrenadores {
    private List<Entrenador> entrenadores;

    public AdminEntrenadores() {
        this.entrenadores = new ArrayList<>();
    }

    public void agregarEntrenador(Entrenador entrenador) {
        entrenadores.add(entrenador);
    }

    public String presentarInfo() {
        StringBuilder info = new StringBuilder();
        for (Entrenador entrenador : entrenadores) {
            info.append(entrenador.toString()).append("\n");
        }
        return info.toString();
    }
}
