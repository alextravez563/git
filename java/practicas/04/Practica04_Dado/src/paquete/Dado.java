package paquete;
public class Dado {

    // Variables de instancia
    private int numLados;

    // Variable de clase
    private static int numDados = 0;

    // Constructor
    public Dado(int numLados) {
        this.numLados = numLados;
        numDados++;
    }

    // Método para lanzar el dado
    public int lanzar() {
        return (int) (Math.random() * numLados) + 1;
    }

    // Getter para el número de lados
    public int getNumLados() {
        return numLados;
    }

    // Getter para el número de dados creados
    public static int getNumDados() {
        return numDados;
    }
}
