/*
//Practica12-Juego de cartas
 // Nombre: Alex Travez , Mateo Oviedo
 // Fecha de realizacion:22/01/2025
 // Fecha de entrega: 23/01/2025

 */

import java.util.Scanner; // Importa la clase Scanner para leer entradas del usuario.
import java.util.function.Function; // Importa la interfaz Function para trabajar con funciones lambda.

public class Main {
    private static Scanner lector = new Scanner(System.in); // Crea un objeto Scanner para leer datos del usuario.

    // Se crean barajas genéricas para cada tipo de carta.
    private static baraja<cartahechizo> barajaHechizos = new baraja<>();
    private static baraja<cartaCriatura> barajaCriaturas = new baraja<>();
    private static baraja<cartaTrampa> barajaTrampas = new baraja<>();

    public static void main(String[] args) {
        int opcion; // Variable para almacenar la opción seleccionada por el usuario.

        do {
            mostrarMenuPrincipal(); // Muestra el menú principal.
            opcion = leerOpcion(); // Lee la opción ingresada por el usuario.
            ejecutarOpcion(opcion); // Ejecuta la acción correspondiente a la opción seleccionada.
        } while (opcion != 0); // Repite el ciclo hasta que la opción sea salir (0).
    }

    private static void mostrarMenuPrincipal() {
        // Imprime el menú principal con las opciones disponibles.
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Gestionar Baraja");
        System.out.println("2. Jugar");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return lector.nextInt(); // Intenta leer un número entero.
        } catch (Exception e) {
            lector.next(); // Limpia la entrada inválida.
            System.out.println("Error: Debe ingresar un número entero.");
            return -1; // Retorna -1 para indicar un error en la entrada.
        }
    }

    private static void ejecutarOpcion(int opcion) {
        // Ejecuta la acción correspondiente a la opción seleccionada.
        switch (opcion) {
            case 1:
                gestionarBaraja(); // Llama al menú de gestión de barajas.
                break;
            case 2:
                jugar(); // Simula una partida.
                break;
            case 0:
                System.out.println("Saliendo del juego..."); // Mensaje de salida.
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo."); // Mensaje de error para opciones inválidas.
        }
    }

    private static void gestionarBaraja() {
        int opcion; // Variable para la opción seleccionada en el menú de gestión de barajas.

        do {
            mostrarMenuGestionBaraja(); // Muestra el menú de gestión de barajas.
            opcion = leerOpcion(); // Lee la opción ingresada por el usuario.
            ejecutarOpcionGestionBaraja(opcion); // Ejecuta la acción correspondiente.
        } while (opcion != 0); // Repite el ciclo hasta que la opción sea volver al menú principal (0).
    }

    private static void mostrarMenuGestionBaraja() {
        // Imprime el menú de gestión de barajas con las opciones disponibles.
        System.out.println("\n--- Gestión de Baraja ---");
        System.out.println("1. Agregar Carta Hechizo");
        System.out.println("2. Agregar Carta Criatura");
        System.out.println("3. Agregar Carta Trampa");
        System.out.println("4. Ver Cartas");
        System.out.println("0. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void ejecutarOpcionGestionBaraja(int opcion) {
        // Ejecuta la acción correspondiente a la opción seleccionada en el menú de gestión de barajas.
        switch (opcion) {
            case 1:
                agregarCarta(barajaHechizos, cartahechizo::new); // Agrega una carta de tipo Hechizo.
                break;
            case 2:
                agregarCarta(barajaCriaturas, cartaCriatura::new); // Agrega una carta de tipo Criatura.
                break;
            case 3:
                agregarCarta(barajaTrampas, cartaTrampa::new); // Agrega una carta de tipo Trampa.
                break;
            case 4:
                verCartas(); // Muestra las cartas de todas las barajas.
                break;
            case 0:
                System.out.println("Volviendo al menú principal..."); // Mensaje de retorno al menú principal.
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo."); // Mensaje de error para opciones inválidas.
        }
    }

    private static <T extends carta> void agregarCarta(baraja<T> baraja, Function<String, T> creadorDeCarta) {
        // Método genérico para agregar una carta a la baraja correspondiente.
        System.out.print("Ingrese el nombre de la carta: ");
        String nombre = lector.next(); // Lee el nombre de la carta ingresado por el usuario.
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío."); // Valida que el nombre no esté vacío.
            return;
        }
        baraja.agregarCarta(creadorDeCarta.apply(nombre)); // Crea y agrega la carta a la baraja.
        System.out.println("Carta agregada correctamente."); // Mensaje de confirmación.
    }

    private static <T extends carta> void mostrarCartas(String tipo, baraja<T> baraja) {
        // Muestra las cartas de un tipo específico en una baraja.
        System.out.println("\nCartas de " + tipo + ":");
        if (baraja.estaVacia()) {
            System.out.println("No hay cartas en esta baraja."); // Mensaje si la baraja está vacía.
        } else {
            baraja.mostrarCartas(); // Llama al método para mostrar las cartas.
        }
    }

    private static void verCartas() {
        // Muestra todas las cartas de las tres barajas.
        mostrarCartas("Hechizo", barajaHechizos);
        mostrarCartas("Criatura", barajaCriaturas);
        mostrarCartas("Trampa", barajaTrampas);
    }

    private static void jugar() {
        // Simula una partida entre las cartas de las tres barajas.
        System.out.println("\nSimulando una partida...");
        if (barajaHechizos.estaVacia() && barajaCriaturas.estaVacia() && barajaTrampas.estaVacia()) {
            System.out.println("No hay cartas en las barajas para jugar."); // Mensaje si no hay cartas para jugar.
        } else {
            System.out.println("Partida en progreso... ¡que gane el mejor!"); // Mensaje de simulación de partida.
        }
    }
}

/*
Conclusiones:
1. La implementación permite gestionar tres tipos de barajas (Hechizos, Criaturas y Trampas) de manera genérica y eficiente.
2. El uso de funciones genéricas y lambdas simplifica la creación y manejo de objetos en tiempo de ejecución.
3. La estructura del programa está diseñada para ser modular y fácil de mantener.

Recomendaciones:
1. Agregar validaciones adicionales para evitar nombres duplicados en las barajas.
2. Implementar un sistema de persistencia para guardar y cargar el estado de las barajas.
3. Mejorar la simulación de la partida para incluir reglas más detalladas y dinámicas.

Resultados:
1. El programa permite agregar, visualizar y gestionar cartas de manera interactiva.
2. La modularidad del diseño facilita la extensión para agregar nuevas funcionalidades.
3. El sistema de menús mejora la experiencia del usuario al interactuar con el programa.
*/
