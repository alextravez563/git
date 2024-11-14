// Practica04-Persona
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realización: 13/06/2024
// Fecha de entrega: 14/06/2024

//Resultados:
// Se aplicaron los conceptos de herencia y polimorfismo mediante clases y métodos para representar una baraja y el puntaje en el juego de 21. Las clases Carta, Carta21, Jugador, y JugadorHumano permiten el uso de métodos heredados y la especialización de atributos y comportamientos.
// El método jugar() implementa la lógica completa del juego, desde la interacción con el usuario (para recibir una carta) hasta la determinación del ganador. Esto permite una experiencia de juego realista y clara, cumpliendo con los objetivos de aplicar lógica condicional y repetitiva en Java.
//Las clases están estructuradas de forma modular, lo que facilita la reutilización y la escalabilidad del código. La Baraja se mezcla con el método barajar() y puede repartir cartas con repartirCarta(), cumpliendo así los objetivos de abstracción y encapsulamiento.

//Conclusiones:
//  El uso de herencia y composición permite una estructura de código que es fácil de mantener y extender. Las clases base y derivadas facilitan la adición de nuevas características en futuras expansiones del juego.
// El código maneja correctamente los valores especiales de las cartas (como el As en el juego de 21) y usa una clase anidada (CartaEspecial) para el Joker, mostrando cómo aplicar métodos y ajustes específicos dentro de una jerarquía de clases.
// La implementación maneja condiciones de límite como los puntajes mayores a 21 y ofrece la posibilidad de continuar jugando mediante el bucle do-while, mejorando la experiencia del usuario y mostrando control sobre el flujo del programa.

//Recomendaciones:
// Aunque se ha manejado la entrada del usuario en formato de texto (sí o no), sería útil agregar validaciones para entradas inesperadas o no válidas para evitar posibles errores de entrada durante la interacción en el juego.
// Si se desea agregar otras cartas especiales, podría ser útil permitir que CartaEspecial reciba valores y familias personalizados en su constructor, en lugar de valores fijos, para hacer la clase más flexible.
// Se recomienda documentar cada método clave y manejar posibles excepciones, como al convertir valores de cartas a enteros, lo que hará el código más seguro y legible, especialmente en entornos de producción o cuando se amplíe el juego.
// Bibliografía
// Diapositivas del docente

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// Clase Carta21 que hereda de Carta - Para cartas en el juego 21 con puntaje específico
class Carta21 extends Carta {
    public Carta21(String familia, String valor) {
        super(familia, valor);
    }

    // Método para obtener el puntaje de cada carta en el juego 21
    public int getPuntos() {
        switch (getValor()) {
            case "A":
                return 11;
            case "J":
            case "Q":
            case "K":
                return 10;
            default:
                return Integer.parseInt(getValor());
        }
    }
}

// Clase abstracta Jugador - Representa un jugador en el juego 21
abstract class Jugador {
    protected String nombre;       // Nombre del jugador
    protected List<Carta21> mano;  // Lista de cartas que tiene el jugador en su mano

    // Constructor que inicializa el nombre y la mano del jugador
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    // Getter para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Método para agregar una carta a la mano del jugador
    public void agregarCartaMano(Carta21 carta) {
        mano.add(carta);
    }

    // Método abstracto para calcular el puntaje del jugador
    public abstract int calcularPuntaje();

    // Método para mostrar la mano del jugador
    public void mostrarMano() {
        for (Carta21 carta : mano) {
            System.out.println(carta);
        }
    }
}

// Clase JugadorHumano que extiende de Jugador - Implementa cálculo de puntaje para el jugador humano
class JugadorHumano extends Jugador {
    public JugadorHumano(String nombre) {
        super(nombre);
    }

    // Cálculo del puntaje del jugador, ajustando por los Ases para no superar 21 puntos
    @Override
    public int calcularPuntaje() {
        int puntaje = 0;
        int cantAs = 0;

        for (Carta21 carta : mano) {
            puntaje += carta.getPuntos();
            if (carta.getValor().equals("A")) {
                cantAs++;
            }
        }

        // Ajuste del puntaje para los Ases si el puntaje supera 21
        while (puntaje > 21 && cantAs > 0) {
            puntaje -= 10;
            cantAs--;
        }

        return puntaje;
    }
}

// Interfaz Repartidor - Define los métodos para mezclar y repartir cartas
interface Repartidor {
    void barajar();        // Mezcla las cartas
    Carta21 repartirCarta(); // Reparte una carta del mazo
}

// Clase Baraja que implementa Repartidor - Maneja el mazo de cartas del juego
class Baraja implements Repartidor {
    private Stack<Carta21> mazo; // Mazo de cartas

    // Constructor que inicializa el mazo con 52 cartas
    public Baraja() {
        mazo = new Stack<>();
        String[] familias = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String familia : familias) {
            for (String valor : valores) {
                mazo.push(new Carta21(familia, valor));
            }
        }
    }

    // Método para barajar el mazo
    @Override
    public void barajar() {
        Collections.shuffle(mazo);
    }

    // Método para repartir una carta del mazo
    @Override
    public Carta21 repartirCarta() {
        return mazo.pop();
    }

    // Clase anidada CartaEspecial para cartas especiales como el Joker
    public static class CartaEspecial extends Carta21 {
        public CartaEspecial() {
            super("Especial", "Joker");
        }

        @Override
        public int getPuntos() {
            return 0;
        }
    }
}

// Clase Juego21 - Contiene la lógica principal del juego
public class Juego21 {
    private Baraja baraja;
    private JugadorHumano jugador;
    private JugadorHumano juez;

    // Constructor que inicializa el juego con el jugador y el juez
    public Juego21(String nombreJugador) {
        baraja = new Baraja();
        baraja.barajar();
        jugador = new JugadorHumano(nombreJugador);
        juez = new JugadorHumano("Juez");
    }

    // Método para jugar el juego
    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        // Repartir cartas iniciales al jugador y al juez
        jugador.agregarCartaMano(baraja.repartirCarta());
        jugador.agregarCartaMano(baraja.repartirCarta());
        juez.agregarCartaMano(baraja.repartirCarta());
        juez.agregarCartaMano(baraja.repartirCarta());

        // Mostrar la mano y puntaje del jugador
        System.out.println("Mano del jugador:");
        jugador.mostrarMano();
        System.out.println("Puntaje del jugador: " + jugador.calcularPuntaje());

        // Preguntar al jugador si desea otra carta
        String respuesta;
        do {
            System.out.print("¿Quieres otra carta? (sí/no): ");
            respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("sí")) {
                jugador.agregarCartaMano(baraja.repartirCarta());
                System.out.println("Mano del jugador:");
                jugador.mostrarMano();
                System.out.println("Puntaje del jugador: " + jugador.calcularPuntaje());
            }
        } while (respuesta.equals("sí") && jugador.calcularPuntaje() <= 21);

        // El juez toma cartas hasta tener al menos 17 puntos
        while (juez.calcularPuntaje() < 17) {
            juez.agregarCartaMano(baraja.repartirCarta());
        }

        // Mostrar la mano y puntaje del juez
        System.out.println("\nMano del juez:");
        juez.mostrarMano();
        System.out.println("Puntaje del juez: " + juez.calcularPuntaje());

        // Determinar el ganador
        determinarGanador();
    }

    // Método para determinar el ganador del juego
    private void determinarGanador() {
        int puntajeJugador = jugador.calcularPuntaje();
        int puntajeJuez = juez.calcularPuntaje();

        System.out.println("\n--- Resultado ---");
        if (puntajeJugador > 21) {
            System.out.println("Te has pasado de 21. El juez gana!");
        } else if (puntajeJuez > 21) {
            System.out.println("El juez se ha pasado de 21. " + jugador.getNombre() + " gana!");
        } else if (puntajeJugador > puntajeJuez) {
            System.out.println(jugador.getNombre() + " gana!");
        } else if (puntajeJuez > puntajeJugador) {
            System.out.println("El juez gana!");
        } else {
            System.out.println("Empate!");
        }
    }

    // Método principal para iniciar el juego y preguntar si desea jugar nuevamente
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            System.out.print("Ingresa tu nombre: ");
            String nombreJugador = scanner.nextLine();

            Juego21 juego = new Juego21(nombreJugador);
            juego.jugar();

            // Preguntar si desea jugar de nuevo
            System.out.print("¿Quieres jugar otra vez? (sí/no): ");
            respuesta = scanner.nextLine().toLowerCase();

        } while (respuesta.equals("sí"));

        System.out.println("Gracias por jugar!");
        scanner.close();
    }
}
