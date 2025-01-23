public abstract class carta {
    // Declaración de atributos protegidos para que puedan ser accedidos por las subclases.
    protected String nombre; // Representa el nombre de la carta.
    protected String tipo;   // Representa el tipo de la carta.

    // Constructor de la clase que inicializa los atributos 'nombre' y 'tipo'.
    public carta(String nombre, String tipo) {
        this.nombre = nombre; // Asigna el valor del parámetro 'nombre' al atributo de la clase.
        this.tipo = tipo;     // Asigna el valor del parámetro 'tipo' al atributo de la clase.
    }

    // Método getter que devuelve el valor del atributo 'nombre'.
    public String getNombre() {
        return nombre;
    }

    // Método getter que devuelve el valor del atributo 'tipo'.
    public String getTipo() {
        return tipo;
    }

    // Método sobrescrito de la clase Object que devuelve una representación en texto del objeto.
    @Override
    public String toString() {
        return "Carta{" + "nombre='" + nombre + '\'' + ", tipo='" + tipo + '\'' + '}';
        // Devuelve una cadena que describe el objeto, incluyendo el nombre y tipo de la carta.
    }
}