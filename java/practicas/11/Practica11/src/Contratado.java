// La clase Contratado extiende la funcionalidad de la clase Empleado
// Representa a un empleado contratado bajo un esquema específico.
public class Contratado extends Empleado {

    // Constructor: Inicializa los datos de un empleado contratado
    public Contratado(String nombre, int id, Departamento departamento) {
        // Llama al constructor de la clase base (Empleado) para reutilizar su lógica
        super(nombre, id, departamento);
    }

    // Método específico para verificar la vigencia del contrato
    public boolean contratoVigente() {
        // Aquí se supone que habría lógica adicional para determinar si el contrato está vigente.
        // Por ejemplo, podríamos verificar una fecha de finalización del contrato.
        return true; // En este caso, devolvemos 'true' como un valor predeterminado.
    }

    // Sobrescritura (override) del método solicitarVacaciones de la clase base
    @Override
    public boolean solicitarVacaciones(int dias) {
        // Verifica primero si el contrato del empleado está vigente
        if (!contratoVigente()) { // Si el contrato no está vigente:
            System.out.println("El contrato no está vigente."); // Imprime un mensaje informativo
            return false; // Devuelve 'false' indicando que no se puede procesar la solicitud
        }
        // Si el contrato está vigente, llama al método de la clase base para procesar la solicitud
        return super.solicitarVacaciones(dias); // Reutiliza la lógica de la clase base
    }
}
