/* Deber04
 * Nombre: Alex Travez, Mateo Oviedo
 * Fecha de realizacion:20/10/2024
   Fecha de entrega:22/10/2024
   Resultados: El código funciona correctamente de acuerdo a las instrucciones que se han dispuesto
 */
/*Conclusiones:
 * El presente programa tiene como finalidad la realizacion de una sucecion llamada Secuencia de Collatz, el cual
 * consiste en que, ingresar un numero N, este se evalua como Par e Impar, donde se realiza la siguiente
 * operacion,si N es par entoces se divide para 2 (N/2), si es impar entonces se multiplica por 3 y se suma 1 (3N+1), y el resultado
 * de cualquiera de estos dos casos debe volver a evaluarse hasta que llegue a ser 1, porque siempre
 * converge a 1 sea cualquier valor de N.
 * - Se recomienda que antes de realizar el siguiente codigo, la persona se instruya en lo que es la creacion
 * de bucles, como en este caso, el programa debe de evaluar si el valor que ingresa el el correcto, y de no serlo
 * debe volver a preguntar hasta que sea el correcto
 *
 * Bibliografía:
 * Víctor M. Manero & Alfonso Jesús Población. (2021, enero 18). La conjetura de Collatz: un problema «sencillo» que desafiará tu intuición. ABC.es. https://www.abc.es/ciencia/abci-conjetura-collatz-problema-sencillo-desafiara-intuicion-202101180110_noticia.html

 */

import java.util.Scanner;

public class Problema3N1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;

        // Solicita al usuario que ingrese un número positivo
        do {
            System.out.print("Ingrese un número positivo: ");
            N = scanner.nextInt();

            // Mensaje de error si el número no es positivo
            if (N <= 0) {
                System.out.println("Error: el número debe ser positivo.");
            }
        } while (N <= 0);

        int contador = 0;

        // Mientras N no sea 1
        while (N != 1) {
            // Si N es par, N = N / 2
            if (N % 2 == 0) {
                N = N / 2;
            } else {
                // Si N es impar, N = 3 * N + 1
                N = 3 * N + 1;
            }
            System.out.println(N); // Imprime el valor de N actual
            contador++; // Incrementa el contador
        }

        // Imprime el número de elementos en la secuencia
        System.out.println("Número de elementos en la secuencia: " + contador);
        scanner.close();
    }
}
