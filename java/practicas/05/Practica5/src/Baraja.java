// Practica05-Carta21
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realización: 14/06/2024
// Fecha de entrega: 14/06/2024
/*
 * Resultados:
 * La clase permite mezclar y gestionar un mazo completo de cartas para el juego.
 *
 * Conclusiones:
 * Baraja es capaz de repartir cartas aleatorias, evitando que se repitan durante el juego.
 *
 * Recomendaciones:
 * Asegurarse de barajar el mazo correctamente antes de iniciar el juego para evitar patrones.
 */
// Bibliografía
// Diapositivas del docente
// Baraja.java

import java.util.Collections;
import java.util.Stack;

// Clase Baraja que implementa Repartidor y maneja la baraja de cartas
public class Baraja implements Repartidor {
    private Stack<Carta21> mazo; // Pila de cartas

    // Constructor que inicializa el mazo con las 52 cartas
    public Baraja() {
        mazo = new Stack<>();
        String[] familias = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // Crea todas las combinaciones de cartas y las agrega al mazo
        for (String familia : familias) {
            for (String valor : valores) {
                mazo.push(new Carta21(familia, valor));
            }
        }
    }

    // Método para mezclar el mazo usando Collections.shuffle
    @Override
    public void barajar() {
        Collections.shuffle(mazo);
    }

    // Método para repartir una carta usando pop() en la pila mazo
    @Override
    public Carta21 repartirCarta() {
        return mazo.pop();
    }

    // Clase anidada estática que representa una carta especial (Joker)
    public static class CartaEspecial extends Carta21 {
        // Constructor que crea un Joker con valor "Especial" y 0 puntos
        public CartaEspecial() {
            super("Especial", "Joker");
        }

        // Método que siempre retorna 0 puntos para el Joker
        @Override
        public int getPuntos() {
            return 0;
        }
    }
}
