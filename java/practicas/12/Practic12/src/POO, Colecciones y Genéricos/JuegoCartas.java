/*
//Practica12-POO GENERICOS Y COLECCIONES
 // Nombre: Alex Travez , Mateo Oviedo
 // Fecha de realizacion:22/01/2025
 // Fecha de entrega: 23/01/2025

 */
public class JuegoCartas {
    public static void main(String[] args) {
        // Crear barajas para cada tipo de carta
        Baraja<CartaHechizo> barajaHechizos = new Baraja<>(); // Baraja específica para cartas de hechizos.
        Baraja<CartaCriatura> barajaCriaturas = new Baraja<>(); // Baraja específica para cartas de criaturas.
        Baraja<CartaTrampa> barajaTrampas = new Baraja<>(); // Baraja específica para cartas de trampas.

        // Agregar cartas de hechizo
        barajaHechizos.agregarCarta(new CartaHechizo("Bola de Fuego")); // Se añade una carta de tipo hechizo.
        barajaHechizos.agregarCarta(new CartaHechizo("Tormenta")); // Se añade otra carta de tipo hechizo.

        // Agregar cartas de criatura
        barajaCriaturas.agregarCarta(new CartaCriatura("Dragón")); // Se añade una carta de tipo criatura.
        barajaCriaturas.agregarCarta(new CartaCriatura("Unicornio")); // Se añade otra carta de tipo criatura.

        // Agregar cartas de trampa
        barajaTrampas.agregarCarta(new CartaTrampa("Trampa Explosiva")); // Se añade una carta de tipo trampa.
        barajaTrampas.agregarCarta(new CartaTrampa("Trampa de Veneno")); // Se añade otra carta de tipo trampa.

        // Mostrar cartas de cada tipo
        System.out.println("Cartas de Hechizo:"); // Encabezado para las cartas de hechizo.
        barajaHechizos.mostrarCartas(); // Muestra todas las cartas de hechizo de la baraja.

        System.out.println("\nCartas de Criatura:"); // Encabezado para las cartas de criatura.
        barajaCriaturas.mostrarCartas(); // Muestra todas las cartas de criatura de la baraja.

        System.out.println("\nCartas de Trampa:"); // Encabezado para las cartas de trampa.
        barajaTrampas.mostrarCartas(); // Muestra todas las cartas de trampa de la baraja.

        // Conclusiones:
        // 1. El uso de generics permite manejar diferentes tipos de cartas de manera segura y flexible.
        // 2. La arquitectura orientada a objetos facilita la extensión del código, como añadir nuevos tipos de cartas.
        // 3. Los métodos generales en las clases permiten reducir redundancia y mantener un diseño limpio.

        // Recomendaciones:
        // 1. Utilizar try-catch si se espera manejar excepciones al trabajar con las cartas o barajas.
        // 2. Implementar métodos adicionales para buscar, eliminar o actualizar cartas en la baraja.
        // 3. Añadir validaciones para evitar duplicados o inconsistencias en las barajas.

        // Resultados:
        // 1. ¿Qué es una clase abstracta y cómo se utiliza en este código?
        //Una clase abstracta es una clase que no puede instanciarse directamente y sirve como una plantilla para otras clases. En el código, la clase Carta es abstracta, lo que significa que no se pueden crear objetos directamente de esta clase. Sin embargo, las subclases como CartaHechizo, CartaCriatura y CartaTrampa heredan de ella y deben implementar cualquier comportamiento definido o heredado.
        // 2. ¿Cómo se están utilizando los genéricos en la clase Baraja?
        //Los genéricos se están utilizando para que la clase Baraja pueda almacenar objetos de diferentes tipos de cartas (CartaHechizo, CartaCriatura, CartaTrampa) sin necesidad de crear una clase separada para cada uno. Esto se logra con el parámetro genérico <T>.
        //3.¿Qué es el polimorfismo y cómo se ejemplifica en este código?
        //El polimorfismo es un principio de la programación orientada a objetos que permite tratar objetos de diferentes tipos de forma uniforme a través de una referencia común, como una clase base o una interfaz. Esto se logra mediante la sobrescritura de métodos.
        //En este código, el polimorfismo se ejemplifica con el método toString() de la clase base

        /*referencias
        1-- Prácticas de Programación Avanzada - ITID433, Facultad de Ingeniería Eléctrica y Electrónica. (Archivo adjunto: Práctica12.pdf)
         */
}