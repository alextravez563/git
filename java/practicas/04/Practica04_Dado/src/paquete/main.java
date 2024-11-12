package paquete;

public class Main {
    public static void main(String[] args) {
        // Crear jugadores Aragorn y Legolas
        Jugador f1 = new Jugador("Aragorn", Jugador.Tipo.FIGHTER, 80);
        Jugador a1 = new Jugador("Legolas", Jugador.Tipo.ARCHER, 60);

        // Pelea entre los dos jugadores
        while (f1.estaVivo() && a1.estaVivo()) {
            f1.atacar(a1);
            if (a1.estaVivo()) {
                a1.atacar(f1);
            }
        }

        // Determinar el ganador
        if (f1.estaVivo()) {
            System.out.println(f1.getNombre() + " gana!");
        } else {
            System.out.println(a1.getNombre() + " gana!");
        }

        // Crear jugadores adicionales (tú y tu amigo)
        Jugador player1 = new Jugador("Danilo", Jugador.Tipo.WIZARD, 50);
        Jugador player2 = new Jugador("Compañero", Jugador.Tipo.FIGHTER, 50);

        // Enfrentamiento entre jugadores
        while (player1.estaVivo() && player2.estaVivo() && f1.estaVivo() && a1.estaVivo()) {
            player1.atacar(f1);
            if (f1.estaVivo()) {
                f1.atacar(player1);
            }
            player2.atacar(a1);
            if (a1.estaVivo()) {
                a1.atacar(player2);
            }
        }

        // Mostrar estadísticas de la pelea
        System.out.println("Número de dados creados: " + Dado.getNumDados());
        System.out.println("Cantidad de ataques exitosos: " + Jugador.getCantExitos());
        System.out.println("Cantidad de ataques fallidos: " + Jugador.getCantFallidos());
    }
}
