public class Dado {
    //atributos
    protected int caras;
    //Constructor con parametros
    public Dado(int caras ) {
        this.caras = caras;
    }
    //Metodo lanzar
    public int lanzar(){
        return (int)(Math.random()*caras)+1;
    }
    @Override
    public String toString() {
        return "Dado de " + caras + " caras";
    }
}
