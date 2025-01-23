
/*
//Practica12
 // Nombre: Alex Travez , Mateo Oviedo
 // Fecha de realizacion:22/01/2025
 // Fecha de entrega: 23/01/2025

 */



// Método principal para demostrar el uso de la clase genérica Caja.
public static void main(String[] args) {

    // 1. Crear una instancia de Caja para manejar cadenas de texto.
    Caja<String> cajaDeTexto = new Caja<>();
    // Establecer el contenido de la caja con el texto "Hola, Mundo!".
    cajaDeTexto.setContenido("Hola, Mundo!");
    // Imprimir el contenido almacenado en la caja.
    System.out.println("Contenido de la caja: " + cajaDeTexto.getContenido());
    // Resultado esperado: Contenido de la caja: Hola, Mundo!

    // 2. Crear una instancia de Caja para manejar números enteros.
    Caja<Integer> cajaDeEntero = new Caja<>();
    // Establecer el contenido de la caja con el valor entero 123.
    cajaDeEntero.setContenido(123);
    // Imprimir el contenido almacenado en la caja.
    System.out.println("Contenido de la caja: " + cajaDeEntero.getContenido());
    // Resultado esperado: Contenido de la caja: 123

    // 3. Crear una instancia de Caja para manejar números decimales.
    Caja<Double> cajaDeDecimal = new Caja<>();
    // Establecer el contenido de la caja con el valor decimal 3.14.
    cajaDeDecimal.setContenido(3.14);
    // Imprimir el contenido almacenado en la caja.
    System.out.println("Contenido de la caja: " + cajaDeDecimal.getContenido());
    // Resultado esperado: Contenido de la caja: 3.14
}

/*
Resultados esperados:
1- ¿Qué es un genérico en Java?
Un genérico es una característica de Java que permite definir clases, interfaces y métodos con tipos de datos parametrizados. Esto permite que el código sea más reutilizable y seguro, al garantizar que los tipos de datos se manejen correctamente durante la compilación.

2-¿Cómo se define una clase genérica?
Una clase genérica se define utilizando un parámetro de tipo dentro de los símbolos < >. Por ejemplo:

public class Caja<T> {
    private T contenido;
}
Aquí, T es un parámetro de tipo que puede ser reemplazado por cualquier tipo de datos al momento de usar la clase.

3-¿Cuál es el propósito del uso de genéricos en Java?
Permiten crear clases y métodos que funcionan con diferentes tipos de datos.
Seguridad de tipos: Evitan errores de tipo en tiempo de ejecución al garantizar que los tipos de datos sean correctos durante la compilación.
Legibilidad: Facilitan el entendimiento del código al especificar claramente los tipos de datos con los que trabajan las clases o métodos.

Conclusiones:
1. Los genéricos en Java permiten crear estructuras de datos reutilizables que pueden manejar diferentes tipos de datos sin pérdida de seguridad de tipo.
2. Este programa demuestra la flexibilidad de los genéricos al utilizar una sola clase para manejar objetos de tipos diferentes como `String`, `Integer` y `Double`.
3. El código es más legible y menos propenso a errores en comparación con soluciones sin genéricos, ya que no requiere conversiones explícitas.

Recomendaciones:
1. Siempre proporcionar mensajes claros en las salidas del programa para facilitar la interpretación de los resultados, especialmente en aplicaciones grandes.
2. Ampliar este ejemplo agregando validaciones o excepciones para manejar posibles valores nulos o incorrectos.
3. Documentar adecuadamente las clases genéricas en proyectos más grandes para que otros desarrolladores puedan entender su propósito y uso.

Referencias:
- Prácticas de Programación Avanzada - ITID433, Facultad de Ingeniería Eléctrica y Electrónica. (Archivo adjunto: Práctica12.pdf)
- GeeksforGeeks: "Generics in Java" - https://www.geeksforgeeks.org/generics-in-java/
*/
