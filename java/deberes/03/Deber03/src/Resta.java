/* Deber03
 * Nombre: Alex Travez, Mateo Oviedo
 * Fecha de realizacion:11/10/2024
   Fecha de entrega:15/05/2024
   Resultados: El código funciona correctamente de acuerdo a las instrucciones que se han dispuesto
 */
import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario

public class Resta {
    public static void main(String[] args) {
        // Declara dos variables enteras para almacenar los números que se restarán
        int a, b;
        
        // Muestra un mensaje de bienvenida en la consola
        System.out.println("Bienvenido a la calculadora de resta by Mateo Oviedo y Alex Travez");
        
        // Crea un objeto Scanner para leer la entrada del usuario desde la consola
        Scanner sc = new Scanner(System.in);
        
        // Solicita al usuario que introduzca el primer número
        System.out.println("Introduce el primer número: ");
        a = sc.nextInt(); // Lee el primer número introducido por el usuario y lo almacena en la variable 'a'
        
        // Solicita al usuario que introduzca el segundo número
        System.out.println("Introduce el segundo número: ");
        b = sc.nextInt(); // Lee el segundo número introducido por el usuario y lo almacena en la variable 'b'
        
        // Calcula la resta de los dos números y muestra el resultado en la consola
        System.out.println("Resultado: " + a + " - " + b + " = " + (a - b));
    }
}
/*Conclusiones:
 * El presente programa tiene como finalidad la realizacion de la operacion aritmética Resta, lo cual
 * mediante el uso de una libreria se uso con el fin de poder interactuar los datos que ingresa el usuario
 * con la operación aritmética consiguiendo de esta manera que el programa se ejecute con exito.
 * Recomendaciones:
 * - Se recomienda que antes de realizar el siguiente codigo, la persona se instruya en lo que es la
 * creación del objeto Scanner y como este es usado para la "interaccion" de los datos que ingrese el usuario
 *
 * Bibliografía:
 * Martínez Ladrón de Guevara, J. (sin fecha de publicación). Fundamentos de programación en Java. Editorial EME.
 */