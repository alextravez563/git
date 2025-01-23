import java.util.*;
// Importa las clases necesarias para trabajar con colecciones en Java, como ArrayList, Vector, HashSet, HashMap y PriorityQueue.

public class ColeccionesEjemplo {
    public static void main(String[] args) {
        // Uso de ArrayList: una lista dinámica que permite almacenar elementos en orden de inserción.
        List<String> lista = new ArrayList<>(); // Declara una lista que almacenará cadenas de texto (String).
        lista.add("Manzana"); // Agrega "Manzana" a la lista.
        lista.add("Banana");  // Agrega "Banana" a la lista.
        lista.add("Cereza");  // Agrega "Cereza" a la lista.

        System.out.println("Elementos en la lista:");
        for (String fruta : lista) { // Itera sobre cada elemento de la lista.
            System.out.println(fruta); // Imprime cada fruta en la consola.
        }
        // Resultado esperado: Manzana, Banana, Cereza.

        // Uso de Vector: una lista sincronizada que permite acceso seguro en entornos multihilo.
        Vector<Integer> vector = new Vector<>(); // Declara un vector que almacenará números enteros (Integer).
        vector.add(10); // Agrega 10 al vector.
        vector.add(20); // Agrega 20 al vector.
        vector.add(30); // Agrega 30 al vector.

        System.out.println("\nElementos en el vector:");
        for (Integer numero : vector) { // Itera sobre cada número en el vector.
            System.out.println(numero); // Imprime cada número en la consola.
        }
        // Resultado esperado: 10, 20, 30.

        // Uso de HashSet: una colección que almacena elementos únicos sin garantizar el orden.
        Set<String> conjunto = new HashSet<>(); // Declara un conjunto que almacenará cadenas de texto (String).
        conjunto.add("Rojo"); // Agrega "Rojo" al conjunto.
        conjunto.add("Verde"); // Agrega "Verde" al conjunto.
        conjunto.add("Azul");  // Agrega "Azul" al conjunto.

        System.out.println("\nElementos en el conjunto:");
        for (String color : conjunto) { // Itera sobre cada color en el conjunto.
            System.out.println(color); // Imprime cada color en la consola.
        }
        // Resultado esperado: Los colores pueden imprimirse en cualquier orden, por ejemplo, Azul, Rojo, Verde.

        // Uso de HashMap: un mapa que almacena pares clave-valor.
        Map<Integer, String> mapa = new HashMap<>(); // Declara un mapa que asocia claves enteras con valores de texto.
        mapa.put(1, "Uno"); // Asocia la clave 1 con el valor "Uno".
        mapa.put(2, "Dos"); // Asocia la clave 2 con el valor "Dos".
        mapa.put(3, "Tres"); // Asocia la clave 3 con el valor "Tres".

        System.out.println("\nElementos en el mapa:");
        for (Map.Entry<Integer, String> entrada : mapa.entrySet()) { // Itera sobre cada entrada clave-valor en el mapa.
            System.out.println("Clave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
            // Imprime la clave y el valor asociados.
        }
        // Resultado esperado: Clave y valor se imprimen en cualquier orden, por ejemplo:
        // Clave: 1, Valor: Uno
        // Clave: 2, Valor: Dos
        // Clave: 3, Valor: Tres.

        // Uso de PriorityQueue: una cola que prioriza los elementos según su orden natural o un comparador.
        Queue<String> cola = new PriorityQueue<>(); // Declara una cola que almacenará cadenas de texto.
        cola.add("Elemento 1"); // Agrega "Elemento 1" a la cola.
        cola.add("Elemento 2"); // Agrega "Elemento 2" a la cola.
        cola.add("Elemento 3"); // Agrega "Elemento 3" a la cola.

        System.out.println("\nElementos en la cola:");
        while (!cola.isEmpty()) { // Mientras la cola no esté vacía.
            System.out.println(cola.poll()); // Extrae e imprime el elemento con mayor prioridad (el más pequeño).
        }
        // Resultado esperado: Los elementos se imprimen en orden alfabético, por ejemplo:
        // Elemento 1
        // Elemento 2
        // Elemento 3
    }
}
