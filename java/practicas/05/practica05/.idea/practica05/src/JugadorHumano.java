public class JugadorHumano extends Jugador {
    public JugadorHumano(String nombre) {
        super(nombre);
    }

    // Implementación del cálculo de puntaje para el jugador humano
    @Override
    public int calcularPuntaje() {
        int puntaje = 0;
        int cantAs = 0;

        // Sumar los puntos de cada carta en la mano
        for (Carta21 carta : mano) {
            puntaje += carta.getPuntos();
            if (carta.getValor().equals("A")) {
                cantAs++;
            }
        }

        // Ajuste para Ases si el puntaje supera 21
        while (puntaje > 21 && cantAs > 0) {
            puntaje -= 10;
            cantAs--;
        }

        return puntaje;
    }
}
