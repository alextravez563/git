// Clase ControlRemoto: Representa un control remoto que permite abrir una puerta automática,
// siempre y cuando un sistema de autenticación valide correctamente al usuario (en este caso, un perro).
class ControlRemoto {
    // Atributo privado que representa la puerta asociada al control remoto.
    private Puerta puerta;
    // Atributo privado que representa el sistema de autenticación para validar el acceso.
    private SistemaAutenticacion sistemaAutenticacion;

    // Constructor de la clase ControlRemoto:
    // - Recibe como parámetros una instancia de `Puerta` y una instancia de `SistemaAutenticacion`.
    // - Asocia el control remoto a la puerta y al sistema de autenticación.
    public ControlRemoto(Puerta puerta, SistemaAutenticacion sistemaAutenticacion) {
        this.puerta = puerta; // Inicializa la puerta asociada al control remoto.
        this.sistemaAutenticacion = sistemaAutenticacion; // Inicializa el sistema de autenticación.
    }

    // Método `presionarBoton`: Simula la acción de presionar un botón en el control remoto.
    // - Recibe como parámetro un objeto `Perro` que intenta abrir la puerta.
    public void presionarBoton(Perro perro) {
        // Verifica si el perro es autenticado por el sistema de autenticación.
        if (sistemaAutenticacion.autenticar(perro)) {
            // Si el perro es autenticado, abre la puerta.
            puerta.abrir();
            // Cambia el estado del perro (si estaba afuera, pasa a estar adentro, y viceversa).
            perro.setAdentro(!perro.isAdentro());
            // Registra el evento en el sistema de logs indicando que la puerta fue abierta.
            Log.registrarEvento("Puerta abierta con control remoto.");
        } else {
            // Si el perro no es autenticado, muestra un mensaje indicando que el ladrido no fue válido.
            System.out.println("Ladrido no autenticado.");
        }
    }
}
