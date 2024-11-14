//Practica01
//Nombre: Alex Travez, Mateo Oviedo
//Fecha de realizacion: 16/10/2024
//Fecha de entrega: 17/10/2024
//Resultados:
//El código permite visualizar la informacion del estudiante 1 y el estudiante 2, calculando su IMC, se obtuvo lo solicitado.
//Un byte en Java es un tipo de dato de 8 bits que puede representar valores enteros en el rango de -128 a 127.El valor 255 está fuera del rango permitido para un byte. Sin embargo, puedes usar casting para forzar el almacenamiento de valores mayores que 127 en un byte. Esto puede llevar a un fenómeno conocido como "overflow" o "desbordamienton por ese motivo en este caso el -1 representa ese valor.
//Incremento posterior (x++): El valor de x se incrementa después de ser usado en la expresión. En el primer caso, x++ incrementa x de 0 a 1, pero el valor de y permanece en 0 porque la operación de incremento se realiza después de la asignación. Así que, cuando y = x++, el valor de y es el valor original de x antes de la operación de incremento.
//Incremento previo (++x): El valor de x se incrementa antes de ser usado en la expresión. Cuando y = ++x, x se incrementa a 2 y luego se asigna a y, por lo que ambos valores serán 2 después de esta operación.
//Conclusiones:
//El código funciona correctamente, los mensajes se muestran en la consola, las operaciones estan realizadas de forma correcta.
//Se logró indentificar cuando existe un desvordamiento y por tal motivo la perdida de inbformacion al intentar guardar el valor 255 en una variable de tipo byte.
//Se logró identificar que el operador + se puede utilizar para concatenar cadenas y enteros,

//Recomendaciones:
//Se recomienda que al momento de pasar el código verificar que estos terminen con el punto y coma para evitar posibles errores.
//Se recomienda que el codigo usado cumpla con las reglas de estilo de Java y lo solicitado en la practica.

//Bibliografía:
//Diapositivas del docente.

package paquete;
import java.util.Scanner;
public class UsoDatos {

    // Definición de una enumeración que contiene los días de la semana
    enum DiasSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }


    public static void main(String[] args) {
        // Creamos un objeto Scanner para permitir la entrada de datos por teclado
        Scanner scanner = new Scanner(System.in);

        // Solicitar y almacenar la información del primer estudiante (Estudiante 1 - Alex)
        System.out.print("Ingresa tu nombre completo: ");
        String nombreCompletoE1 = scanner.nextLine(); // Almacenamos el nombre completo

        System.out.print("Ingresa tu edad: ");
        int edadE1 = scanner.nextInt(); // Almacenamos la edad como entero

        System.out.print("Ingresa tu altura (en centímetros): ");
        double alturaCmE1 = scanner.nextDouble(); // Almacenamos la altura en cm

        // Convertimos la altura de centímetros a metros para cálculos posteriores
        double alturaE1 = alturaCmE1 / 100.0;

        System.out.print("Ingresa tu peso (en kilogramos): ");
        double pesoE1 = scanner.nextDouble(); // Almacenamos el peso en kg

        // Obtenemos la inicial del nombre del estudiante 1 - Alex
        char letraNombreE1 = nombreCompletoE1.charAt(0);

        // Información predefinida para el segundo estudiante (Estudiante 2 - Mateo)
        String nombreCompletoE2 = "Mateo Sebastian Oviedo Trujillo";
        int edadE2 = 21; // Edad de Mateo
        double alturaE2 = 1.69; // Altura de Mateo en metros
        double pesoE2 = 52; // Peso de Mateo en kg
        char letraNombreE2 = 'O'; // Inicial del nombre de Mateo
        boolean esEstudianteE2 = true; // Indicamos que Mateo es estudiante

        // Comparaciones entre las edades y alturas de los dos estudiantes
        boolean esMayor = edadE1 > edadE2; // Comparación de edades: ¿Es Alex mayor que Mateo?
        boolean esTallaAltaE1 = alturaE1 > alturaE2; // Comparación de alturas: ¿Es Alex más alto?
        boolean esTallaAltaE2 = alturaE2 > alturaE1; // ¿Es Mateo más alto?

        // Concatenación de la información del estudiante 1 usando tabulaciones (\t)
        String informacionPersonalE1 = letraNombreE1 + "\t" + edadE1 + "\t" + alturaE1 + "\t" + pesoE1 + "\n";

        // Concatenación de la información del estudiante 2 usando símbolos $ y retornos de carro (\r)
        String informacionPersonalE2 = letraNombreE2 + "$" + edadE2 + "$" + alturaE2 + "$" + pesoE2 + "\r";

        // Operaciones matemáticas con la información de ambos estudiantes
        System.out.println("La suma de las edades es: " + (edadE1 + edadE2));
        System.out.println("La resta de las alturas es: " + (alturaE1 - alturaE2));
        System.out.println("La multiplicación de los pesos es: " + (pesoE1 * pesoE2));
        System.out.println("El resultado de dividir la suma de las edades para la multiplicación de los pesos es: "
                + ((edadE1 + edadE2) / (pesoE1 * pesoE2)));
        System.out.println("El residuo de la suma de las edades para la resta de las alturas es: "
                + ((edadE1 + edadE2) % (alturaE1 - alturaE2)));

        // Cálculo del Índice de Masa Corporal (IMC) para ambos estudiantes
        double imcE1 = pesoE1 / (alturaE1 * alturaE1); // IMC de Alex
        double imcE2 = pesoE2 / (alturaE2 * alturaE2); // IMC de Mateo

        // Mostrar información detallada del estudiante 1 (Alex)
        System.out.println("\nEstudiante 1:");
        System.out.println("Nombre completo: " + nombreCompletoE1);
        System.out.println("Inicial: " + letraNombreE1);
        System.out.println("Edad: " + edadE1 + " años");
        System.out.println("Peso: " + pesoE1 + " kg");
        System.out.println("Altura: " + alturaE1 + " m");
        System.out.printf("IMC: %.2f kg/m²\n", imcE1); // Formateamos el IMC con dos decimales
        System.out.println("¿Es estudiante? " + true); // Indicamos que Alex es estudiante
        System.out.println("¿Es el más alto? " + esTallaAltaE1); // ¿Es Alex el más alto?
        System.out.println("¿Es mayor? " + esMayor); // ¿Es Alex mayor que Mateo?

        // Mostrar información detallada del estudiante 2 (Mateo)
        System.out.println("\nEstudiante 2:");
        System.out.println("Nombre completo: " + nombreCompletoE2);
        System.out.println("Inicial: " + letraNombreE2);
        System.out.println("Edad: " + edadE2 + " años");
        System.out.println("Peso: " + pesoE2 + " kg");
        System.out.println("Altura: " + alturaE2 + " m");
        System.out.printf("IMC: %.2f kg/m²\n", imcE2); // Formateamos el IMC de Mateo
        System.out.println("¿Es estudiante? " + esEstudianteE2); // Indicamos que Mateo es estudiante
        System.out.println("¿Es el más alto? " + esTallaAltaE2); // ¿Es Mateo el más alto?
        System.out.println("¿Es mayor? " + !esMayor); // ¿Es Mateo mayor que Alex?

        // Operaciones con arreglos
        int[] numeros = {1, 2, 3, 4, 5}; // Definimos un arreglo de enteros
        System.out.println("\nEl tercer elemento del arreglo es: " + numeros[2]);
        System.out.println("El quinto elemento del arreglo es: " + numeros[4]);
        System.out.println("El número de elementos del arreglo es: " + numeros.length); // Longitud del arreglo

        // Uso de la enumeración DiasSemana
        DiasSemana feriado = DiasSemana.MIERCOLES; // Asignamos el día miércoles a la variable feriado
        System.out.println("El feriado es: " + feriado); // Mostramos el día feriado

        // Cálculo del cuadrado de la altura usando Math.pow()
        double cuadrado = Math.pow(alturaE1, 2);
        System.out.println("El cuadrado de la altura es: " + cuadrado);

        // Cálculo de la raíz cuadrada del peso de Mateo usando Math.sqrt()
        double raiz = Math.sqrt(pesoE2);
        System.out.println("La raíz del peso de tu compañero es: " + raiz);

        // Uso de casting para almacenar un valor mayor que 127 en un byte
        byte miByte = (byte) 255;
        System.out.println("Valor almacenado en miByte: " + miByte); // Demostración del desbordamiento (overflow)

        // Ejemplos de incremento posterior y previo
        int x = 0;
        int y = 0;
        System.out.println("\n" +
                "x es " + x + ", y es " + y); // Inicializamos x y y en 0
        x++; // Incremento posterior: se incrementa después de usar el valor
        System.out.println("x++ resulta en " + x);
        ++x; // Incremento previo: se incrementa antes de usar el valor
        System.out.println("++x resulta en " + x);

        // Reinicializamos el valor de x
        System.out.println("Reinicio del valor de x");
        x = 0;
        y = x++; // y toma el valor de x antes del incremento
        System.out.println("y = x++ (posterior) resulta en: x es " + x + ", y es " + y);
        y = ++x; // y toma el valor de x después del incremento
        System.out.println("y = ++x (previo) resulta en: x es " + x + ", y es " + y);

        // Uso del operador + para concatenar y sumar
        System.out.println("\n" + (2 + 3) + "prueba"); // Primero se suman los números
        System.out.println("prueba" + 2 + 3); // Primero se concatena el texto y luego los números

        // Cerramos el objeto scanner para evitar posibles fugas de recursos
        scanner.close();
    }
}




