// Definición de la clase Autor, que representa un autor con su nombre y nacionalidad.
public class Autor {
    // Atributo privado que almacena el nombre del autor.
    private String nombre;

    // Atributo privado que almacena la nacionalidad del autor.
    private String nacionalidad;

    /**
     * Constructor de la clase Autor que inicializa los atributos nombre y nacionalidad.
     *
     * @param nombre       El nombre del autor.
     * @param nacionalidad La nacionalidad del autor.
     */
    public Autor(String nombre, String nacionalidad) {
        // Asigna el valor del parámetro nombre al atributo nombre.
        this.nombre = nombre;
        // Asigna el valor del parámetro nacionalidad al atributo nacionalidad.
        this.nacionalidad = nacionalidad;
    }

    /**
     * Método getter para obtener el valor del atributo nombre.
     *
     * @return El nombre del autor.
     */
    public String getNombre() {
        return nombre; // Devuelve el valor del atributo nombre.
    }

    /**
     * Método setter para actualizar el valor del atributo nombre.
     *
     * @param nombre El nuevo nombre del autor.
     */
    public void setNombre(String nombre) {
        // Asigna el valor proporcionado al atributo nombre.
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener el valor del atributo nacionalidad.
     *
     * @return La nacionalidad del autor.
     */
    public String getNacionalidad() {
        return nacionalidad; // Devuelve el valor del atributo nacionalidad.
    }

    /**
     * Método setter para actualizar el valor del atributo nacionalidad.
     *
     * @param nacionalidad La nueva nacionalidad del autor.
     */
    public void setNacionalidad(String nacionalidad) {
        // Asigna el valor proporcionado al atributo nacionalidad.
        this.nacionalidad = nacionalidad;
    }

    /**
     * Método sobrescrito de la clase Object para generar una representación en
     * forma de cadena del objeto Autor.
     *
     * @return Una cadena que describe el objeto Autor, incluyendo su nombre y nacionalidad.
     */
    @Override
    public String toString() {
        // Devuelve una cadena que representa al objeto con sus atributos nombre y nacionalidad.
        return "Autor [nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
    }
}
