// Clase Puerta: Representa el estado y comportamiento de una puerta que puede abrirse y cerrarse
// automáticamente después de un tiempo determinado utilizando un temporizador.
class Puerta {
    // Atributo privado para determinar si la puerta está abierta o cerrada.
    private boolean abierta;
    // Atributo privado que almacena el tiempo (en milisegundos) que la puerta permanecerá abierta antes de cerrarse automáticamente.
    private long tiempoCierre;
    // Atributo privado que hace referencia a un objeto de la clase Temporizador que se encargará de gestionar el tiempo.
    private Temporizador temporizador;

    // Constructor de la clase Puerta:
    // - Inicializa la puerta como cerrada (por defecto).
    // - Establece el tiempo de cierre automático especificado como parámetro.
    // - Crea una instancia de Temporizador asociada a esta puerta.
    public Puerta(long tiempoCierre) {
        this.abierta = false; // La puerta comienza cerrada.
        this.tiempoCierre = tiempoCierre; // Se establece el tiempo que debe permanecer abierta antes de cerrarse.
        this.temporizador = new Temporizador(this, tiempoCierre); // Se inicializa el temporizador.
    }

    // Método para abrir la puerta.
    // Si la puerta está cerrada, se abre, se registra el evento, y se inicia el temporizador para cerrarla automáticamente.
    public void abrir() {
        if (!abierta) { // Solo permite abrir si la puerta está cerrada.
            abierta = true; // Cambia el estado de la puerta a "abierta".
            System.out.println("La puerta está abierta."); // Mensaje informativo en consola.
            Log.registrarEvento("La puerta está abierta."); // Se registra el evento en el log.
            temporizador.iniciar(); // Se inicia el temporizador para el cierre automático.
        }
    }

    // Método para cerrar la puerta.
    // Si la puerta está abierta, se cierra y se registra el evento en el log.
    public void cerrar() {
        if (abierta) { // Solo permite cerrar si la puerta está abierta.
            abierta = false; // Cambia el estado de la puerta a "cerrada".
            System.out.println("La puerta está cerrada."); // Mensaje informativo en consola.
            Log.registrarEvento("Puerta cerrada automáticamente."); // Se registra el evento en el log.
        }
    }

    // Método para consultar el estado actual de la puerta.
    // Devuelve `true` si la puerta está abierta y `false` si está cerrada.
    public boolean isAbierta() {
        return abierta;
    }
}
