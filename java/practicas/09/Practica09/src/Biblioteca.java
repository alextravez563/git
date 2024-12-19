// Importación de clases necesarias.
import java.util.ArrayList; // Clase para manejar listas dinámicas.
import java.util.List; // Interfaz para listas.
import java.util.Date; // Clase para manejar fechas.

// Definición de la clase Biblioteca, que representa una biblioteca con un sistema de gestión de libros, autores y préstamos.
public class Biblioteca {
    // Lista privada que almacena todos los libros disponibles en la biblioteca.
    private List<Libro> libros;

    // Lista privada que almacena todos los autores registrados en la biblioteca.
    private List<Autor> autores;

    // Lista privada que almacena los préstamos realizados en la biblioteca.
    private List<Prestamo> prestamos;

    /**
     * Constructor de la clase Biblioteca.
     * Inicializa las listas de libros, autores y préstamos como nuevas instancias de ArrayList.
     */
    public Biblioteca() {
        libros = new ArrayList<>(); // Lista vacía de libros.
        autores = new ArrayList<>(); // Lista vacía de autores.
        prestamos = new ArrayList<>(); // Lista vacía de préstamos.
    }

    /**
     * Método para agregar un libro a la biblioteca.
     *
     * @param libro El objeto Libro que se desea agregar a la lista de libros.
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro); // Agrega el libro a la lista de libros.
    }

    /**
     * Método para eliminar un libro de la biblioteca utilizando su ISBN.
     *
     * @param isbn El código ISBN del libro que se desea eliminar.
     */
    public void eliminarLibro(String isbn) {
        // Elimina el libro cuya ISBN coincide con el valor proporcionado.
        libros.removeIf(libro -> libro.getIsbn().equals(isbn));
    }

    /**
     * Método para buscar un libro en la biblioteca por su ISBN.
     *
     * @param isbn El código ISBN del libro que se desea buscar.
     * @return El objeto Libro si se encuentra, o null si no existe.
     */
    public Libro buscarLibro(String isbn) {
        // Busca y devuelve el primer libro con la ISBN proporcionada, o null si no existe.
        return libros.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    /**
     * Método para agregar un autor a la biblioteca.
     *
     * @param autor El objeto Autor que se desea agregar a la lista de autores.
     */
    public void agregarAutor(Autor autor) {
        autores.add(autor); // Agrega el autor a la lista de autores.
    }

    /**
     * Método para buscar un autor en la biblioteca por su nombre.
     *
     * @param nombre El nombre del autor que se desea buscar.
     * @return El objeto Autor si se encuentra, o null si no existe.
     */
    public Autor buscarAutor(String nombre) {
        // Busca y devuelve el primer autor con el nombre proporcionado, o null si no existe.
        return autores.stream().filter(autor -> autor.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    /**
     * Método para registrar un préstamo de un libro a un usuario.
     *
     * @param libro   El objeto Libro que se presta.
     * @param usuario El nombre o identificador del usuario que toma el préstamo.
     */
    public void realizarPrestamo(Libro libro, String usuario) {
        // Crea un nuevo préstamo con la fecha actual y lo agrega a la lista de préstamos.
        Prestamo prestamo = new Prestamo(libro, usuario, new Date());
        prestamos.add(prestamo);
    }

    /**
     * Método para registrar la devolución de un libro.
     *
     * @param libro El objeto Libro que se devuelve.
     */
    public void devolverPrestamo(Libro libro) {
        // Busca el préstamo correspondiente al libro proporcionado.
        Prestamo prestamo = prestamos.stream()
                .filter(p -> p.getLibro().equals(libro)) // Filtra por el libro igual al proporcionado.
                .findFirst().orElse(null); // Devuelve el primer préstamo encontrado o null si no existe.

        // Si el préstamo existe, actualiza la fecha de devolución con la fecha actual.
        if (prestamo != null) {
            prestamo.setFechaDevolucion(new Date());
        }
    }

    /**
     * Método para obtener la lista de todos los préstamos realizados.
     *
     * @return Una lista de objetos Prestamo que representa todos los préstamos realizados.
     */
    public List<Prestamo> getPrestamos() {
        return prestamos; // Devuelve la lista de préstamos.
    }
}
