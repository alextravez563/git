public class DatosInvalidosException extends Exception {
    // Constructor que inicializa la excepción con un mensaje personalizado.
    public DatosInvalidosException(String mensaje) {
        super(mensaje); // Llama al constructor de la clase base (Exception) con el mensaje.
    }
    /*
Explicación:
Clase personalizada:DatosInvalidosException extiende de Exception para crear un tipo específico de error que podemos usar en nuestro juego.
Constructor: Permite inicializar la excepción con un mensaje que describe el error.
Ayuda a diferenciar errores en el juego (como datos inválidos) de otros errores más genéricos del sistema.
     */
}
