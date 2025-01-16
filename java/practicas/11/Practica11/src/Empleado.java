// Clase base que representa a un empleado genérico en el sistema
public class Empleado {
    // Atributos privados para encapsular los datos de cada empleado
    private String nombre; // Nombre del empleado
    private int id; // Identificador único del empleado
    private int diasVacaciones; // Días de vacaciones disponibles
    private Departamento departamento; // Departamento al que pertenece el empleado

    // Constructor: Inicializa los datos del empleado al crearlo
    public Empleado(String nombre, int id, Departamento departamento) {
        this.nombre = nombre; // Asignar el nombre proporcionado
        this.id = id; // Asignar el ID proporcionado
        this.departamento = departamento; // Asignar el departamento proporcionado
        this.diasVacaciones = 21; // Inicializar con 21 días de vacaciones según la política de la empresa
    }

    // Métodos Getters y Setters: Permiten acceder y modificar los atributos de manera controlada
    public String getNombre() {
        return nombre; // Devuelve el nombre del empleado
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Actualiza el nombre del empleado
    }

    public int getId() {
        return id; // Devuelve el ID del empleado
    }

    public void setId(int id) {
        this.id = id; // Actualiza el ID del empleado
    }

    public int getDiasVacaciones() {
        return diasVacaciones; // Devuelve los días de vacaciones disponibles
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones; // Actualiza los días de vacaciones disponibles
    }

    public Departamento getDepartamento() {
        return departamento; // Devuelve el departamento al que pertenece el empleado
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento; // Asigna un departamento al empleado
    }

    // Método para solicitar días de vacaciones
    public boolean solicitarVacaciones(int dias) {
        // Verifica si el empleado tiene suficientes días de vacaciones disponibles
        if (dias <= diasVacaciones) {
            diasVacaciones -= dias; // Resta los días solicitados de las vacaciones disponibles
            return true; // La solicitud fue exitosa
        } else {
            return false; // No hay suficientes días disponibles para aprobar la solicitud
        }
    }

    // Método para consultar el saldo de días de vacaciones
    public int consultarSaldoVacaciones() {
        return diasVacaciones; // Devuelve el número actual de días de vacaciones disponibles
    }
}
