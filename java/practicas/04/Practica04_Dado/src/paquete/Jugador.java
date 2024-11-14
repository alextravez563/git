//Practica04-Jugador
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:11/06/2024
// Fecha de entrega: 12/06/2024
//Resultados:
//Cada tipo de jugador (luchador, arquero, mago) tiene una fuerza de ataque distinta, lo que influye directamente en las posibilidades de éxito y el daño infligido en cada turno de ataque.
//La probabilidad de éxito en los ataques está basada en el lanzamiento de un dado cuyas caras dependen del tipo de jugador. Los luchadores tienen más posibilidades de infligir daño debido a su dado de 20 caras, mientras que los magos solo tienen un dado de 6 caras.
//El código mantiene un registro global de las estadísticas de combate, como la cantidad de ataques exitosos y fallidos, permitiendo tener una visión general del desempeño de los jugadores durante múltiples batallas.
//Conclusiones:
//Los diferentes tipos de jugadores (FIGHTER, ARCHER, WIZARD) proporcionan distintos estilos de juego, donde los luchadores tienen más probabilidad de éxito en sus ataques y los magos tienen menos, pero cada tipo equilibra el combate de forma estratégica.
//El uso de dados personalizados para cada tipo de jugador agrega un elemento de azar que debe ser considerado en la estrategia de combate. Un luchador puede fallar menos, pero un arquero o mago puede necesitar más precisión para ser efectivo.
//El sistema de puntos de vida y daño está bien diseñado, ya que el daño recibido disminuye la vida de los jugadores de manera coherente con el tipo de ataque, lo que asegura una experiencia de combate equilibrada y realista.
//Recomendaciones:
//Se podría añadir habilidades especiales para cada tipo de jugador que se activen bajo ciertas condiciones, por ejemplo, que los magos tengan la capacidad de realizar ataques mágicos críticos o que los luchadores puedan realizar ataques múltiples en un solo turno.
//Sería útil agregar controles adicionales para gestionar posibles errores, como un jugador que intente atacar cuando ya está muerto, o valores negativos de vida que podrían causar comportamientos indeseados.
//Una vez que un jugador gana un combate, podría recibir puntos de experiencia que le permitan subir de nivel, mejorar su ataque o aumentar su salud, añadiendo una capa de progresión y evolución a los personajes.

package paquete;

public class Jugador {

    // Variables de instancia
    private String nombre;
    private Dado dadoAtaque;  // Cada jugador tiene su propio dado de ataque
    private Tipo tipoJugador;  // Enum que define el tipo de jugador
    private int puntosVida;    // Vida actual del jugador

    // Variables de clase para estadísticas globales de la partida
    private static int cantExitos = 0;  // Cuenta ataques exitosos globalmente
    private static int cantFallidos = 0;  // Cuenta ataques fallidos globalmente

    // Enumeración que define los tipos de jugador y las caras de su dado
    public enum Tipo {
        FIGHTER(20), ARCHER(10), WIZARD(6);  // Los luchadores tienen un dado de 20 caras, arqueros 10, magos 6

        private final int caras;  // Caras del dado del jugador

        // Constructor del enum que asigna el número de caras
        Tipo(int caras) {
            this.caras = caras;
        }

        // Getter que devuelve el número de caras del dado para ese tipo de jugador
        public int getCaras() {
            return caras;
        }
    }

    // Constructor de la clase Jugador que inicializa el nombre, tipo de jugador y puntos de vida
    public Jugador(String nombre, Tipo tipoJugador, int puntosVida) {
        this.nombre = nombre;
        this.tipoJugador = tipoJugador;
        this.dadoAtaque = new Dado(tipoJugador.getCaras());  // Se le asigna un dado según su tipo
        this.puntosVida = puntosVida;
    }

    // Método para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Método para que un jugador ataque a otro
    public int atacar(Jugador j) {
        int ataque = dadoAtaque.lanzar();  // Se lanza el dado para determinar el resultado del ataque
        System.out.println(nombre + " (" + tipoJugador + ") ataca a " + j.getNombre() + "! Lanzó un " + ataque);

        if (ataque >= 6) {  // Si el ataque es mayor o igual a 6, es exitoso
            j.recibirAtaque(getAtaque());  // El jugador atacado recibe el daño
            cantExitos++;  // Se incrementa la cantidad de ataques exitosos
            System.out.println(j.getNombre() + " recibió daño!");
        } else {
            cantFallidos++;  // Si el ataque es menor a 6, se cuenta como fallido
            System.out.println(nombre + " falló!");
        }
        return ataque;
    }

    // Método para recibir el daño de un ataque
    public void recibirAtaque(int daño) {
        puntosVida -= daño;  // Se resta el daño de los puntos de vida del jugador
        System.out.println(nombre + " recibe " + daño + " puntos de daño!");
    }

    // Método que verifica si el jugador sigue vivo
    public boolean estaVivo() {
        return puntosVida > 0;  // El jugador está vivo si tiene más de 0 puntos de vida
    }

    // Método privado que determina el daño de ataque dependiendo del tipo de jugador
    private int getAtaque() {
        switch(tipoJugador) {
            case FIGHTER:
                return 3;  // Los luchadores hacen 3 puntos de daño
            case ARCHER:
                return 2;  // Los arqueros hacen 2 puntos de daño
            case WIZARD:
                return 1;  // Los magos hacen 1 punto de daño
            default:
                return 0;
        }
    }

    // Getters estáticos para obtener las estadísticas globales de ataques exitosos y fallidos
    public static int getCantExitos() {
        return cantExitos;
    }

    public static int getCantFallidos() {
        return cantFallidos;
    }
}
