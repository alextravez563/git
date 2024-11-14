// Practica05-Jugador
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realización: 14/06/2024
// Fecha de entrega: 14/06/2024
/*
 * Resultados:
 * La clase define los atributos y métodos comunes para cualquier jugador en el juego.
 *
 * Conclusiones:
 * Esta clase establece una base para subclases que representarán jugadores específicos.
 *
 * Recomendaciones:
 * Verificar que las subclases implementen adecuadamente el método calcularPuntaje().
 */
// Bibliografía
// Diapositivas del docente

// Jugador.java

import java.util.ArrayList;
import java.util.List;

// Clase abstracta Jugador que representa un jugador en el juego
public abstract class Jugador {
    // Atributos protegidos de la clase
    protected String nombre;        // Nombre del jugador
    protected List<Carta21> mano;   // Lista de cartas en la mano del jugador

    // Constructor que inicializa el nombre del jugador y su mano
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    // Método getter para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Método para agregar una carta a la mano del jugador
    public void agregarCartaMano(Carta21 carta) {
        mano.add(carta);
    }

    // Método abstracto que calculará el puntaje de la mano (debe ser implementado por las subclases)
    public abstract int calcularPuntaje();

    // Método para mostrar todas las cartas en la mano del jugador
    public void mostrarMano() {
        for (Carta21 carta : mano) {
            System.out.println(carta); // Imprime cada carta usando su método toString()
        }
    }
}
