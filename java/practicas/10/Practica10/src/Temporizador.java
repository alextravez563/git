// Clase Temporizador: Gestiona un temporizador que controla el tiempo que una puerta permanece abierta.
// Una vez que se alcanza el tiempo definido, el temporizador ordena cerrar la puerta.
import java.util.Timer;       // Importa la clase Timer para programar tareas con temporizador.
import java.util.TimerTask;   // Importa la clase TimerTask para definir tareas que se ejecutan con el temporizador.

class Temporizador {
    // Atributo privado que representa la puerta asociada al temporizador.
    private Puerta puerta;
    // Atributo privado que define el tiempo (en milisegundos) antes de que la puerta se cierre automáticamente.
    private long tiempoCierre;
    // Atributo privado que gestiona las tareas programadas.
    private Timer timer;

    // Constructor de la clase Temporizador:
    // - Recibe como parámetros una instancia de `Puerta` y el tiempo de cierre automático (en milisegundos).
    // - Inicializa los atributos `puerta`, `tiempoCierre` y crea una nueva instancia de `Timer`.
    public Temporizador(Puerta puerta, long tiempoCierre) {
        this.puerta = puerta;         // Asocia el temporizador a una puerta.
        this.tiempoCierre = tiempoCierre; // Define el tiempo de cierre automático.
        this.timer = new Timer();     // Crea un nuevo temporizador.
    }

    // Método `iniciar`:
    // - Programa una tarea que se ejecutará después de un tiempo específico (`tiempoCierre`).
    // - La tarea está diseñada para cerrar la puerta asociada.
    public void iniciar() {
        // Programación de una tarea usando TimerTask:
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Llama al método `cerrar` de la clase Puerta cuando el tiempo ha transcurrido.
                puerta.cerrar();
            }
        }, tiempoCierre);
    }

    // Método `detener`:
    // - Cancela cualquier tarea pendiente del temporizador.
    // - Detiene el temporizador para evitar más ejecuciones.
    public void detener() {
        timer.cancel();
    }
}
