//Deber09
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:2/12/2024
// Fecha de entrega: 5/12/2024
//Resultados: El presente programa es una calculadora, la cual atrapa los posibles
//  errores que el usuario pueda ingresar mediante el uso de try-catch.
//  Y al momento de ejecutar el codigo proporciona un mensaje al usuario para que identifique el tipo de error.
//  que esta cometiendo para que los re-ingrese nuevamente , por ejemplo si el usuario ingresa un numero decimal en vez de un numero entero el programa le proporciona un mensaje de error.
// y le va a pedir que ingrese un numero entero valido para que funcione correctamente.
// Otro error que el programa atrapa es cuando el usuario ingresa un numero mayor a 20000 en valor absoluto, el programa le proporciona un mensaje de error y le pide que ingrese un numero menor a 20000.Por lo cual el programa esta diseñado para capturar esos posibles errores de entrada de datos y proporcionar un mensaje al usuario para que identifique el tipo de error que esta cometiendo para que los re-ingrese nuevamente.



// Importamos las clases necesarias para manejar entrada de usuario y excepciones

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase Calculadora que realiza operaciones matemáticas básicas
 * Gestiona dos operandos enteros y proporciona métodos para realizar cálculos
 */
public class Calculadora {
    // Variables privadas para almacenar los dos operandos
    private int operando1;
    private int operando2;

    /**
     * Constructor de la clase Calculadora
     * Valida que los operandos no excedan el límite de 20.000 en valor absoluto
     *
     * @param operando1 Primer número entero para la operación
     * @param operando2 Segundo número entero para la operación
     * @throws IllegalArgumentException Si alguno de los operandos supera 20.000
     */
    public Calculadora(int operando1, int operando2) throws IllegalArgumentException {
        // Verificación del rango de los operandos
        if (Math.abs(operando1) > 20000 || Math.abs(operando2) > 20000) {
            throw new IllegalArgumentException("Los operandos no deben superar 20.000 en valor absoluto");
        }
        // Asignación de los operandos si pasan la validación
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    /**
     * Método para realizar suma de los dos operandos
     * @return Resultado de la suma
     * @throws Exception Manejo de posibles errores
     */
    public int suma() throws Exception {
        return operando1 + operando2;
    }

    /**
     * Método para realizar resta de los dos operandos
     * @return Resultado de la resta
     * @throws Exception Manejo de posibles errores
     */
    public int resta() throws Exception {
        return operando1 - operando2;
    }

    /**
     * Método para realizar multiplicación de los dos operandos
     * @return Resultado de la multiplicación
     * @throws Exception Manejo de posibles errores
     */
    public int multiplicacion() throws Exception {
        return operando1 * operando2;
    }

    /**
     * Método para realizar división de los dos operandos
     * Incluye validación para evitar división por cero
     * @return Resultado de la división
     * @throws Exception Manejo de posibles errores
     */
    public double division() throws Exception {
        // Validación de división por cero
        if (operando2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        // Conversión a double para permitir divisiones con decimales
        return (double) operando1 / operando2;
    }

    /**
     * Método para calcular el módulo (resto) de la división
     * Incluye validación para evitar módulo por cero
     * @return Resultado del módulo
     * @throws Exception Manejo de posibles errores
     */
    public int modulo() throws Exception {
        // Validación de módulo por cero
        if (operando2 == 0) {
            throw new ArithmeticException("No se puede calcular módulo por cero");
        }
        return operando1 % operando2;
    }

    /**
     * Método para calcular potencia
     * Utiliza el método Math.pow para cálculos de potencia
     * @return Resultado de la potenciación
     * @throws Exception Manejo de posibles errores
     */
    public double potencia() throws Exception {
        return Math.pow(operando1, operando2);
    }

    /**
     * Método para calcular radicación
     * Incluye validación para evitar raíces de números negativos
     * @return Resultado de la radicación
     * @throws Exception Manejo de posibles errores
     */
    public double radicacion() throws Exception {
        // Validación de raíz de número negativo
        if (operando1 < 0) {
            throw new ArithmeticException("No se puede calcular raíz de número negativo");
        }
        // Cálculo de raíz utilizando Math.pow con exponente fraccionario
        return Math.pow(operando1, 1.0 / operando2);
    }
}
/*Conclusiones:
 * 1-El presente codigo es la creacion de una calculadora basica, pero con la
 * salvedad de que sobre ella, captura los posibles errores que el usuario
 * puede cometer con tendencias a ingreso de datos de manera erronea .
 *2- El codigo esta diseñado para capturar esos posibles errores de entrada de datos
 * y proporcionar un mensaje al usuario para que identifique el tipo de error
 * que esta cometiendo para que los re-ingrese nuevamente.
 *
 * Recomendaciomes:
 * 1-Se recomienda aprender lo que es y hace el bloque try-catch la cual es una estructura de
 * control diseñada para  manejar excepciones o tipos de errores que los
 * usuarios por lo general solemos cometer al momento de ingresar datos por
 * consola
 * 2- Se recomienda aprender a manejar excepciones en Java, ya que es una parte fundamental en la practica a futuro.
 * 3- Se recomienda aprender a manejar las excepciones de manera correcta para que el usuario pueda entender el error que esta cometiendo.
 *
 *
 * Bibliografía
//
* "1. Horstmann, C. S. (2019). Core Java, Volume I--Fundamentals (12th Edition). " +
        "Pearson. " +
        "Link: https://www.pearson.com/us/higher-education/program/Horstmann-Core-Java-Volume-I-Fundamentals-12th-Edition/PGM333860.html " +
        "- Referencia fundamental para comprender manejo de excepciones y estructuras de control en Java. " +
        "Capítulo 5 ofrece insights sobre manejo de errores y entrada de usuario.",

        "2. Bloch, J. (2018). Effective Java (3rd Edition). " +
        "Addison-Wesley Professional. " +
        "Link: https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/ " +
        "- Guía definitiva para mejores prácticas en desarrollo Java. " +
        "Proporciona recomendaciones detalladas sobre diseño de clases, manejo de errores y programación defensiva.",

        "3.Aula Virtual - EPN: Iniciar sesión en el sitio. (s/f). Edu.ec. Recuperado el 30 de noviembre de 2024, de https://aulasvirtuales.epn.edu.ec/mod/page/view.php?id=10339129

*  */