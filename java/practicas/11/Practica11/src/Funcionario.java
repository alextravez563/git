public class Funcionario extends Empleado { // La clase Funcionario hereda de la clase Empleado.
    private int diasPrestados;             // Días de vacaciones tomados "prestados" del próximo año.

    // Constructor
    public Funcionario(String nombre, int id, Departamento departamento) {
        super(nombre, id, departamento);    // Llama al constructor de la clase base (Empleado).
        this.diasPrestados = 0;             // Inicializa los días prestados a 0.
    }

    // Getters y Setters
    public int getDiasPrestados() {         // Devuelve los días de vacaciones prestados.
        return diasPrestados;
    }

    public void setDiasPrestados(int diasPrestados) { // Permite establecer los días prestados.
        this.diasPrestados = diasPrestados;
    }

    // Métodos adicionales

    // Método para solicitar un préstamo de días de vacaciones del próximo año.
    public boolean pedirPrestamoVacaciones(int dias) {
        if (dias <= 10 && diasPrestados + dias <= 10) { // Verifica que no exceda el máximo permitido (10 días).
            diasPrestados += dias;                     // Suma los días solicitados a los días prestados actuales.
            return true;                               // Devuelve true si el préstamo fue exitoso.
        } else {
            return false;                              // Devuelve false si no se puede aprobar el préstamo.
        }
    }

    @Override
    public boolean solicitarVacaciones(int dias) { // Sobrescribe el método solicitarVacaciones de Empleado.
        if (dias <= getDiasVacaciones() + diasPrestados) { // Verifica si los días solicitados no exceden el total disponible (días actuales + prestados).
            if (dias <= getDiasVacaciones()) {            // Caso 1: Los días solicitados están cubiertos por los días disponibles.
                setDiasVacaciones(getDiasVacaciones() - dias); // Resta los días solicitados del saldo actual.
            } else {                                      // Caso 2: Los días solicitados exceden los días disponibles actuales.
                int restante = dias - getDiasVacaciones(); // Calcula los días adicionales necesarios.
                setDiasVacaciones(0);                     // Establece los días disponibles actuales en 0.
                diasPrestados -= restante;                // Resta los días adicionales de los días prestados.
            }
            return true;                                  // Devuelve true si se aprobaron las vacaciones.
        } else {
            return false;                                 // Devuelve false si no hay suficientes días disponibles.
        }
    }
}
