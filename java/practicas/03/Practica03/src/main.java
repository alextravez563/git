// Clase Main: Realiza pruebas para las clases Carro y Carta
public class main {
    public static void main(String[] args) {
        // Pruebas con la clase Carro
        System.out.println("Fábrica: " + Carro.NOMBRE_FABRICA);
        System.out.println("En la fábrica se han producido: " + Carro.presentarNumAutos());

        // Crear un carro sin parámetros
        Carro c1 = new Carro();
        System.out.println(c1.desplegarInformación());
        System.out.println("En la fábrica se han producido: " + Carro.presentarNumAutos());

        // Configurar fabricante, modelo y año en el carro c1
        c1.setFabricante("Toyota");
        c1.setModelo("Corolla");
        c1.setAño(1995);

        // Mostrar información del carro después de los cambios
        System.out.println(c1.desplegarInformación());
        System.out.println("En la fábrica se han producido: " + Carro.presentarNumAutos());

        // Pruebas con la clase Carta
        Carta asCorazones = new Carta("As", "Corazones");
        Carta jTrebol = new Carta("J", "Trébol");
        Carta qDiamante = new Carta("Q", "Diamante");
        Carta tresPicas = new Carta("3", "Picas");
        Carta asTrebol = new Carta("As", "Trébol");

        // Modificar el valor del As de Trébol a bajo
        asTrebol.setAsAlto(false);

        // Mostrar información de las cartas usando toString()
        for (Carta carta : new Carta[]{asCorazones, jTrebol, qDiamante, tresPicas, asTrebol}) {
            System.out.println(carta);
        }

        // Mostrar el valor de cada carta y calcular la suma de valores de todas las cartas
        int sumaValores = 0;
        for (Carta carta : new Carta[]{asCorazones, jTrebol, qDiamante, tresPicas, asTrebol}) {
            int valor = carta.valorcarta();
            System.out.println("Valor de " + carta + ": " + valor);
            sumaValores += valor;
        }
        System.out.println("Suma de los valores de las cartas: " + sumaValores);
    }
}
