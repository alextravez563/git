import java.util.ArrayList; // Importa la clase ArrayList que permite manejar listas dinámicas.
import java.util.List;      // Importa la interfaz List, que define el comportamiento general de listas.

public class SistemaGestionVacaciones {
    private List<Empleado> empleados;          // Lista que almacena los empleados registrados en el sistema.
    private List<Departamento> departamentos;  // Lista que almacena los departamentos registrados.

    // Constructor
    public SistemaGestionVacaciones() {
        this.empleados = new ArrayList<>();          // Inicializa la lista de empleados como un ArrayList vacío.
        this.departamentos = new ArrayList<>();      // Inicializa la lista de departamentos como un ArrayList vacío.
    }

    // Método para asignar 21 días de vacaciones anuales a todos los empleados.
    public void asignarVacacionesAnuales() {
        for (Empleado empleado : empleados) {        // Itera sobre cada empleado en la lista de empleados.
            empleado.setDiasVacaciones(             // Actualiza los días de vacaciones del empleado.
                    empleado.getDiasVacaciones() + 21   // Suma 21 días a los días de vacaciones actuales.
            );
        }
    }

    // Método para procesar una solicitud de vacaciones realizada por un empleado.
    public void procesarSolicitud(SolicitudVacaciones solicitud) {
        if (solicitud != null) {                     // Verifica que la solicitud no sea nula.
            Jefe jefe = solicitud.getEmpleado()      // Obtiene el jefe del departamento al que pertenece el empleado.
                    .getDepartamento()
                    .getJefe();
            boolean aprobada = jefe.aprobarSolicitud(solicitud); // El jefe evalúa si aprueba la solicitud.
            if (aprobada) {                          // Si la solicitud es aprobada...
                solicitud.getEmpleado()              // El empleado consume los días solicitados.
                        .solicitarVacaciones(solicitud.getDiasSolicitados());
            }
        }
    }

    // Método para agregar un empleado a la lista de empleados.
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);                     // Agrega el empleado recibido como parámetro a la lista.
    }

    // Método para agregar un departamento a la lista de departamentos.
    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);             // Agrega el departamento recibido como parámetro a la lista.
    }
}
