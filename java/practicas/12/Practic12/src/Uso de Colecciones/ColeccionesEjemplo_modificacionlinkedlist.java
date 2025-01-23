/*
//Practica12-Colecciones
 // Nombre: Alex Travez , Mateo Oviedo
 // Fecha de realizacion:22/01/2025
 // Fecha de entrega: 23/01/2025

 */

import java.util.*; // Importa todas las clases de la biblioteca java.util, que contiene clases para colecciones y estructuras de datos.

public class ColeccionesEjemplo_modificacionlinkedlist {
    public static void main(String[] args) {
        // Uso de ArrayList
        List<String> lista = new ArrayList<>(); // Declara una lista que utiliza un ArrayList para almacenar elementos de tipo String.
        lista.add("Manzana"); // Agrega el elemento "Manzana" a la lista.
        lista.add("Banana"); // Agrega el elemento "Banana" a la lista.
        lista.add("Cereza"); // Agrega el elemento "Cereza" a la lista.

        System.out.println("Elementos en la lista:"); // Imprime un mensaje de encabezado.
        for (String fruta : lista) { // Recorre cada elemento en la lista.
            System.out.println(fruta); // Imprime cada elemento de la lista.
        }

        // Uso de Vector
        Vector<Integer> vector = new Vector<>(); // Declara un Vector para almacenar elementos de tipo Integer.
        vector.add(10); // Agrega el valor 10 al Vector.
        vector.add(20); // Agrega el valor 20 al Vector.
        vector.add(30); // Agrega el valor 30 al Vector.

        System.out.println("\nElementos en el vector:"); // Imprime un mensaje de encabezado.
        for (Integer numero : vector) { // Recorre cada elemento en el Vector.
            System.out.println(numero); // Imprime cada elemento del Vector.
        }

        // Uso de HashSet
        Set<String> conjunto = new HashSet<>(); // Declara un conjunto HashSet para almacenar elementos de tipo String.
        conjunto.add("Rojo"); // Agrega el elemento "Rojo" al conjunto.
        conjunto.add("Verde"); // Agrega el elemento "Verde" al conjunto.
        conjunto.add("Azul"); // Agrega el elemento "Azul" al conjunto.

        System.out.println("\nElementos en el conjunto:"); // Imprime un mensaje de encabezado.
        for (String color : conjunto) { // Recorre cada elemento en el conjunto.
            System.out.println(color); // Imprime cada elemento del conjunto.
        }

        // Uso de HashMap
        Map<Integer, String> mapa = new HashMap<>(); // Declara un mapa HashMap para almacenar pares clave-valor (Integer, String).
        mapa.put(1, "Uno"); // Agrega la clave 1 y el valor "Uno" al mapa.
        mapa.put(2, "Dos"); // Agrega la clave 2 y el valor "Dos" al mapa.
        mapa.put(3, "Tres"); // Agrega la clave 3 y el valor "Tres" al mapa.

        System.out.println("\nElementos en el mapa:"); // Imprime un mensaje de encabezado.
        for (Map.Entry<Integer, String> entrada : mapa.entrySet()) { // Itera sobre las entradas (pares clave-valor) del mapa.
            System.out.println("Clave: " + entrada.getKey() + ", Valor: " + entrada.getValue()); // Imprime cada clave y su valor asociado.
        }

        // Uso de PriorityQueue
        Queue<String> cola = new PriorityQueue<>(); // Declara una cola con prioridad para almacenar elementos de tipo String.
        cola.add("Elemento 1"); // Agrega el elemento "Elemento 1" a la cola.
        cola.add("Elemento 2"); // Agrega el elemento "Elemento 2" a la cola.
        cola.add("Elemento 3"); // Agrega el elemento "Elemento 3" a la cola.

        System.out.println("\nElementos en la cola:"); // Imprime un mensaje de encabezado.
        while (!cola.isEmpty()) { // Mientras la cola no esté vacía...
            System.out.println(cola.poll()); // Retira y devuelve el elemento con la mayor prioridad (orden natural en este caso).
        }

        // Uso de LinkedList
        LinkedList<String> linkedList = new LinkedList<>(); // Declara una lista enlazada para almacenar elementos de tipo String.
        linkedList.add("Primero"); // Agrega el elemento "Primero" a la LinkedList.
        linkedList.add("Segundo"); // Agrega el elemento "Segundo" a la LinkedList.
        linkedList.add("Tercero"); // Agrega el elemento "Tercero" a la LinkedList.

        System.out.println("\nElementos en la LinkedList:"); // Imprime un mensaje de encabezado.
        for (String elemento : linkedList) { // Recorre cada elemento en la LinkedList.
            System.out.println(elemento); // Imprime cada elemento de la LinkedList.
        }
    }
}

/*
CONCLUSIONES:
1. Las diferentes clases de colecciones en Java proporcionan estructuras de datos flexibles y eficientes para manejar diferentes necesidades de almacenamiento y procesamiento de datos.
2. Las listas, conjuntos, mapas y colas tienen comportamientos únicos que las hacen útiles en contextos específicos, como evitar duplicados (HashSet) o mantener un orden de prioridad (PriorityQueue).
3. La selección adecuada de la colección depende de los requisitos específicos, como la necesidad de acceso rápido, ordenamiento, o la prevención de duplicados.

RECOMENDACIONES:
1. Utiliza colecciones genéricas (por ejemplo, List<String>) para evitar errores de tipo y mejorar la legibilidad del código.
2. Considera el rendimiento y las necesidades específicas al elegir una colección (ArrayList para acceso rápido, LinkedList para inserciones frecuentes, etc.).
3. Siempre utiliza bucles for-each o Streams para recorrer las colecciones cuando sea posible, ya que mejora la legibilidad y la simplicidad.

RESULTADOS:
1-¿Qué es una ArrayList?
Una ArrayList es una clase de la colección de Java que implementa la interfaz List. Es una lista dinámica que permite almacenar elementos de manera ordenada y acceder a ellos por su índice. Se redimensiona automáticamente al agregar o eliminar elementos.

2-¿Qué es un Vector?
Un Vector es similar a una ArrayList, pero es sincronizado, lo que lo hace seguro para operaciones en múltiples hilos. Sin embargo, su uso es menos común hoy en día debido a la existencia de colecciones más modernas.

3-¿Qué es un HashSet?
Un HashSet es una implementación de la interfaz Set. Almacena elementos de manera única (sin duplicados) y no garantiza un orden específico de los mismos. Utiliza un mecanismo basado en tablas hash para organizar los elementos.

4-¿Qué es un HashMap?
Un HashMap es una implementación de la interfaz Map que almacena pares clave-valor. Permite acceso rápido a los valores asociados a una clave y no garantiza un orden en las entradas.

5-¿Qué es una PriorityQueue?
Una PriorityQueue es una cola basada en prioridades. Los elementos se ordenan automáticamente según un criterio natural o un comparador definido, y se procesan en el orden de su prioridad (el más bajo o el más alto primero, según la implementación).

6-¿Cuál es la diferencia entre una List y un Set?
List: Permite elementos duplicados y mantiene un orden basado en el índice.
Set: No permite elementos duplicados y no garantiza un orden específico (excepto implementaciones como LinkedHashSet).

7-¿Cuál es la diferencia entre un Map y una Queue?
Map: Almacena pares clave-valor, donde cada clave debe ser única. No sigue un orden natural a menos que se use una implementación como TreeMap.
Queue: Es una estructura de datos lineal que sigue el principio FIFO (First In, First Out). Se utiliza para manejar datos en el orden en que se agregaron o según prioridades.

REFERENCIAS:
1. "Java™ Platform, Standard Edition Documentation" - https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html
2.- Prácticas de Programación Avanzada - ITID433, Facultad de Ingeniería Eléctrica y Electrónica. (Archivo adjunto: Práctica12.pdf)
*/