// La clase Jefe extiende la clase Empleado
// Representa a un jefe que puede aprobar o rechazar solicitudes de vacaciones
public class Jefe extends Empleado {

    // Constructor: Inicializa los datos de un jefe
    public Jefe(String nombre, int id, Departamento departamento) {
        // Llama al constructor de la clase base (Empleado) para reutilizar su lógica
        super(nombre, id, departamento);
    }

    // Método para aprobar o rechazar una solicitud de vacaciones
    public boolean aprobarSolicitud(SolicitudVacaciones solicitud) {
        // Verifica si la solicitud no es nula (es válida)
        if (solicitud != null) {
            // Si la solicitud es válida, actualiza su estado a "Aprobada"
            solicitud.actualizarEstado("Aprobada");
            return true; // Devuelve true para indicar que fue aprobada
        }
        // Si la solicitud es nula (inválida), actualiza su estado a "Rechazada"
        solicitud.actualizarEstado("Rechazada");
        return false; // Devuelve false para indicar que fue rechazada
    }
}
