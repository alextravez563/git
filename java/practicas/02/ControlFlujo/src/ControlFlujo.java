//Practica02
//Nombre: Alex Travez, Mateo Oviedo
//Fecha de realizacion: 20/10/2024
//Fecha de entrega: 24/10/2024
//Resultados: El programa cumple con los parámetros de la práctica, cumpliendo con los resultados esperados al momento de ejecutarlo.
//Conclusiones:
//El código funciona correctamente, los resultados son los esperados, el programa cumple con los parámetros de la práctica los bucles y condicionales, el programa es eficiente y fácil de entender, el código es legible.
//El código funciona correctamente, los mensajes se muestran en la consola.
//Recomendaciones:
//Se recomienda que al momento de pasar el código verificar que estos terminen con el punto y coma para evitar posibles errores.
//Se recomienda tener clara la estructura de las sentencias de condicion con los parametros solicitados en la guia de la practica.
//Bibliografía:
//Diapositivas del docente
import java.util.Scanner;

public class ControlFlujo {

    public static void main(String[] args) {
        Scanner gestorIngreso = new Scanner(System.in);
        char continuar;

        do {
            // Solicitar el nombre del usuario
            System.out.print("Ingresa tu nombre: ");
            String nombre = gestorIngreso.nextLine();

            // Solicitar la nota del primer bimestre con validación de entrada
            double nota1;
            do {
                System.out.print("Ingresa tu nota1 (entre 0 y 20): ");
                if (gestorIngreso.hasNextDouble()) {
                    nota1 = gestorIngreso.nextDouble();
                } else {
                    System.out.println("Error: Ingresa un valor válido.");
                    gestorIngreso.next(); // Limpiar el buffer de entrada
                    nota1 = -1; // Forzar que la validación falle
                }
            } while (nota1 < 0 || nota1 > 20);

            // Solicitar la nota del segundo bimestre con validación de entrada
            double nota2;
            do {
                System.out.print("Ingresa tu nota2 (entre 0 y 20): ");
                if (gestorIngreso.hasNextDouble()) {
                    nota2 = gestorIngreso.nextDouble();
                } else {
                    System.out.println("Error: Ingresa un valor válido.");
                    gestorIngreso.next(); // Limpiar el buffer de entrada
                    nota2 = -1; // Forzar que la validación falle
                }
            } while (nota2 < 0 || nota2 > 20);

            // Calcular la nota final
            double fin = nota1 + nota2;
            String equivalencia;

            // Determinar la equivalencia de la nota final
            if (fin >= 39) {
                equivalencia = "Excelente, con honores";
            } else if (fin >= 36) {
                equivalencia = "Excelente";
            } else if (fin >= 32) {
                equivalencia = "Muy bueno";
            } else if (fin >= 30) {
                equivalencia = "Bueno";
            } else if (fin >= 28) {
                equivalencia = "Aprobado";
            } else {
                equivalencia = "Fallido";
            }

            // Verificar si el estudiante puede tomar el examen de recuperación
            double recuperacion = 0;
            if (fin >= 18 && fin < 28) {
                System.out.print("¿Deseas ingresar la nota del examen de recuperación? (S/N): ");
                char respuesta = gestorIngreso.next().charAt(0);

                if (respuesta == 'S' || respuesta == 's') {
                    do {
                        System.out.print("Ingresa la nota del examen de recuperación (entre 0 y 40): ");
                        if (gestorIngreso.hasNextDouble()) {
                            recuperacion = gestorIngreso.nextDouble();
                        } else {
                            System.out.println("Error: Ingresa un valor válido.");
                            gestorIngreso.next(); // Limpiar el buffer de entrada
                            recuperacion = -1; // Forzar que la validación falle
                        }
                    } while (recuperacion < 0 || recuperacion > 40);

                    // Recalcular la nota final con la recuperación
                    fin = (fin + recuperacion) / 2;
                }
            }

            // Determinar el estado del estudiante
            char estado = fin >= 28 ? 'E' : 'F';
            char estadoRecuperacion = (recuperacion > 0 && fin >= 24) ? 'A' : 'F';

            // Mostrar los resultados
            System.out.println("El estudiante " + nombre + " obtuvo:");
            System.out.println(" - Nota 1: " + nota1);
            System.out.println(" - Nota 2: " + nota2);
            if (recuperacion > 0) {
                System.out.println(" - Nota de recuperación: " + recuperacion);
            }
            System.out.println(" - Nota final: " + fin);
            System.out.println(" - Equivalencia: " + equivalencia);
            System.out.println(" - Estado: " + estado);
            if (recuperacion > 0) {
                System.out.println(" - Estado recuperación: " + estadoRecuperacion);
            }

            // Preguntar si desea ingresar otra calificación
            System.out.print("¿Deseas ingresar otra calificación? (S/N): ");
            continuar = gestorIngreso.next().charAt(0);

            // Limpiar el buffer del scanner
            gestorIngreso.nextLine();
        } while (continuar == 'S' || continuar == 's');

        gestorIngreso.close();
    }
}
