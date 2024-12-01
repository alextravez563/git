import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Main que gestiona la interfaz de usuario y la lógica principal de la calculadora
 */
public class Main {
    // Scanner estático para manejar la entrada del usuario
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Método para leer un número entero con manejo de errores
     * Solicita entrada hasta que se proporciona un número entero válido
     *
     * @param mensaje Mensaje para mostrar al usuario
     * @return Número entero ingresado por el usuario
     */
    private static int leerNumeroEntero(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                // Si la entrada no es un número, muestra error y limpia el buffer
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.nextLine(); // Limpiar buffer del scanner
            }
        }
    }

    /**
     * Método para leer un número en un rango específico
     * Solicita entrada hasta que se proporciona un número dentro del rango
     *
     * @param mensaje Mensaje para mostrar al usuario
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return Número entero dentro del rango especificado
     */
    private static int leerNumeroEnRango(String mensaje, int min, int max) {
        while (true) {
            // Lee un número entero
            int numero = leerNumeroEntero(mensaje);

            // Verifica si está dentro del rango
            if (numero >= min && numero <= max) {
                return numero;
            }

            // Si no está en rango, muestra mensaje de error
            System.out.printf("Error: El número debe estar entre %d y %d.\n", min, max);
        }
    }

    /**
     * Método main principal que ejecuta la aplicación de calculadora
     * Gestiona el flujo completo de la aplicación:
     * - Entrada de números
     * - Selección de operaciones
     * - Manejo de errores
     * - Opciones de continuación
     */
    public static void main(String[] args) {
        // Variable para controlar la continuación del programa
        boolean continuarCalculadora = true;

        // Bucle principal que permite múltiples sesiones de cálculo
        while (continuarCalculadora) {
            // Solicitar primer número con validación de rango
            int num1 = leerNumeroEnRango("Ingrese el primer número entero (entre -20000 y 20000):", -20000, 20000);

            // Solicitar segundo número con validación de rango
            int num2 = leerNumeroEnRango("Ingrese el segundo número entero (entre -20000 y 20000):", -20000, 20000);

            try {
                // Crear instancia de Calculadora con los números ingresados
                Calculadora calculadora = new Calculadora(num1, num2);

                // Bucle para manejar múltiples operaciones con los mismos números
                while (true) {
                    // Mostrar menú y solicitar opción con validación de rango
                    int opcion = leerNumeroEnRango(
                            "\nSeleccione una operación:\n" +
                                    "1. Suma\n" +
                                    "2. Resta\n" +
                                    "3. Multiplicación\n" +
                                    "4. División\n" +
                                    "5. Módulo\n" +
                                    "6. Potencia\n" +
                                    "7. Radicación\n" +
                                    "8. Cambiar números\n" +
                                    "9. Salir",
                            1, 9
                    );

                    // Bloque try-catch para manejar errores en las operaciones
                    try {
                        double resultado = 0;
                        // Switch para manejar diferentes operaciones
                        switch (opcion) {
                            case 1:
                                resultado = calculadora.suma();
                                System.out.println("Resultado de la suma: " + resultado);
                                break;
                            case 2:
                                resultado = calculadora.resta();
                                System.out.println("Resultado de la resta: " + resultado);
                                break;
                            case 3:
                                resultado = calculadora.multiplicacion();
                                System.out.println("Resultado de la multiplicación: " + resultado);
                                break;
                            case 4:
                                resultado = calculadora.division();
                                System.out.println("Resultado de la división: " + resultado);
                                break;
                            case 5:
                                resultado = calculadora.modulo();
                                System.out.println("Resultado del módulo: " + resultado);
                                break;
                            case 6:
                                resultado = calculadora.potencia();
                                System.out.println("Resultado de la potencia: " + resultado);
                                break;
                            case 7:
                                resultado = calculadora.radicacion();
                                System.out.println("Resultado de la radicación: " + resultado);
                                break;
                            case 8:
                                break; // Salir del menú de operaciones para cambiar números
                            case 9:
                                continuarCalculadora = false; // Salir del programa
                                break;
                        }

                        // Salir de los bucles si se elige cambiar números o salir
                        if (opcion == 8 || opcion == 9) {
                            break;
                        }

                    } catch (ArithmeticException e) {
                        // Manejo de errores aritméticos (división por cero, etc.)
                        System.out.println("Error aritmético: " + e.getMessage());
                    } catch (Exception e) {
                        // Manejo de cualquier otro error inesperado
                        System.out.println("Error inesperado: " + e.getMessage());
                    }
                }

            } catch (IllegalArgumentException e) {
                // Manejo de errores en la creación de la calculadora (números fuera de rango)
                System.out.println("Error en los operandos: " + e.getMessage());
            }
        }

        // Mensaje de despedida al salir del programa
        System.out.println("Gracias por usar la calculadora. ¡Hasta luego!");
        // Cerrar el scanner
        scanner.close();
    }
}