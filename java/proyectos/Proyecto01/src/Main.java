public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego("Jugador 1", "Jugador 2");
        juego.repartirCartas();
        juego.jugar();
    }
}