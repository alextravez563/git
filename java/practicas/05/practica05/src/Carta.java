public class Carta {
    // Atributos
    private String familia;
    private String valor;

    // Constructor con parámetros
    public Carta(String familia, String valor) {
        this.familia = familia;
        this.valor = valor;
    }

    // Getters
    public String getFamilia() {
        return familia;
    }

    public String getValor() {
        return valor;
    }

    // Sobrecarga del método toString()
    @Override
    public String toString() {
        return valor + " de " + familia;
    }
}
