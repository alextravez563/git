import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JuegoDeDados {
    private Dado dado; // Objeto dado que se utilizará en el juego.

    // Constructor que inicializa el dado con un número de caras especificado.
    public JuegoDeDados(int caras) {
        this.dado = new Dado(caras); // Se crea un dado con el número de caras dado.
    }

    // Método para pedir el nombre del usuario.
    // Si el usuario no ingresa un nombre, lanza una excepción personalizada.
    private String pedirNombre(Scanner lector) throws DatosInvalidosException {
        System.out.println("Ingresa tu nombre:");
        String nombre = lector.nextLine();
        if (nombre.isEmpty()) { // Verifica si el nombre está vacío.
            throw new DatosInvalidosException("El nombre no puede estar vacío."); // Lanza la excepción personalizada.
        }
        return nombre; // Devuelve el nombre ingresado.
    }

    // Método para pedir la apuesta del usuario.
    // Lanza excepciones si el valor no es un número entero o es menor o igual a 0.
    private int pedirApuesta(Scanner lector) throws DatosInvalidosException, InputMismatchException {
        System.out.println("Ingresa tu apuesta (número entero):");
        if (!lector.hasNextInt()) { // Verifica si el siguiente valor es un entero.
            lector.nextLine(); // Limpia el buffer del Scanner.
            throw new InputMismatchException("El valor debe ser un número entero."); // Lanza excepción por tipo incorrecto.
        }
        int apuesta = lector.nextInt();
        lector.nextLine(); // Limpia el buffer después de leer un número.
        if (apuesta <= 0) { // Verifica si la apuesta es válida.
            throw new DatosInvalidosException("La apuesta debe ser un número positivo."); // Lanza la excepción personalizada.
        }
        return apuesta; // Devuelve la apuesta válida.
    }

    // Método para preguntar si el usuario quiere repetir el juego.
    // Lanza una excepción si la respuesta no es 'si' o 'no'.
    private boolean pedirRepetir(Scanner lector) throws IOException {
        System.out.println("¿Quieres jugar otra vez? (si/no):");
        String respuesta = lector.nextLine(); // Lee la respuesta del usuario.
        if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
            throw new IOException("Respuesta no válida. Debe ser 'si' o 'no'."); // Lanza excepción por respuesta inválida.
        }
        return respuesta.equalsIgnoreCase("si"); // Devuelve true si la respuesta es "si".
    }

    // Método principal del juego.
    public void jugar() {
        Scanner lector = new Scanner(System.in); // Scanner para leer entradas del usuario.
        boolean seguirJugando = true;

        while (seguirJugando) { // Repite el juego mientras el usuario desee seguir jugando.
            try {
                String nombre = pedirNombre(lector); // Pide el nombre del jugador.
                int apuesta = pedirApuesta(lector); // Pide la apuesta del jugador.
                System.out.println("Lanzando el dado...");
                int resultado = dado.lanzar(); // Lanza el dado y obtiene un resultado.
                System.out.println(nombre + " obtuvo un " + resultado);
                System.out.println(nombre + " apostó " + apuesta);
                if (apuesta == resultado) { // Compara la apuesta con el resultado.
                    System.out.println("¡Adivinaste!");
                } else {
                    System.out.println("¡Perdiste!");
                }
                seguirJugando = pedirRepetir(lector); // Pregunta si el usuario quiere jugar otra vez.
            } catch (DatosInvalidosException | InputMismatchException | IOException e) {
                // Captura excepciones específicas y muestra un mensaje de error.
                System.err.println("Error: " + e.getMessage());
                lector.nextLine(); // Limpia el buffer en caso de error.
            } catch (Exception e) {
                // Captura excepciones inesperadas.
                System.err.println("Ha ocurrido un error inesperado: " + e.getMessage());
            } finally {
                // Se ejecuta siempre, incluso si ocurre una excepción.
                System.out.println("Fin de la ronda");
            }
        }
        lector.close(); // Cierra el Scanner para liberar recursos.
    }
    /*
    Explicación:
Scanner: Se utiliza para recibir entradas del usuario.
Validaciones: Cada método (pedirNombre, pedirApuesta, pedirRepetir) incluye validaciones específicas que aseguran datos válidos.
Manejo de excepciones: Se implementa un try-catch-finally para capturar errores:
Específicos: Usamos varios catch para errores particulares (como entradas inválidas).
Genéricos: Capturamos errores inesperados para evitar que el programa falle abruptamente.
Bucle: El bucle while controla las rondas del juego y termina cuando el usuario indica que no quiere continuar.
     */
}
