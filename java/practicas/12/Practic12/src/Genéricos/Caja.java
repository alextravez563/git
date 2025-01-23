// Definición de la clase genérica Caja.
// <T> indica que esta clase usará un tipo genérico que será definido cuando se cree una instancia de la clase.
public class Caja<T> {

    // Campo privado que almacenará un objeto del tipo genérico T.
    private T contenido;

    // Método setter para asignar un valor al campo contenido.
    // El tipo del parámetro será definido en tiempo de compilación dependiendo del tipo genérico utilizado.
    public void setContenido(T contenido) {
        this.contenido = contenido; // Asigna el valor pasado como argumento al campo contenido.
    }

    // Método getter para obtener el valor almacenado en el campo contenido.
    // Retorna un objeto del tipo genérico T.
    public T getContenido() {
        return contenido; // Devuelve el valor almacenado en contenido.
    }

    // Método principal donde se prueba la funcionalidad de la clase genérica.
    public static void main(String[] args) {

        // Creación de una instancia de Caja donde el tipo genérico T se define como String.
        Caja<String> cajaDeTexto = new Caja<>();

        // Usamos el método setContenido para asignar una cadena de texto ("Hola, Mundo!") al contenido de la caja.
        cajaDeTexto.setContenido("Hola, Mundo!");

        // Obtenemos y mostramos el contenido de la caja usando getContenido.
        System.out.println("Contenido de la caja: " + cajaDeTexto.getContenido());

        // Creación de otra instancia de Caja, esta vez definiendo el tipo genérico T como Integer.
        Caja<Integer> cajaDeEntero = new Caja<>();

        // Usamos el método setContenido para asignar un número entero (123) al contenido de la caja.
        cajaDeEntero.setContenido(123);

        // Obtenemos y mostramos el contenido de la caja usando getContenido.
        System.out.println("Contenido de la caja: " + cajaDeEntero.getContenido());
    }
}
