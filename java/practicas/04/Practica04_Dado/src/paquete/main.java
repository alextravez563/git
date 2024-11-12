//Practica04-Dado-Main
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:11/06/2024
// Fecha de entrega: 12/06/2024
//Resultados:
// El programa simula una pelea entre dos jugadores iniciales y luego otros dos jugadores adicionales, determinando el ganador de cada enfrentamiento basándose en las condiciones de vida de los personajes.
// Al final de la simulación, el programa muestra estadísticas de la batalla, como el número de dados creados, los ataques exitosos y los ataques fallidos, lo cual da una visión clara del desempeño de los jugadores en la batalla.
// El programa utiliza bucles para permitir que los personajes se ataquen mutuamente hasta que uno de ellos caiga (pierda toda su vida), lo que lo convierte en un ciclo dinámico de turnos.
//Conclusiones:
// El código está bien estructurado en clases, lo que facilita la simulación de combates entre distintos tipos de personajes, y permite la fácil adición de nuevas funcionalidades y personajes sin modificar la lógica principal.
// Se utiliza un bucle while para manejar la secuencia de ataques entre los jugadores, asegurando que el combate continúe hasta que uno de los personajes quede sin vida, lo que hace el flujo del juego claro y ordenado.
// El uso de estadísticas como el número de dados, ataques exitosos y fallidos proporciona una interesante forma de medir el rendimiento de los jugadores en la batalla. Esto es útil en simulaciones de juegos para entender los resultados de las acciones de los jugadores.
//Recomendaciones:
// Sería útil agregar habilidades o ataques especiales que se puedan utilizar en turnos específicos, lo que añadiría más estrategia y profundidad a los combates.
// El código podría mejorarse visualmente utilizando una interfaz gráfica para representar a los jugadores y los ataques, lo que haría el juego más atractivo y accesible para los usuarios.
// Aunque el código maneja los turnos y ataques de manera eficiente, sería recomendable agregar validaciones y manejo de errores para situaciones excepcionales, como cuando un jugador recibe más daño del que puede soportar o si los valores de vida llegan a ser negativos.
package paquete;

public class Main {
    public static void main(String[] args) {
        // Crear jugadores Aragorn y Legolas
        // Se crean dos instancias de jugadores con distintos tipos (FIGHTER y ARCHER) y puntos de vida iniciales
        Jugador f1 = new Jugador("Aragorn", Jugador.Tipo.FIGHTER, 80);
        Jugador a1 = new Jugador("Legolas", Jugador.Tipo.ARCHER, 60);

        // Pelea entre los dos jugadores hasta que uno de ellos quede sin vida
        // Utilizamos un bucle while que continúa mientras ambos jugadores estén vivos
        while (f1.estaVivo() && a1.estaVivo()) {
            f1.atacar(a1);  // Aragorn ataca primero
            if (a1.estaVivo()) {
                a1.atacar(f1);  // Si Legolas sigue vivo, contraataca
            }
        }

        // Al salir del bucle, determinamos quién es el ganador basado en quién sigue vivo
        if (f1.estaVivo()) {
            System.out.println(f1.getNombre() + " gana!");  // Aragorn gana
        } else {
            System.out.println(a1.getNombre() + " gana!");  // Legolas gana
        }

        // Crear jugadores adicionales para simular una nueva batalla
        // Aquí se añaden otros dos jugadores (tú y tu amigo) para un combate adicional
        Jugador player1 = new Jugador("Danilo", Jugador.Tipo.WIZARD, 50);
        Jugador player2 = new Jugador("Compañero", Jugador.Tipo.FIGHTER, 50);

        // Enfrentamiento entre jugadores adicionales y los anteriores
        while (player1.estaVivo() && player2.estaVivo() && f1.estaVivo() && a1.estaVivo()) {
            player1.atacar(f1);  // Danilo ataca a Aragorn
            if (f1.estaVivo()) {
                f1.atacar(player1);  // Aragorn responde si sigue vivo
            }
            player2.atacar(a1);  // Compañero ataca a Legolas
            if (a1.estaVivo()) {
                a1.atacar(player2);  // Legolas responde si sigue vivo
            }
        }

        // Mostrar estadísticas de la pelea al final del combate
        // Estas estadísticas incluyen la cantidad de dados creados y el número de ataques exitosos y fallidos
        System.out.println("Número de dados creados: " + Dado.getNumDados());
        System.out.println("Cantidad de ataques exitosos: " + Jugador.getCantExitos());
        System.out.println("Cantidad de ataques fallidos: " + Jugador.getCantFallidos());
    }
}
