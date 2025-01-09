// Clase SensorLadridos: Representa un sensor capaz de detectar y reconocer el ladrido de un perro.
// Si el ladrido es autenticado por el sistema, la puerta se abre automáticamente.
class SensorLadridos {
    // Atributo privado que representa la puerta asociada al sensor.
    private Puerta puerta;
    // Atributo privado que representa el sistema de autenticación que valida el ladrido del perro.
    private SistemaAutenticacion sistemaAutenticacion;

    // Constructor de la clase SensorLadridos:
    // - Recibe como parámetros una instancia de `Puerta` y una instancia de `SistemaAutenticacion`.
    // - Asocia el sensor a la puerta y al sistema de autenticación.
    public SensorLadridos(Puerta puerta, SistemaAutenticacion sistemaAutenticacion) {
        this.puerta = puerta; // Inicializa la puerta asociada al sensor.
        this.sistemaAutenticacion = sistemaAutenticacion; // Inicializa el sistema de autenticación.
    }

    // Método `detectarLadrido`: Simula la detección de un ladrido por parte del sensor.
    // - Recibe como parámetro un objeto `Perro`, representando al perro que emitió el ladrido.
    public void detectarLadrido(Perro perro) {
        // Verifica si el ladrido del perro es autenticado por el sistema de autenticación.
        if (sistemaAutenticacion.autenticar(perro)) {
            // Si el ladrido es reconocido, muestra un mensaje informativo con el nombre del perro.
            System.out.println("Se reconoce el ladrido de " + perro.getNombre());
            // Abre la puerta automáticamente.
            puerta.abrir();
            // Cambia el estado del perro, indicando que está afuera (porque la puerta se abrió para salir).
            perro.setAdentro(false);
            // Registra el evento en el sistema de logs, indicando el nombre del perro cuyo ladrido fue reconocido.
            Log.registrarEvento("Puerta abierta con ladrido de " + perro.getNombre());
        } else {
            // Si el ladrido no es reconocido, muestra un mensaje indicando que no se reconoce al perro.
            System.out.println("No se reconoce el ladrido de " + perro.getNombre());
        }
    }
}
