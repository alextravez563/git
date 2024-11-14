public class main {
    public static void main(String[] args) {
        // Crear los objetos contadorCara y contadorSello
        Contador contadorCara = new Contador();
        Contador contadorSello = new Contador();

        // Simular el lanzamiento de 100 monedas
        for (int i = 0; i < 100; i++) {
            if (Math.random() < 0.5) {
                // Cuente una cara
                contadorCara.incrementar();
            } else {
                // Cuente un sello
                contadorSello.incrementar();
            }
        }

        // Mostrar los resultados
        System.out.println("Se produjeron " + contadorCara.obtenerValor() + " caras.");
        System.out.println("Se produjeron " + contadorSello.obtenerValor() + " sellos.");
    }
}
