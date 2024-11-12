//Practica04-Persona
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:11/06/2024
// Fecha de entrega: 12/06/2024
//Resultados:
// El programa lleva un contador de cuántas instancias de la clase Persona se han creado, lo que permite conocer cuántas personas han sido registradas durante la ejecución.
// El método setEdad incluye una validación para asegurarse de que la edad no sea negativa, lo que previene datos incorrectos en el sistema.
//El método mostrarInfo permite mostrar fácilmente el nombre y la edad de la persona, proporcionando una forma rápida de obtener los datos de cada instancia.
//conclusiones:
// Los métodos getNombre, getEdad y mostrarInfo facilitan el acceso y la visualización de los atributos de una persona, lo que es útil para sistemas que gestionan datos personales.
// Al validar la edad antes de asignarla, el código previene valores negativos no deseados, lo que garantiza una mayor integridad de los datos en el sistema.
// El uso de la variable estática contadorPersonas permite mantener un registro de todas las instancias creadas de la clase Persona, lo que es útil para estadísticas o gestión de usuarios.
//Recomendaciones:
// Aunque la edad no puede ser negativa, se podría añadir una validación adicional para evitar que se introduzcan valores excesivamente altos (por ejemplo, edades mayores de 150 años).
// Se podrían añadir más atributos (como dirección, género, etc.) y métodos para ampliar la funcionalidad de la clase Persona, haciéndola más completa para aplicaciones reales.
// En lugar de simplemente imprimir un mensaje de error en la consola cuando la edad es negativa, se podría lanzar una excepción o utilizar algún mecanismo más avanzado de manejo de errores para mejorar la robustez del sistema.

package paquete;
public class Persona {

    // Variables de instancia que representan los atributos de una persona
    private String nombre;  // Almacena el nombre de la persona
    private int edad;       // Almacena la edad de la persona

    // Variable de clase para contar cuántas instancias de Persona se han creado
    private static int contadorPersonas = 0;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;  // Asigna el nombre a la variable de instancia
        this.edad = edad;      // Asigna la edad a la variable de instancia
        contadorPersonas++;    // Incrementa el contador de personas cada vez que se crea una instancia
    }

    // Getter para obtener el nombre de la persona
    public String getNombre() {
        return nombre;
    }

    // Setter para modificar el nombre de la persona
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para obtener la edad de la persona
    public int getEdad() {
        return edad;
    }

    // Setter para modificar la edad de la persona, con una validación para evitar valores negativos
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;  // Solo asigna la edad si es positiva
        } else {
            System.out.println("La edad no puede ser negativa.");  // Muestra un mensaje si la edad es negativa
        }
    }

    // Método que imprime la información de la persona
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);  // Imprime el nombre y la edad
    }

    // Getter estático para obtener el número total de personas creadas
    public static int getContadorPersonas() {
        return contadorPersonas;
    }
}
