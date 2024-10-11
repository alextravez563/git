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