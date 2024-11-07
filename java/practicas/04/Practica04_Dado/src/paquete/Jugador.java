package paquete;

public class Jugador {

    // Variables de instancia
    private String nombre;
    private Dado dadoAtaque;
    private Tipo tipoJugador;
    private int puntosVida;

    // Variables de clase para estadísticas
    private static int cantExitos = 0;
    private static int cantFallidos = 0;

    // Enumeración para el tipo de jugador
    public enum Tipo {
        FIGHTER(20), ARCHER(10), WIZARD(6);

        private final int caras;

        // Constructor de la enumeración
        Tipo(int caras) {
            this.caras = caras;
        }

        // Getter para el número de caras del dado
        public int getCaras() {
            return caras;
        }
    }

    // Constructor
    public Jugador(String nombre, Tipo tipoJugador, int puntosVida) {
        this.nombre = nombre;
        this.tipoJugador = tipoJugador;
        this.dadoAtaque = new Dado(tipoJugador.getCaras());
        this.puntosVida = puntosVida;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Método para realizar un ataque a otro jugador
    public int atacar(Jugador j) {
        int ataque = dadoAtaque.lanzar();
        System.out.println(nombre + " (" + tipoJugador + ") ataca a " + j.getNombre() + "! Lanzó un " + ataque);

        if (ataque >= 6) {
            j.recibirAtaque(getAtaque());
            cantExitos++;
            System.out.println(j.getNombre() + " recibió daño!");
        } else {
            cantFallidos++;
            System.out.println(nombre + " falló!");
        }
        return ataque;
    }

    // Método para recibir ataque
    public void recibirAtaque(int daño) {
        puntosVida -= daño;
        System.out.println(nombre + " recibe " + daño + " puntos de daño!");
    }

    // Método para verificar si el jugador está vivo
    public boolean estaVivo() {
        return puntosVida > 0;
    }

    // Método privado para obtener el daño de ataque según el tipo de jugador
    private int getAtaque() {
        switch(tipoJugador) {
            case FIGHTER:
                return 3;
            case ARCHER:
                return 2;
            case WIZARD:
                return 1;
            default:
                return 0;
        }
    }

    // Getters para estadísticas de ataques
    public static int getCantExitos() {
        return cantExitos;
    }

    public static int getCantFallidos() {
        return cantFallidos;
    }
}
