// Clase Carro: Representa un vehículo fabricado en una fábrica específica
/*Practica 03
        Alex Travez - MaTeo Oviedo
        Fecha de realización: 31/10/2024
        Fecha de entrega: 31/10/2024
        */
    /*
     * CONCLUSIONES:
     * Se puede evidenciar que con ayuda de los constructores se puede crear de manera muy sencilla
     * nuevos elementos para una clase. Según las características del constructor, se pueden establecer
     * valores específicos para inicializar cada nuevo elemento de la clase principal.
     *
     * RECOMENDACIONES:
     * - Es necesario conocer todos los métodos que se necesitan para cumplir con las especificaciones
     * y acciones que requiere el programa en desarrollo.
     * - El correcto uso de los constructores es fundamental, ya que facilita el desarrollo de un proyecto
     * de manera organizada y eficiente.
     *
     * REFERENCIAS:
     * [1] Programación ATS. 65. Programación en Java || POO || Método Constructor. (4 de julio de 2017).
     * Accedido el 27 de octubre de 2024. [Video en línea]. Disponible: https://www.youtube.com/watch?v=5EGS6lnghYE
     */
    public class Carro {
    // Variables de clase
    private static int numCarros = 0;
    public static final String NOMBRE_FABRICA = "DM";

    // Variables de instancia para almacenar detalles del carro
    private String fabricante;
    private String modelo;
    private int año;

    // Constructor sin parámetros
    public Carro() {
        this("Desconocido", "Desconocido", 0);
    }

    // Constructor con parámetros
    public Carro(String fabricante, String modelo, int año) {
        if (!setFabricante(fabricante)) {
            this.fabricante = "Desconocido";
        }
        if (!setModelo(modelo)) {
            this.modelo = "Desconocido";
        }
        if (!setAño(año)) {
            this.año = 0;
        }
        numCarros++;
    }

    // Constructor por copia
    public Carro(Carro otro) {
        this(otro.fabricante, otro.modelo, otro.año);
    }

    // Getters y Setters con validación
    public String getFabricante() {
        return fabricante;
    }

    public boolean setFabricante(String fabricante) {
        if (fabricante == null || fabricante.isEmpty()) {
            System.out.println("ERROR: El fabricante no puede estar vacío.");
            return false;
        }
        this.fabricante = fabricante;
        return true;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean setModelo(String modelo) {
        if (modelo == null || modelo.isEmpty()) {
            System.out.println("ERROR: El modelo no puede estar vacío.");
            return false;
        }
        this.modelo = modelo;
        return true;
    }

    public int getAño() {
        return año;
    }

    public boolean setAño(int año) {
        if (año < 1886) {
            System.out.println("ERROR: El año debe ser mayor a 1886.");
            return false;
        }
        this.año = año;
        return true;
    }

    // Métodos de instancia
    public String arrancar() {
        return "El auto ha arrancado";
    }

    public String desplegarInformación() {
        return "Auto fabricado por: " + fabricante + ", modelo: " + modelo + ", fabricado en el año: " + año;
    }

    // Métodos de clase
    public static int presentarNumAutos() {
        return numCarros;
    }

    public static void reiniciarNumAutos() {
        numCarros = 0;
    }
}
