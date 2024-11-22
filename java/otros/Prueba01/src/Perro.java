public class Perro {
    private String chip;
    private String nombre;
    private int edad;
    private String raza;

    public Perro(String chip, String nombre, int edad, String raza) {
        this.chip = chip;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Perro [Chip: " + chip + ", Nombre: " + nombre + ", Edad: " + edad + ", Raza: " + raza + "]";
    }
}
