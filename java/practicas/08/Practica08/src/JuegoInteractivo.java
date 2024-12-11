import java.io.IOException;
import java.util.Scanner;

/**
 //Practica08
 // Nombre: Alex Travez , Mateo Oviedo
 // Fecha de realizacion:11/12/2024
 // Fecha de entrega: 12/12/2024

 * Resultados:
 * 1. El programa permite guardar y cargar correctamente el estado del juego.
 * 2. La interacción a través del menú es fluida y fácil de entender.
 * 3. El manejo de jugadores humanos y PC se realiza sin problemas.
 * 4. La funcionalidad de iniciar el juego distribuye las cartas y calcula el puntaje correctamente.
 * 5. La estructura modular facilita la depuración y la adición de nuevas características.
 *
 * Conclusiones:
 * 1. Validar las entradas del usuario es crucial para evitar errores inesperados.
 * 2. La serialización en Java es una herramienta poderosa para la persistencia de objetos.
 * 3. Separar las responsabilidades en clases mejora la organización del código.
 * 4. Un diseño modular permite una fácil ampliación del programa.
 * 5. Proporcionar mensajes claros mejora la experiencia del usuario.
 *
 * Recomendaciones:
 * 1. Implementar un manejo de excepciones más detallado para escenarios específicos.
 * 2. Añadir validaciones para evitar la duplicación de jugadores.
 * 3. Considerar una interfaz gráfica para mejorar la interacción con el usuario.
 * 4. Probar exhaustivamente el programa para garantizar su robustez.
 * 5. Documentar claramente cada clase y método para facilitar el mantenimiento del código.
 */


/**
 * Clase JuegoInteractivo permite gestionar el juego mediante un menú interactivo.
 * Esta clase presenta un menú en consola para agregar jugadores, iniciar el juego,
 * guardar y cargar el estado del juego, y salir del programa.
 */
public class JuegoInteractivo {

    // Nombre del archivo donde se guarda el estado del juego
    private static final String FILE_NAME = "juego.dat";

    // Scanner para recibir la entrada del usuario
    private static Scanner lector = new Scanner(System.in);

    // Objeto Juego que gestiona el estado del juego
    private static Juego juego = new Juego();

    /**
     * Método principal que presenta el menú del juego.
     * Este método ejecuta un bucle infinito que permite al usuario interactuar con el menú
     * hasta que decida salir.
     */
    public static void main(String[] args) {
        while (true) { // Bucle infinito para mostrar el menú hasta que se seleccione la opción de salir
            // Presenta las opciones del menú
            System.out.println("1. Agregar Jugador Humano");
            System.out.println("2. Agregar Jugador PC");
            System.out.println("3. Iniciar Juego");
            System.out.println("4. Guardar Juego");
            System.out.println("5. Cargar Juego");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = lector.nextInt(); // Lee la opción seleccionada por el usuario

            // Evalúa la opción seleccionada y ejecuta la acción correspondiente
            switch (opcion) {
                case 1: // Agregar un jugador humano
                    agregarJugadorHumano();
                    break;
                case 2: // Agregar un jugador controlado por PC
                    agregarJugadorPC();
                    break;
                case 3: // Iniciar el juego
                    juego.iniciar();
                    break;
                case 4: // Guardar el estado actual del juego
                    guardarJuego();
                    break;
                case 5: // Cargar un juego guardado previamente
                    cargarJuego();
                    break;
                case 6: // Salir del programa
                    System.exit(0);
                    break;
                default: // Manejo de opciones no válidas
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            System.out.println(); // Línea en blanco para mejorar la legibilidad del menú
        }
    }

    /**
     * Solicita al usuario el nombre y agrega un jugador humano al juego.
     */
    private static void agregarJugadorHumano() {
        System.out.print("Ingrese el nombre del jugador humano: "); // Solicita el nombre del jugador
        String nombre = lector.next(); // Lee el nombre ingresado
        juego.agregarJugador(new JugadorHumano(nombre)); // Crea un nuevo jugador humano y lo agrega al juego
    }

    /**
     * Solicita al usuario el nombre y agrega un jugador controlado por PC al juego.
     */
    private static void agregarJugadorPC() {
        System.out.print("Ingrese el nombre del jugador PC: "); // Solicita el nombre del jugador PC
        String nombre = lector.next(); // Lee el nombre ingresado
        juego.agregarJugador(new JugadorPC(nombre)); // Crea un nuevo jugador PC y lo agrega al juego
    }

    /**
     * Guarda el estado actual del juego en un archivo.
     * Utiliza la clase Guardar para realizar la serialización del objeto Juego.
     */
    private static void guardarJuego() {
        try {
            Guardar.guardarJuego(juego); // Llama al método de guardado en la clase Guardar
            System.out.println("Juego guardado exitosamente."); // Confirma que el guardado fue exitoso
        } catch (IOException e) {
            // Maneja errores de entrada/salida durante el proceso de guardado
            System.out.println("Error al guardar el juego: " + e.getMessage());
        }
    }

    /**
     * Carga el estado del juego desde un archivo.
     * Utiliza la clase Guardar para realizar la deserialización del objeto Juego.
     */
    private static void cargarJuego() {
        try {
            juego = Guardar.cargarJuego(); // Llama al método de carga en la clase Guardar
            System.out.println("Juego cargado exitosamente."); // Confirma que la carga fue exitosa
        } catch (IOException | ClassNotFoundException e) {
            // Maneja errores de entrada/salida o problemas con la clase al cargar el juego
            System.out.println("Error al cargar el juego: " + e.getMessage());
        }
    }
}

