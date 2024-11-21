import java.util.HashMap;
import java.util.Map;

public class Puntos {
    private int puntosValor;
    private int puntosFamilia;
    private final Map<String, Integer> valoresConPuntos;
    private final Map<String, Integer> familiasConPuntos;

    public Puntos() {
        this.puntosValor = 0;
        this.puntosFamilia = 0;
        this.valoresConPuntos = new HashMap<>();
        this.familiasConPuntos = new HashMap<>();
    }

    public void agregarPuntosValor(int puntos, String valor) {
        this.puntosValor += puntos;
        this.valoresConPuntos.put(valor, puntos);
    }

    public void agregarPuntosFamilia(int puntos, String familia) {
        this.puntosFamilia += puntos;
        this.familiasConPuntos.put(familia, puntos);
    }

    public int getPuntosTotales() {
        return puntosValor + puntosFamilia;
    }

    @Override
    public String toString() {
        return "Puntos por valor: " + puntosValor + " (" + valoresConPuntos + "), Puntos por familia: " + puntosFamilia + " (" + familiasConPuntos + "), Puntos totales: " + getPuntosTotales();
    }
}
