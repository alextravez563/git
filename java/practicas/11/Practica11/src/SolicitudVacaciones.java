public class SolicitudVacaciones {
    private Empleado empleado;           // Representa al empleado que realiza la solicitud.
    private int diasSolicitados;         // Indica la cantidad de días de vacaciones solicitados.
    private String estado;               // Estado de la solicitud (Ej: "Pendiente", "Aprobada", "Rechazada").

    // Constructor
    public SolicitudVacaciones(Empleado empleado, int diasSolicitados) {
        this.empleado = empleado;              // Inicializa el empleado asociado a la solicitud.
        this.diasSolicitados = diasSolicitados; // Establece los días de vacaciones solicitados.
        this.estado = "Pendiente";             // Define el estado inicial como "Pendiente".
    }

    // Getters y Setters
    public Empleado getEmpleado() {            // Devuelve el empleado asociado a la solicitud.
        return empleado;
    }

    public void setEmpleado(Empleado empleado) { // Permite cambiar el empleado asociado a la solicitud.
        this.empleado = empleado;
    }

    public int getDiasSolicitados() {           // Devuelve la cantidad de días solicitados.
        return diasSolicitados;
    }

    public void setDiasSolicitados(int diasSolicitados) { // Permite modificar los días solicitados.
        this.diasSolicitados = diasSolicitados;
    }

    public String getEstado() {                 // Devuelve el estado actual de la solicitud.
        return estado;
    }

    public void setEstado(String estado) {      // Permite actualizar el estado de la solicitud.
        this.estado = estado;
    }

    // Métodos
    public void actualizarEstado(String nuevoEstado) { // Método para actualizar el estado de la solicitud.
        this.estado = nuevoEstado;                    // Cambia el valor de `estado` al nuevo valor proporcionado.
    }
}
