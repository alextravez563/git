//Practica04-Persona-Main
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:11/06/2024
// Fecha de entrega: 12/06/2024

//Resultados:
// El código permite cambiar los atributos de los objetos de la clase Persona usando los métodos setNombre y setEdad, actualizando los datos de las personas en tiempo real.
// El código muestra cuántas instancias de la clase Persona se han creado usando el método estático getContadorPersonas(), permitiendo al usuario saber cuántas personas están registradas en el programa.
// El código ilustra cómo al asignar un objeto (p1) a otra variable (q), ambos hacen referencia al mismo objeto en memoria, lo que implica que un cambio en uno afecta al otro.
//conclusiones:
// El programa hace uso de setters con validación (por ejemplo, para la edad) que garantiza que los valores asignados a los atributos sean correctos, previniendo datos inválidos como edades negativas.
// El código demuestra cómo las variables que apuntan a objetos en Java son referencias. Al asignar un objeto a una nueva variable (como q = p1), cualquier cambio en uno de los objetos afecta al otro.
// El uso de una variable estática para contar cuántas instancias de la clase Persona se crean es útil en aplicaciones donde es necesario mantener el control sobre cuántos objetos existen en un momento dado.
//Recomendaciones:
// Para evitar que los objetos compartan la misma referencia, se recomienda implementar un método que clone correctamente los objetos en lugar de asignarlos directamente, permitiendo que ambos sean independientes.
// Aunque la validación de la edad es un buen inicio, sería útil añadir también validaciones para el nombre (por ejemplo, evitar nombres vacíos o demasiado cortos).
// En lugar de imprimir mensajes en la consola cuando se cometen errores (como una edad negativa), se podría mejorar el manejo de errores utilizando excepciones o validaciones más formales para proporcionar retroalimentación detallada.
package paquete;

public class Main {
    public static void main(String[] args) {
        // Crear objetos de la clase Persona
        Persona p1 = new Persona("Alicia", 20);  // Persona con nombre Alicia y edad 20
        Persona p2 = new Persona("Juan", 15);    // Persona con nombre Juan y edad 15

        // Usar métodos de instancia para mostrar la información de las personas
        p1.mostrarInfo();  // Muestra: Nombre: Alicia, Edad: 20
        p2.mostrarInfo();  // Muestra: Nombre: Juan, Edad: 15

        // Modificar valores usando setters
        p1.setNombre("Alice");  // Cambia el nombre de Alicia a Alice
        p1.setEdad(31);         // Cambia la edad a 31

        // Mostrar información actualizada de p1
        p1.mostrarInfo();  // Muestra: Nombre: Alice, Edad: 31

        // Usar método de clase para mostrar el número total de personas creadas
        System.out.println("Número de personas creadas: " + Persona.getContadorPersonas());  // Muestra el contador

        // Crear más objetos y modificar datos
        Persona p3 = new Persona("Danilo", 25);  // Persona con nombre Danilo y edad 25
        Persona p4 = new Persona("Mateo", 30);   // Persona con nombre Mateo y edad 30

        p3.setEdad(-1);  // Intenta establecer una edad negativa, mostrará un mensaje de error
        p4.setEdad(0);   // Establece la edad de Mateo en 0

        p3.mostrarInfo();  // Muestra la información de Danilo, edad no cambia si es negativa
        p4.mostrarInfo();  // Muestra: Nombre: Mateo, Edad: 0

        // Clonar objeto p1 en q y cambiar nombre
        Persona q = p1;  // Se asigna p1 a q, pero q y p1 son la misma referencia
        q.setNombre("Adriana");  // Cambia el nombre en q (y también en p1)

        // Mostrar información de q y p1 para verificar que ambos apuntan al mismo objeto
        q.mostrarInfo();  // Muestra: Nombre: Adriana, Edad: 31
        p1.mostrarInfo();  // Muestra lo mismo, ya que p1 y q son referencias al mismo objeto
    }
}
