public class Main {
    public static void main(String[] args) {
        // Crear perros
        Perro p1 = new Perro("P001", "Peluche", 11, "Shih Tzu");
        Perro p2 = new Perro("P002", "Pelusa", 2, "Doberman");
        Perro p3 = new Perro("P003", "Toy", 1, "Mestizo");
        Perro p4 = new Perro("P004", "Rex", 1, "Schnauzer");
        Perro p5 = new Perro("P005", "Mordelon", 2, "Samoyedo");

        // Crear entrenadores
        EntreJunior e1 = new EntreJunior(1, "1234567890", "Juan", "Pérez", "Grupo Molestosos");
        EntreSenior e2 = new EntreSenior(2, "0987654321", "María", "Gómez", "Grupo Pequeños", "Jefe1");
        EntreElite e3 = new EntreElite(3, "1122334455", "Carlos", "López", 11);

        // Asignar perros a entrenadores
        e1.agregarPerro(p4);
        e1.agregarPerro(p2);
        e2.agregarPerro(p1);
        e3.agregarPerro(p3);
        e3.agregarPerro(p5);

        // Administrar entrenadores
        AdminEntrenadores admin = new AdminEntrenadores();
        admin.agregarEntrenador(e1);
        admin.agregarEntrenador(e2);
        admin.agregarEntrenador(e3);

        // Presentar información
        System.out.println(admin.presentarInfo());
    }
}
