//Practica01
//Nombre: Alex Travez, Mateo Oviedo
//Fecha de realizacion: 16/10/2024
//Fecha de entrega: 17/10/2024
//Resultados:
//El código permite visualizar la informacion del estudiante 1 y el estudiante 2, calculando su IMC, se obtuvo lo solicitado.
//Un byte en Java es un tipo de dato de 8 bits que puede representar valores enteros en el rango de -128 a 127.El valor 255 está fuera del rango permitido para un byte. Sin embargo, puedes usar casting para forzar el almacenamiento de valores mayores que 127 en un byte. Esto puede llevar a un fenómeno conocido como "overflow" o "desbordamienton por ese motivo en este caso el -1 representa ese valor.
//Incremento posterior (x++): El valor de x se incrementa después de ser usado en la expresión. En el primer caso, x++ incrementa x de 0 a 1, pero el valor de y permanece en 0 porque la operación de incremento se realiza después de la asignación. Así que, cuando y = x++, el valor de y es el valor original de x antes de la operación de incremento.
//Incremento previo (++x): El valor de x se incrementa antes de ser usado en la expresión. Cuando y = ++x, x se incrementa a 2 y luego se asigna a y, por lo que ambos valores serán 2 después de esta operación.

package paquete;

import java.util.Scanner;

public class UsoDatos {

    // Definición de la enumeración fuera del método main
    enum DiasSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos del estudiante 1 (alex)
        System.out.print("Ingresa tu nombre completo: ");
        String nombreCompletoE1 = scanner.nextLine();

        System.out.print("Ingresa tu edad: ");
        int edadE1 = scanner.nextInt();

        // Ingresar la altura en centímetros
        System.out.print("Ingresa tu altura (en centímetros): ");
        double alturaCmE1 = scanner.nextDouble();

        // Convertir la altura a metros
        double alturaE1 = alturaCmE1 / 100.0;

        System.out.print("Ingresa tu peso (en kilogramos): ");
        double pesoE1 = scanner.nextDouble();

        // Inicial del nombre
        char letraNombreE1 = nombreCompletoE1.charAt(0);

        // Información del compañero (Mateo)
        String nombreCompletoE2 = "Mateo Sebastian Oviedo Trujillo";
        int edadE2 = 21;
        double alturaE2 = 1.69;
        double pesoE2 = 52;
        char letraNombreE2 = 'O';
        boolean esEstudianteE2 = true;

        // Comparaciones entre los dos estudiantes
        boolean esMayor = edadE1 > edadE2;
        boolean esTallaAltaE1 = alturaE1 > alturaE2;
        boolean esTallaAltaE2 = alturaE2 > alturaE1;

        // Concatenación de la información personal
        String informacionPersonalE1 = letraNombreE1 + "\t" + edadE1 + "\t" + alturaE1 + "\t" + pesoE1 + "\n";
        String informacionPersonalE2 = letraNombreE2 + "$" + edadE2 + "$" + alturaE2 + "$" + pesoE2 + "\r";

        System.out.println("La suma de las edades es: " + (edadE1 + edadE2));
        System.out.println("La resta de las alturas es: " + (alturaE1 - alturaE2));
        System.out.println("La multiplicación de los pesos es: " + (pesoE1 * pesoE2));
        System.out.println("El resultado de dividir la suma de las edades para la multiplicación de los pesos es: "
                + ((edadE1 + edadE2) / (pesoE1 * pesoE2)));
        System.out.println("El residuo de la suma de las edades para la resta de las alturas es: "
                + ((edadE1 + edadE2) % (alturaE1 - alturaE2)));

        // Cálculo del IMC
        double imcE1 = pesoE1 / (alturaE1 * alturaE1);
        double imcE2 = pesoE2 / (alturaE2 * alturaE2);

        // Información de los estudiantes
        System.out.println("\nEstudiante 1:");
        System.out.println("Nombre completo: " + nombreCompletoE1);
        System.out.println("Inicial: " + letraNombreE1);
        System.out.println("Edad: " + edadE1 + " años");
        System.out.println("Peso: " + pesoE1 + " kg");
        System.out.println("Altura: " + alturaE1 + " m");
        System.out.printf("IMC: %.2f kg/m²\n", imcE1);
        System.out.println("¿Es estudiante? " + true);
        System.out.println("¿Es el más alto? " + esTallaAltaE1);
        System.out.println("¿Es mayor? " + esMayor);

        System.out.println("\nEstudiante 2:");
        System.out.println("Nombre completo: " + nombreCompletoE2);
        System.out.println("Inicial: " + letraNombreE2);
        System.out.println("Edad: " + edadE2 + " años");
        System.out.println("Peso: " + pesoE2 + " kg");
        System.out.println("Altura: " + alturaE2 + " m");
        System.out.printf("IMC: %.2f kg/m²\n", imcE2);
        System.out.println("¿Es estudiante? " + esEstudianteE2);
        System.out.println("¿Es el más alto? " + esTallaAltaE2);
        System.out.println("¿Es mayor? " + !esMayor);


        int[] numeros = {1, 2, 3, 4, 5};
        System.out.println("\nEl tercer elemento del arreglo es: " + numeros[2]);
        System.out.println("El quinto elemento del arreglo es: " + numeros[4]);
        System.out.println("El número de elementos del arreglo es: " + numeros.length);


        DiasSemana feriado = DiasSemana.MIERCOLES;
        System.out.println("El feriado es: " + feriado);

        // Cálculo de Math.pow() y Math.sqrt()
        double cuadrado = Math.pow(alturaE1, 2);
        System.out.println("El cuadrado de la altura es: " + cuadrado);

        double raiz = Math.sqrt(pesoE2);
        System.out.println("La raíz del peso de tu compañero es: " + raiz);

        // Casting de byte
        byte miByte = (byte) 255;
        System.out.println("Valor almacenado en miByte: " + miByte);

        // Incremento posterior y previo
        int x = 0;
        int y = 0;
        System.out.println("\n" +
                "x es " + x + ", y es " + y);
        x++;
        System.out.println("x++ resulta en " + x);
        ++x;
        System.out.println("++x resulta en " + x);
        System.out.println("Reinicio del valor de x");
        x = 0;
        y = x++;
        System.out.println("y = x++ (posterior) resulta en: x es " + x + ", y es " + y);
        y = ++x;
        System.out.println("y = ++x (previo) resulta en: x es " + x + ", y es " + y);

        // Operador +
        System.out.println("\n" + (2 + 3) + "prueba");
        System.out.println("prueba" + 2 + 3);

        // Cerrar el scanner
        scanner.close();
    }
}


//Conclusiones:
//El código funciona correctamente, los mensajes se muestran en la consola, las operaciones estan realizadas de forma correcta.
//Se logró indentificar cuando existe un desvordamiento y por tal motivo la perdida de inbformacion al intentar guardar el valor 255 en una variable de tipo byte.
//Se logró identificar que el operador + se puede utilizar para concatenar cadenas y enteros,

//Recomendaciones:
//Se recomienda que al momento de pasar el código verificar que estos terminen con el punto y coma para evitar posibles errores.
//Se recomienda que el codigo usado cumpla con las reglas de estilo de Java y lo solicitado en la practica.

//Bibliografía:
//Diapositivas del docente.
