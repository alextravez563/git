public class Contador {
    // Variable de instancia que representa el valor del contador
    private int cuenta;

    // Constructor por defecto que inicializa la cuenta en 0
    public Contador() {

        this.cuenta = 0;
    }

    // Constructor que acepta como argumento el valor inicial de la cuenta
    public Contador(int cuentaInicial) {

        this.cuenta = cuentaInicial;
    }

    // Método para incrementar el contador en 1
    public void incrementar() {
        int i = this.cuenta++;

    }
    // Método para obtener el valor del contador
    public int obtenerValor() {

        return this.cuenta;
    }
}
