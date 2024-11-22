// Practica06-Polimorfismo
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realización: 21/11/2024
// Fecha de entrega: 21/11/2024


/*
 * Resultados:
 * Resultado de consola:
 * Iniciando juego de 3 rondas
>>>>>>Ronda [1/3]
Al lanzar el Dado de 6 caras obtuviste un 4
Al lanzar el Dado Truncado de 6 caras con sesgo de 3 obtuviste un 4
Al lanzar el Dado Especial obtuviste un 6
Al lanzar el Dado Multiplicador de 6 caras con multiplicador de 0.25 obtuviste un 2
>>>>>>Ronda [2/3]
Al lanzar el Dado de 6 caras obtuviste un 3
Al lanzar el Dado Truncado de 6 caras con sesgo de 3 obtuviste un 5
Al lanzar el Dado Especial obtuviste un 6
Al lanzar el Dado Multiplicador de 6 caras con multiplicador de 0.25 obtuviste un 2
>>>>>>Ronda [3/3]
Al lanzar el Dado de 6 caras obtuviste un 1
Al lanzar el Dado Truncado de 6 caras con sesgo de 3 obtuviste un 4
Al lanzar el Dado Especial obtuviste un 6
Al lanzar el Dado Multiplicador de 6 caras con multiplicador de 0.25 obtuviste un 2

Iniciando juego de 4 jugadores y 5 rondas
--Jugador No. 1
Iniciando juego de 5 rondas
>>>>>>Ronda [1/5]
Al lanzar el Dado de 24 caras obtuviste un 12
Al lanzar el Dado Truncado de 12 caras con sesgo de 2 obtuviste un 8
Al lanzar el Dado Especial obtuviste un 6
Al lanzar el Dado Multiplicador de 6 caras con multiplicador de 1.0 obtuviste un 6
...
El ganador es el Jugador No. X con un puntaje de Y
* Como se puede observar, el programa imprime el resultado de cada lanzamiento
* de los dados en cada ronda y jugador, y al final imprime el ganador del juego.
* En el primer juego, se juegan 3 rondas con 1 jugador y en el segundo juego se
* juegan 5 rondas con 4 jugadores.
* En el primer juego, se utilizan 4 tipos de dados diferentes y en el segundo juego
* se utilizan otros 4 tipos de dados diferentes.
* En ambos juegos, se utilizan diferentes tipos de dados y se juegan diferentes
* cantidades de rondas y jugadores.
* En ambos juegos, se utiliza polimorfismo para simplificar la creación de diferentes
* tipos de dados y poder utilizarlos en un juego de dados.
* En el segundo juego, se utiliza sobrecarga de métodos para poder jugar diferentes
* cantidades de rondas y jugadores.
*
 *
 * Conclusiones:
 * Podemos concluir que el polimorfismo es una herramienta muy útil para
 * simplificar el código y hacerlo más mantenible. En este caso, se utilizó
 * polimorfismo para simplificar la creación de diferentes tipos de dados
 * y poder utilizarlos en un juego de dados. Además, se utilizó sobrecarga
 * de métodos para poder jugar diferentes cantidades de rondas y jugadores.
 *
 * Recomendaciones:
 * Se recomienda tener en cuenta el polimorfismo y la sobrecarga de métodos
 * para simplificar el código y hacerlo más mantenible. Además, se recomienda
 * utilizar comentarios y documentación para facilitar la comprensión del código.
 * También se recomienda utilizar nombres descriptivos para las variables y métodos
 * para facilitar la comprensión del código
 *
 */

// Bibliografía
// Diapositivas del docente
// https://www.w3schools.com/java/java_oop.asp
// https://www.w3schools.com/java/java_polymorphism.asp
// https://www.baeldung.com/java-collection-merge-overlapping-intervals

public class JuegoDeDados {
    private final Dado[] dados;

    public JuegoDeDados(Dado[] dados) {
        this.dados = dados;
    }

    private int jugar() {
        int total = 0;
        for (Dado dado : dados) {
            int resultado = dado.lanzar();
            System.out.println("Al lanzar el " + dado + " obtuviste un " + resultado);
            total += resultado;
        }
        return total;
    }

    // sobrecarga de jugar
    public int jugar(int rondas) {
        int puntaje = 0;
        System.out.println("Iniciando juego de " + rondas + " rondas");
        for (int i = 0; i < rondas; i++) {
            System.out.println(">>>>>>Ronda [" + (i + 1)  + "/" + rondas + "]");
            puntaje += jugar();
        }
        System.out.println();
        return puntaje;
    }

    public void jugar(int jugadores, int rondas) {
        int[] puntajes = new int[jugadores];
        for (int i = 0; i < jugadores; i++) {
            System.out.println("--Jugador No. " + (i + 1));
            puntajes[i] = jugar(rondas);
        }

        int ganador = 0;
        for (int i = 1; i < jugadores; i++) {
            if (puntajes[i] < puntajes[ganador]) {
                ganador = i;
            }
        }

        System.out.println("El ganador es el Jugador No. " + (ganador + 1) + " con un puntaje de " + puntajes[ganador]);
    }

    public static void main(String[] args) {
        Dado[] dados = {
                new Dado(6),
                new DadoTruncado(6, 3),
                new DadoEspecial(),
                new DadoMultiplicador(6, 0.25),
        };

        Dado[] dados2 = {
                new Dado(24),
                new DadoTruncado(12, 2),
                new DadoEspecial(),
                new DadoMultiplicador(6, 5),
        };
        JuegoDeDados juego = new JuegoDeDados(dados);
        JuegoDeDados juego2 = new JuegoDeDados(dados2);
        juego.jugar(3);
        juego2.jugar(4, 5);
    }
}
