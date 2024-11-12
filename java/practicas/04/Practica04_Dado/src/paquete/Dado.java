//Practica04-Dado
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:11/06/2024
// Fecha de entrega: 12/06/2024
//Resultados:
// El dado genera valores aleatorios dentro del rango de sus caras, lo que añade una componente de azar en los resultados de los ataques.
// El sistema cuenta cuántos dados han sido instanciados durante la ejecución, lo que permite un seguimiento del número de dados utilizados en el juego.
// El dado puede tener diferente número de lados, lo que está directamente relacionado con el tipo de jugador, permitiendo ajustar la probabilidad de ataque exitoso según las características de cada jugador.
//Conclusiones:
// La aleatoriedad que aporta el dado es esencial en el desarrollo del combate, ya que determina el éxito o fracaso de los ataques. Esto agrega un factor impredecible que obliga a los jugadores a adaptarse en tiempo real.
//El código mantiene un conteo estático del número de dados creados, lo que es útil para tener un control preciso sobre los objetos instanciados en el sistema sin necesidad de rastrear cada uno individualmente.
//El diseño de la clase Dado es simple pero efectivo, permitiendo que sea adaptable a diferentes situaciones de combate. Su personalización por número de caras lo hace flexible y reutilizable en distintas mecánicas de juego.
//Recomendaciones:
// Es recomendable incluir validaciones en el constructor para evitar crear dados con un número no válido de lados, como valores negativos o igual a cero.
// Para mejorar la legibilidad del código, se podría agregar comentarios adicionales que expliquen más a fondo cómo funciona la aleatoriedad del dado y su impacto en el juego.
 //Considerar agregar más funcionalidades al dado, como tener varios tipos de dados con propiedades especiales, por ejemplo, un dado que permita repetir el lanzamiento si el resultado es bajo.

package paquete;
public class Dado {

    // Variables de instancia
    private int numLados;  // Almacena el número de lados del dado, que determina los posibles resultados de un lanzamiento

    // Variable de clase para contar el número de dados creados
    private static int numDados = 0;  // Se incrementa con cada dado instanciado

    // Constructor
    public Dado(int numLados) {
        this.numLados = numLados;  // Inicializa el dado con el número de lados especificado
        numDados++;  // Incrementa el contador de dados creados
    }

    // Método para lanzar el dado
    public int lanzar() {
        // Genera un número aleatorio entre 1 y el número de lados del dado
        return (int) (Math.random() * numLados) + 1;
    }

    // Getter para obtener el número de lados del dado
    public int getNumLados() {
        return numLados;
    }

    // Getter para obtener el número de dados creados
    public static int getNumDados() {
        return numDados;
    }
}
