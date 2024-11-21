import java.util.HashMap;
import java.util.Map;

// Clase que representa los puntos acumulados en un juego de cartas.
public class Puntos {
    private int puntosValor; // Puntos obtenidos por coincidencias de valores.
    private int puntosFamilia; // Puntos obtenidos por coincidencias de familias.
    private final Map<String, Integer> valoresConPuntos; // Detalla los puntos asociados a cada valor de carta.
    private final Map<String, Integer> familiasConPuntos; // Detalla los puntos asociados a cada familia de carta.

    // Constructor que inicializa todos los puntos y mapas en cero o vacíos.
    public Puntos() {
        this.puntosValor = 0; // Inicializa los puntos por valores en 0.
        this.puntosFamilia = 0; // Inicializa los puntos por familias en 0.
        this.valoresConPuntos = new HashMap<>(); // Crea un mapa vacío para los valores con puntos.
        this.familiasConPuntos = new HashMap<>(); // Crea un mapa vacío para las familias con puntos.
    }

    // Método para agregar puntos basados en coincidencias de valores de cartas.
    public void agregarPuntosValor(int puntos, String valor) {
        this.puntosValor += puntos; // Suma los puntos al total de puntos por valores.
        this.valoresConPuntos.put(valor, puntos); // Asocia los puntos al valor correspondiente en el mapa.
    }

    // Método para agregar puntos basados en coincidencias de familias de cartas.
    public void agregarPuntosFamilia(int puntos, String familia) {
        this.puntosFamilia += puntos; // Suma los puntos al total de puntos por familias.
        this.familiasConPuntos.put(familia, puntos); // Asocia los puntos a la familia correspondiente en el mapa.
    }

    // Devuelve el total de puntos combinando puntos por valores y puntos por familias.
    public int getPuntosTotales() {
        return puntosValor + puntosFamilia; // Suma los puntos de ambas categorías.
    }

    // Sobrescribe el método `toString` para devolver una representación detallada de los puntos.
    @Override
    public String toString() {
        return "Puntos por valor: " + puntosValor + " (" + valoresConPuntos + "), " +
               "Puntos por familia: " + puntosFamilia + " (" + familiasConPuntos + "), " +
               "Puntos totales: " + getPuntosTotales();
    }
}

