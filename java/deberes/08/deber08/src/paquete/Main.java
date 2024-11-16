//Deber08-Main.java
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:17/11/2024
// Fecha de entrega: 19/11/2024
/*
Resultados:
 * El programa permite al usuario registrar 10 pedidos de integrados. Cada pedido
 * puede ser de cualquiera de los 3 tipos. Al final, se muestra el resumen del
 * costo total de cada pedido y el costo acumulado de los 10 pedidos.
 * Este programa ilustra la herencia, el polimorfismo y el uso de ArrayList
 * para gestionar objetos de diferentes subclases.
*/

package paquete;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Arreglo para almacenar los pedidos de los clientes
        ArrayList<Integrado>pedidos = new ArrayList<>();
        //Bucle para pedir los pedidos de los clientes
        Scanner scanner = new Scanner(System.in);
        for(int i=1; i<=10; i++){
            // Pidiendo el tipo de Integrado
            System.out.println("---------------------------------------------------");
            System.out.println("Pedido #"+i);
            System.out.print("Ingrese el tipo de integrado (1, 2, 3): ");

            int tipo = scanner.nextInt();
            // Casos de eleccion del integrado
            if (tipo==1){
                // crea un objeto del tipo Integrado1 y agregalo a la lista de pedidos
                pedidos.add(new Integrado1());
            }else if(tipo==2){
                // crea un objeto del tipo Integrado2 y agregalo a la lista de pedidos
                pedidos.add(new Integrado2());

            }else if(tipo==3){
                // crea un objeto del tipo Integrado3 y agregalo a la lista de pedidos
                pedidos.add(new Integrado3());
            }else{
                System.out.println("\nTipo de integrado no valido");
                System.out.println("Intentelo de nuevo");
                i--; //Decrementa en 1 al bucle para que se repita la iteracion
                continue; //Salta al siguiente  ciclo del bucle FOR, evitando que se ejecute el codigo completamente
            }

        }
        System.out.println("---------------------------------------------------");
        double precioTotal=0;
        //Imprime los pedidos de los clientes

        System.out.println("\n                  RESUMEN DE PEDIDOS");
        // los Arrays empiezan a indexar desde el 0
        for(int i=0; i<pedidos.size(); i++){

            System.out.println("\n        -----------Pedido #"+(i+1)+"--------------");
            System.out.println("");

            pedidos.get(i).imprimirCaracteristicas();
            System.out.println("");
            // costo por los 1000 integrados
            double precio =pedidos.get(i).costoMilintegrados();
            System.out.println("Precio por los 1000 integrados: $"+precio);
            // Precio total de los 10 pedidos

            precioTotal=precio+precioTotal;
        }
        System.out.println("_____________________________________________________________");
        System.out.println("El precio total por los 10 pedidos es: "+precioTotal );
        System.out.println("_____________________________________________________________");
        scanner.close();

    }

}
/*
Conclusiones:
 * Este programa permite al usuario registrar 10 pedidos de integrados, calculando
 * automáticamente el costo total para cada tipo y proporcionando un resumen detallado.
 * Se ilustra el uso de herencia, polimorfismo y ArrayList para manejar objetos de
 * diferentes subclases.
 *
 * Recomendaciones:
 * 1. Validar las entradas del usuario para evitar errores al elegir un tipo de integrado.
 * 2. Explorar cómo persistir los datos de los pedidos en un archivo o base de datos.
 * 3. Aprender sobre el uso de interfaces gráficas para mejorar la interacción.
 *
* Bibliografía
//Diapositivas del docente
*/