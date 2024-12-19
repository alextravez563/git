// Importación de la clase Date, que se utiliza para manejar fechas.
import java.util.Date;

// Definición de la clase Prestamo, que representa un préstamo de un libro realizado por un usuario.
public class Prestamo {
    // Atributo privado que almacena el libro prestado, representado por un objeto de la clase Libro.
    private Libro libro;

    // Atributo privado que almacena el nombre o identificador del usuario que realizó el préstamo.
    private String usuario;

    // Atributo privado que almacena la fecha en que se realizó el préstamo.
    private Date fechaPrestamo;

    // Atributo privado que almacena la fecha en que se devolvió el libro.
    // Puede ser nulo si el libro aún no ha sido devuelto.
    private Date fechaDevolucion;

    /**
     * Constructor de la clase Prestamo que inicializa los atributos libro, usuario y fechaPrestamo.
     *
     * @param libro         El libro que se presta (objeto de la clase Libro).
     * @param usuario       El nombre o identificador del usuario que realiza el préstamo.
     * @param fechaPrestamo La fecha en que se realizó el préstamo.
     */
    public Prestamo(Libro libro, String usuario, Date fechaPrestamo) {
        // Asigna el objeto Libro proporcionado al atributo libro.
        this.libro = libro;
        // Asigna el nombre o identificador del usuario al atributo usuario.
        this.usuario = usuario;
        // Asigna la fecha del préstamo al atributo fechaPrestamo.
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Método getter para obtener el objeto Libro asociado al préstamo.
     *
     * @return El objeto Libro que representa el libro prestado.
     */
    public Libro getLibro() {
        return libro; // Devuelve el libro prestado.
    }

    /**
     * Método setter para actualizar el libro asociado al préstamo.
     *
     * @param libro El nuevo objeto Libro que se asocia al préstamo.
     */
    public void setLibro(Libro libro) {
        this.libro = libro; // Asigna el nuevo libro al atributo libro.
    }

    /**
     * Método getter para obtener el nombre o identificador del usuario.
     *
     * @return El nombre o identificador del usuario que realizó el préstamo.
     */
    public String getUsuario() {
        return usuario; // Devuelve el nombre o identificador del usuario.
    }

    /**
     * Método setter para actualizar el nombre o identificador del usuario.
     *
     * @param usuario El nuevo nombre o identificador del usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario; // Asigna el nuevo usuario al atributo usuario.
    }

    /**
     * Método getter para obtener la fecha en que se realizó el préstamo.
     *
     * @return La fecha del préstamo.
     */
    public Date getFechaPrestamo() {
        return fechaPrestamo; // Devuelve la fecha del préstamo.
    }

    /**
     * Método setter para actualizar la fecha en que se realizó el préstamo.
     *
     * @param fechaPrestamo La nueva fecha del préstamo.
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo; // Asigna la nueva fecha al atributo fechaPrestamo.
    }

    /**
     * Método getter para obtener la fecha en que se devolvió el libro.
     *
     * @return La fecha de devolución, o null si el libro no ha sido devuelto.
     */
    public Date getFechaDevolucion() {
        return fechaDevolucion; // Devuelve la fecha de devolución del libro.
    }

    /**
     * Método setter para actualizar la fecha de devolución del libro.
     *
     * @param fechaDevolucion La nueva fecha de devolución del libro.
     */
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion; // Asigna la nueva fecha al atributo fechaDevolucion.
    }

    /**
     * Método sobrescrito de la clase Object para generar una representación en
     * forma de cadena del objeto Prestamo.
     *
     * @return Una cadena que describe el objeto Prestamo, incluyendo los detalles
     *         del libro, el usuario, la fecha del préstamo y la fecha de devolución.
     */
    @Override
    public String toString() {
        // Devuelve una cadena con los detalles del préstamo, incluyendo:
        // - El objeto Libro (se usa su método toString para incluir sus detalles).
        // - El nombre del usuario.
        // - La fecha del préstamo.
        // - La fecha de devolución (puede ser null si el libro no ha sido devuelto).
        return "Prestamo [libro=" + libro + ", usuario=" + usuario
                + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + "]";
    }
}
