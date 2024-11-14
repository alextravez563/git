import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();

        // Registro de 10 pedidos
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el tipo de integrado (1, 2 o 3) para el pedido " + (i + 1) + ": ");
            int tipo = scanner.nextInt();
            System.out.print("Ingrese la cantidad de integrados para el pedido " + (i + 1) + ": ");
            int cantidad = scanner.nextInt();
            pedidos.add(new Pedido(tipo, cantidad));
        }

        // Cálculo y muestra de resultados
        double totalPresupuesto = 0;
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
            totalPresupuesto += pedido.obtenerPresupuesto();
        }

        System.out.printf("%nPresupuesto total para los 10 pedidos: %.2f USD%n", totalPresupuesto);
        scanner.close();
    }
}
