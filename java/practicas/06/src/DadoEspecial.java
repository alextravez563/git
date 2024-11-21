public class DadoEspecial extends Dado {
    public DadoEspecial() {
        super(6);
    }

    @Override
    public int lanzar() {
        int resultado = super.lanzar();
        if(resultado == 6){
            return resultado + super.lanzar();
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Dado Especial de 6 caras";
    }
}
