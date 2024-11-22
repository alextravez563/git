import java.util.ArrayList;
import java.util.List;

public abstract class Entrenador {
    private int id;
    private String cedula;
    private String nombres;
    private String apellidos;
    private List<Perro> perros;

    public Entrenador(int id, String cedula, String nombres, String apellidos) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.perros = new ArrayList<>();
    }

    public void agregarPerro(Perro perro) {
        perros.add(perro);
    }

    public int getNumeroDePerros() {
        return perros.size();
    }

    public double getEdadPromedioPerros() {
        if (perros.isEmpty()) return 0;
        return perros.stream().mapToInt(Perro::getEdad).average().orElse(0);
    }

    public List<Perro> getPerros() {
        return perros;
    }

    @Override
    public String toString() {
        StringBuilder infoPerros = new StringBuilder();
        for (Perro perro : perros) {
            infoPerros.append(perro.toString()).append("\n");
        }
        return "Entrenador ID: " + id + " - Nombre: " + nombres + " " + apellidos +
                "\nTotal Perros: " + getNumeroDePerros() +
                "\nEdad Promedio Perros: " + getEdadPromedioPerros() +
                "\nPerros:\n" + infoPerros;
    }

    public abstract String presentacionEspecifica();
}
