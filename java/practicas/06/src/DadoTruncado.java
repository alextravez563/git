public class DadoTruncado extends Dado {

    private int sesgo;

    public DadoTruncado(int caras, int sesgo) {
        super(caras);
        this.sesgo = sesgo;
    }

    @Override
    public int lanzar() {
        return (int) (Math.random() * (caras - sesgo)) + sesgo;
    }

    @Override
    public String toString() {
        return "Dado Truncado de " + caras + " caras con sesgo de " + sesgo;
    }
}
