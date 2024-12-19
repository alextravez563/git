// Definición de la clase Libro, que representa un libro con su título, ISBN y un autor asociado.
public class Libro {
    // Atributo privado que almacena el título del libro.
    private String titulo;

    // Atributo privado que almacena el código ISBN del libro.
    private String isbn;

    // Atributo privado que almacena un objeto de tipo Autor, que representa al autor del libro.
    private Autor autor;

    /**
     * Constructor de la clase Libro que inicializa los atributos titulo, isbn y autor.
     *
     * @param titulo El título del libro.
     * @param isbn   El código ISBN del libro.
     * @param autor  Un objeto de tipo Autor que representa al autor del libro.
     */
    public Libro(String titulo, String isbn, Autor autor) {
        // Asigna el valor del parámetro titulo al atributo titulo.
        this.titulo = titulo;
        // Asigna el valor del parámetro isbn al atributo isbn.
        this.isbn = isbn;
        // Asigna el objeto Autor proporcionado al atributo autor.
        this.autor = autor;
    }

    /**
     * Método getter para obtener el valor del atributo titulo.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo; // Devuelve el valor del atributo titulo.
    }

    /**
     * Método setter para actualizar el valor del atributo titulo.
     *
     * @param titulo El nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        // Asigna el valor proporcionado al atributo titulo.
        this.titulo = titulo;
    }

    /**
     * Método getter para obtener el valor del atributo isbn.
     *
     * @return El código ISBN del libro.
     */
    public String getIsbn() {
        return isbn; // Devuelve el valor del atributo isbn.
    }

    /**
     * Método setter para actualizar el valor del atributo isbn.
     *
     * @param isbn El nuevo código ISBN del libro.
     */
    public void setIsbn(String isbn) {
        // Asigna el valor proporcionado al atributo isbn.
        this.isbn = isbn;
    }

    /**
     * Método getter para obtener el valor del atributo autor.
     *
     * @return Un objeto de tipo Autor que representa al autor del libro.
     */
    public Autor getAutor() {
        return autor; // Devuelve el objeto Autor asociado al libro.
    }

    /**
     * Método setter para actualizar el valor del atributo autor.
     *
     * @param autor El nuevo objeto Autor que representa al autor del libro.
     */
    public void setAutor(Autor autor) {
        // Asigna el objeto Autor proporcionado al atributo autor.
        this.autor = autor;
    }

    /**
     * Método sobrescrito de la clase Object para generar una representación en
     * forma de cadena del objeto Libro.
     *
     * @return Una cadena que describe el objeto Libro, incluyendo su título,
     *         código ISBN y el nombre del autor.
     */
    @Override
    public String toString() {
        // Devuelve una cadena que representa al objeto con sus atributos titulo,
        // isbn y el nombre del autor (usando el método getNombre() del objeto Autor).
        return "Libro [titulo=" + titulo + ", isbn=" + isbn + ", autor=" + autor.getNombre() + "]";
    }
}
