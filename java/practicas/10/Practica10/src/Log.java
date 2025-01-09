// Clase Log: Maneja el registro de eventos del sistema en un archivo de texto.
// Permite almacenar información sobre eventos importantes para fines de trazabilidad y diagnóstico.
import java.io.FileWriter; // Importa la clase FileWriter para escribir en archivos.
import java.io.IOException; // Importa la clase IOException para manejar errores de entrada/salida.

class Log {
    // Método estático `registrarEvento`:
    // - Recibe como parámetro un `String` que representa el evento a registrar.
    // - Escribe el evento en un archivo llamado "log.txt".
    // - Si ocurre un error al escribir en el archivo, lo captura y muestra un mensaje en consola.
    public static void registrarEvento(String evento) {
        // Utiliza un bloque try-with-resources para asegurar que el recurso FileWriter se cierre automáticamente.
        try (FileWriter fw = new FileWriter("log.txt", true)) {
            // Escribe el evento en el archivo, añadiendo un salto de línea al final.
            fw.write(evento + "\n");
        } catch (IOException e) {
            // Si ocurre un error al escribir en el archivo, se captura la excepción y se muestra un mensaje.
            System.out.println("Error al escribir en el log: " + e.getMessage());
        }
    }
}
