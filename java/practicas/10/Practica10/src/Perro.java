// Clase Perro: Representa a un perro en el sistema, con información básica como su nombre, identificador de ladrido y ubicación (dentro o fuera de la casa).
class Perro {
    // Atributo privado que almacena el nombre del perro.
    private String nombre;
    // Atributo privado que representa el identificador único asociado al ladrido del perro.
    private String idLadrido;
    // Atributo privado que indica si el perro está adentro de la casa (`true`) o afuera (`false`).
    private boolean adentro;

    // Constructor de la clase Perro:
    // - Recibe como parámetros el nombre del perro y su identificador de ladrido.
    // - Inicializa los atributos correspondientes y establece que el perro comienza dentro de la casa.
    public Perro(String nombre, String idLadrido) {
        this.nombre = nombre;        // Asigna el nombre del perro.
        this.idLadrido = idLadrido;  // Asigna el identificador de ladrido.
        this.adentro = true;         // Por defecto, el perro empieza adentro de la casa.
    }

    // Método getter para obtener el nombre del perro.
    public String getNombre() {
        return nombre;
    }

    // Método getter para obtener el identificador único del ladrido del perro.
    public String getIdLadrido() {
        return idLadrido;
    }

    // Método getter para verificar si el perro está adentro de la casa.
    public boolean isAdentro() {
        return adentro;
    }

    // Método setter para actualizar el estado del perro (dentro o fuera de la casa).
    public void setAdentro(boolean adentro) {
        this.adentro = adentro;
    }

    // Método `ladrar`:
    // - Simula el ladrido del perro mostrando un mensaje en la consola.
    public void ladrar() {
        System.out.println(nombre + " está ladrando.");
    }
}
