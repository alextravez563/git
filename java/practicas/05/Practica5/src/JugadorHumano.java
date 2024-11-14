// Practica05-Jugador Humano
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realización: 14/06/2024
// Fecha de entrega: 14/06/2024

// JugadorHumano.java
// Clase JugadorHumano que extiende Jugador y define el cálculo del puntaje
public class JugadorHumano extends Jugador {
    // Constructor que llama al constructor de la superclase Jugador
    public JugadorHumano(String nombre) {
        super(nombre);
    }

    // Método para calcular el puntaje de la mano del jugador
    @Override
    public int calcularPuntaje() {
        int puntaje = 0;
        int cantAs = 0;

        // Recorre la mano del jugador y suma los puntos de cada carta
        for (Carta21 carta : mano) {
            puntaje += carta.getPuntos();
            if (carta.getValor().equals("A")) {
                cantAs++; // Cuenta la cantidad de As en la mano
            }
        }

        // Si el puntaje supera 21 y hay As, resta 10 puntos por cada As hasta estar dentro de 21
        while (puntaje > 21 && cantAs > 0) {
            puntaje -= 10;
            cantAs--;
        }

        return puntaje; // Retorna el puntaje final
    }
}
