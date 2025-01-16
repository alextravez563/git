// La clase Departamento representa un departamento dentro de la organización.
// Cada departamento tiene un nombre, un jefe, y una lista de empleados asignados.
import java.util.ArrayList; // Importa la clase ArrayList para manejar listas dinámicas
import java.util.List; // Importa la interfaz List para una mayor flexibilidad

public class Departamento {
    // Atributos privados para encapsular los datos del departamento
    private String nombre; // Nombre del departamento
    private Jefe jefe; // Jefe del departamento (de tipo Jefe, que extiende a Empleado)
    private List<Empleado> empleados; // Lista de empleados que pertenecen al departamento

    // Constructor: Inicializa el departamento con su nombre y jefe
    public Departamento(String nombre, Jefe jefe) {
        this.nombre = nombre; // Asigna el nombre del departamento
        this.jefe = jefe; // Asigna el jefe del departamento
        this.empleados = new ArrayList<>(); // Inicializa la lista de empleados como una lista vacía
    }

    // Métodos Getters y Setters: Permiten acceder y modificar los atributos de manera controlada
    public String getNombre() {
        return nombre; // Devuelve el nombre del departamento
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Actualiza el nombre del departamento
    }

    public Jefe getJefe() {
        return jefe; // Devuelve el jefe del departamento
    }

    public void setJefe(Jefe jefe) {
        this.jefe = jefe; // Actualiza el jefe del departamento
    }

    public List<Empleado> getEmpleados() {
        return empleados; // Devuelve la lista de empleados asignados al departamento
    }

    // Método para asignar un empleado al departamento
    public void asignarEmpleado(Empleado empleado) {
        empleados.add(empleado); // Agrega el empleado a la lista de empleados del departamento
    }
}
