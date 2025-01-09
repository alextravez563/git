// Clase SistemaAutenticacion: Gestiona la autenticación de perros mediante un sistema de identificación por ladridos.
// Los perros registrados en el sistema pueden ser reconocidos automáticamente al interactuar con otros dispositivos.
import java.util.HashMap; // Importa la clase HashMap para gestionar una colección de datos clave-valor.
import java.util.Map;     // Importa la interfaz Map utilizada para definir el tipo del HashMap.

class SistemaAutenticacion {
    // Mapa que almacena los perros registrados en el sistema.
    // La clave es un identificador único asociado al ladrido del perro (String),
    // y el valor es el objeto `Perro` correspondiente.
    private Map<String, Perro> perrosRegistrados;

    // Constructor de la clase SistemaAutenticacion:
    // - Inicializa la colección `perrosRegistrados` como un HashMap vacío.
    public SistemaAutenticacion() {
        this.perrosRegistrados = new HashMap<>(); // Se inicializa el HashMap.
    }

    // Método `registrarPerro`:
    // - Recibe como parámetro un objeto `Perro` que será registrado en el sistema.
    // - Almacena el perro en el mapa utilizando su `idLadrido` como clave.
    // - Registra el evento de registro en el sistema de logs.
    public void registrarPerro(Perro perro) {
        perrosRegistrados.put(perro.getIdLadrido(), perro); // Añade el perro al mapa.
        Log.registrarEvento("Perro registrado: " + perro.getNombre()); // Registra el evento de registro en el log.
    }

    // Método `autenticar`:
    // - Recibe como parámetro un objeto `Perro` que intenta autenticarse.
    // - Verifica si el `idLadrido` del perro está presente en el mapa de perros registrados.
    // - Retorna `true` si el perro está registrado y `false` en caso contrario.
    public boolean autenticar(Perro perro) {
        return perrosRegistrados.containsKey(perro.getIdLadrido()); // Comprueba si el id está registrado.
    }
}
