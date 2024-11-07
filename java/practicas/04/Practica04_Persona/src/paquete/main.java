package paquete;

public class main {
    public static void main(String[] args) {
        // Crear objetos de la clase Persona
        Persona p1 = new Persona("Alicia", 20);
        Persona p2 = new Persona("Juan", 15);

        // Usar métodos de instancia
        p1.mostrarInfo();
        p2.mostrarInfo();

        // Modificar valores usando setters
        p1.setNombre("Alice");
        p1.setEdad(31);

        // Mostrar información actualizada
        p1.mostrarInfo();

        // Usar método de clase
        System.out.println("Número de personas creadas: " + Persona.getContadorPersonas());

        // Crear más objetos y modificar datos
        Persona p3 = new Persona("Danilo", 25);
        Persona p4 = new Persona("Compañero", 30);

        p3.setEdad(-1);  // Edad negativa
        p4.setEdad(0);   // Edad en cero

        p3.mostrarInfo();
        p4.mostrarInfo();

        // Clonar objeto p1 en q y cambiar nombre
        Persona q = p1;
        q.setNombre("Adriana");

        // Mostrar información de q y p1 para verificar el cambio
        q.mostrarInfo();
        p1.mostrarInfo();
    }
}
