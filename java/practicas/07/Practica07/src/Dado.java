//Practica07
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:4/12/2024
// Fecha de entrega: 5/12/2024
//Resultados:
//1) Caso 1: Ingresar un nombre vacío
//Al presionar ENTER sin escribir un nombre, se lanzó correctamente la excepción DatosInvalidosException con el mensaje: "El nombre no puede estar vacío."
//El programa no se detuvo, solicitó nuevamente el nombre, lo que demuestra que el manejo de excepciones permite al usuario corregir errores sin finalizar el juego.

//2) Caso 2: Usar un número negativo para las caras del dado
//Al intentar crear un dado con -1 caras, el constructor lanzó la excepción IllegalArgumentException con el mensaje: "Un dado debe tener al menos 4 caras."
//Este comportamiento previene la creación de objetos inválidos, garantizando que el juego funcione correctamente desde el inicio.

//3) Caso 3: Usar un número en la respuesta de continuar jugando
//Cuando se ingresó un número (por ejemplo, "10") en lugar de "si" o "no", se lanzó una excepción IOException con el mensaje: "Respuesta no válida. Debe ser 'si' o 'no'."
//El programa solicitó nuevamente la respuesta, lo que demuestra una gestión efectiva de las entradas incorrectas.

//4) Caso 4: Ingresar una apuesta no numérica
//Al ingresar texto en lugar de un número (por ejemplo, "abc"), se lanzó una excepción InputMismatchException con el mensaje: "El valor debe ser un número entero."
//El buffer del Scanner se limpió correctamente, y el programa solicitó de nuevo la apuesta.

//5)Caso 5: Mensaje de finalización de ronda
//Independientemente de los errores ocurridos durante cada ronda, el mensaje "Fin de la ronda" se imprimió siempre al final gracias al bloque finally. Esto asegura una comunicación clara con el usuario sobre el estado del programa.

public class Dado {
    private int caras; // Atributo que almacena el número de caras del dado.

    // Constructor que inicializa el número de caras del dado.
    // Si el valor ingresado es menor a 4, lanza una excepción de tipo IllegalArgumentException.
    public Dado(int caras) {
        if (caras < 4) { // Validación de reglas para un dado válido.
            throw new IllegalArgumentException("Un dado debe tener al menos 4 caras.");
        }
        this.caras = caras;
    }

    // Método para simular el lanzamiento del dado.
    // Devuelve un número aleatorio entre 1 y el número de caras del dado.
    public int lanzar() {
        return (int) (Math.random() * caras) + 1; // Generación de un valor aleatorio.
    }
    /*
    Explicación:
    Atributo caras: Se usa para almacenar la cantidad de caras del dado. Es privado para proteger su acceso y modificarlo únicamente mediante el constructor.
    Constructor:
    Asegura que el dado siempre tenga al menos 4 caras.
    Si no cumple la condición, se lanza una excepción que detiene el programa con un mensaje claro. Esto previene errores posteriores al usar dados inválidos.
    Método lanzar:
    Genera un número aleatorio entre 1 y el número de caras del dado usando Math.random.
    Este método se invocará cada vez que el dado sea lanzado en el juego.
    /*
     */

//conclusiones :
// El uso de excepciones personalizadas como DatosInvalidosException permitió manejar de manera clara y específica los errores relacionados con las entradas del usuario. Esto mejoró la legibilidad del código y facilitó la identificación de los problemas.
// Gracias a los bloques try-catch, el programa puede continuar funcionando incluso cuando ocurren errores en tiempo de ejecución. Este diseño asegura una experiencia de usuario fluida y sin interrupciones inesperadas.
// La combinación de excepciones estándar (como IllegalArgumentException e InputMismatchException) y personalizadas (DatosInvalidosException) permite un manejo eficiente y estructurado de errores específicos y generales. Esto mejora la flexibilidad del código y su adaptabilidad a otros escenarios.
// El uso del bucle while con manejo de excepciones en cada iteración asegura que el juego sea dinámico y controlado, permitiendo al usuario corregir errores sin interrumpir la experiencia de juego. Este enfoque hace que la aplicación sea más amigable y robusta.


 //Recomendaciones:
 //Para mejorar la experiencia del usuario, se podría realizar una validación previa de las entradas antes de procesarlas. Por ejemplo, mostrar mensajes preventivos que expliquen qué tipo de datos se esperan, evitando lanzar excepciones innecesariamente.
 //Sería útil proporcionar mensajes de error más detallados, que incluyan ejemplos de entradas válidas. Por ejemplo, en lugar de "El valor debe ser un número entero", podría decir://"El valor debe ser un número entero positivo, por ejemplo: 10."
 // Se recomienda implementar pruebas unitarias (por ejemplo, usando JUnit en Java) para validar cada método individualmente, especialmente los que involucran excepciones. Esto asegurará que cada componente del programa maneje errores correctamente antes de integrarse.
// Para evitar que el usuario cometa el mismo error varias veces consecutivas (como entradas vacías o apuestas no válidas), se podría implementar un contador de errores o sugerencias adicionales después de cierto número de intentos fallidos. Esto evitaría frustraciones y mejoraría la interacción.


 //Bibliografia:
    //[1] Práctica07.pdf – Documento con las instrucciones y detalles de implementación de la práctica de excepciones, incluyendo ejemplos y casos de prueba específicos.
    //[2] Oracle. (n.d.). The Java™ Tutorials - Exceptions.
    //Disponible en: https://docs.oracle.com/javase/tutorial/essential/exceptions/
    //Explica en detalle la jerarquía de excepciones en Java, el uso de try-catch-finally, y cómo crear excepciones personalizadas.
    //[3] Sierra, K., & Bates, B. (2008). Head First Java (2nd Edition). O'Reilly Media.
    //Este libro cubre conceptos clave de programación en Java, incluidos excepciones, manejo de errores y diseño robusto de programas.
}
