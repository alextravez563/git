// Clase Carta: Representa una carta de juego con una cara, familia y valor especial si es As
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
    public class Carta {
    // Atributos finales para cara y familia, ya que no cambian después de ser asignados
    private final String cara;
    private final String familia;
    // Indica si el As es alto (11) o bajo (1); por defecto, un As será alto
    private boolean esAsAlto;

    // Constructor: Inicializa cara y familia; establece As como alto si es su cara
    public Carta(String cara, String familia) {
        this.cara = cara;
        this.familia = familia;
        this.esAsAlto = cara.equals("As"); // Un As es alto por defecto
    }

    // Getters
    public String getCara() {
        return cara;
    }

    public String getFamilia() {
        return familia;
    }

    // Método para obtener el valor de la carta
    public int valorcarta() {
        switch (cara) {
            case "As":
                return esAsAlto ? 11 : 1;
            case "J":
            case "Q":
            case "K":
                return 10;
            default:
                try {
                    return Integer.parseInt(cara);
                } catch (NumberFormatException e) {
                    System.err.println("ERROR: Valor de carta no reconocido: " + cara);
                    return 0; // Valor por defecto en caso de error
                }
        }
    }

    // Método toString para mostrar la carta en formato "Cara de Familia"
    @Override
    public String toString() {
        return cara + " de " + familia;
    }

    // Setter para cambiar si el As es alto o bajo
    public void setAsAlto(boolean esAlto) {
        this.esAsAlto = esAlto;
    }

    }

