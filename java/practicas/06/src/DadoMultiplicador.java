public class DadoMultiplicador extends Dado {
    private final double multiplicador;

    public DadoMultiplicador(int caras, double multiplicador) {
        super(caras);
        this.multiplicador = multiplicador < 0 || multiplicador > 1 ? 0.5 : multiplicador;
    }

    @Override
    public int lanzar() {
        return (int) (super.lanzar() * multiplicador) + 1;
    }

    @Override
    public String toString() {
        return "Dado Multiplicador de " + caras + " caras con multiplicador de " + multiplicador;
    }
}
