// Interfaz Repartidor que define el comportamiento de una baraja de cartas
public interface Repartidor {
    // Método para mezclar las cartas de la baraja
    void barajar();

    // Método para repartir una carta, devolviendo un objeto Carta21
    Carta21 repartirCarta();
}

