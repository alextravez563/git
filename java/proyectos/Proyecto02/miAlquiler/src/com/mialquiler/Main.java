/*
//Proyecto2-Mialquiler
 // Nombre: Alex Travez , Mateo Oviedo
 // Fecha de realizacion:2/01/2025
 // Fecha de entrega: 3/01/2025

 */


// Declaración del paquete al que pertenece la clase Main.
package com.mialquiler;

// Importaciones de clases necesarias para el funcionamiento del programa.
import com.mialquiler.models.Cliente;
import com.mialquiler.models.Reserva;
import com.mialquiler.models.Vehiculo;
import com.mialquiler.servicios.GestorClientes;
import com.mialquiler.servicios.GestorReservas;
import com.mialquiler.servicios.GestorVehiculos;
import com.mialquiler.models.AgenciaAlquiler;
import com.mialquiler.models.VehiculoOcupadoException;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

// Clase principal del programa que contiene el método main.
public class Main {
    // Instancias de los gestores de clientes, vehículos y reservas.
    private static final GestorClientes gestorClientes = new GestorClientes();
    private static final GestorVehiculos gestorVehiculos = new GestorVehiculos();
    private static final GestorReservas gestorReservas = new GestorReservas();
    // Scanner para leer la entrada del usuario.
    private static final Scanner scanner = new Scanner(System.in);

    // Método principal que inicia la ejecución del programa.
    public static void main(String[] args) {
        int opcion;
        do {
            // Muestra el menú principal y lee la opción seleccionada por el usuario.
            mostrarMenuPrincipal();
            opcion = leerEntero("Seleccione una opción: ");
            // Switch para manejar las diferentes opciones del menú.
            switch (opcion) {
                case 1 -> gestionarClientes(); // Gestionar clientes.
                case 2 -> gestionarVehiculos(); // Gestionar vehículos.
                case 3 -> gestionarReservas(); // Gestionar reservas.
                case 0 -> System.out.println("¡Gracias por usar MiAlquiler de Alex Travez y Mateo Oviedo! Que tenga un lindo dia , lo esperamos de nuevo :) ."); // Salir del programa.
                default -> System.out.println("Opción no válida. Intente de nuevo."); // Opción no válida.
            }
        } while (opcion != 0); // Repite el menú hasta que el usuario seleccione la opción de salir.
    }

    // Método para mostrar el menú principal con gráficos ASCII.
    private static void mostrarMenuPrincipal() {
        System.out.println("\n===== Sistema de Alquiler de Vehículos de Alex Travez y Mateo Oviedo  =====");
        System.out.println("1. Gestión de Clientes");
        System.out.println("    .---.         ");
        System.out.println("   ( 0 0 )        ");
        System.out.println(" --|     |-- Cliente");
        System.out.println("   |  >  |        ");
        System.out.println("   '-----'        ");
        System.out.println("  -||    ||-        ");

        System.out.println("2. Gestión de Vehículos");
        System.out.println("   ______            ");
        System.out.println("  /|_||_\\`.__       ");
        System.out.println(" (   _    _ _\\      Vehículo");
        System.out.println(" =`-(_)--(_)-'      ");

        System.out.println("3. Gestión de Reservas");
        System.out.println("   _________      ");
        System.out.println("  |         |     ");
        System.out.println("  |  NOTAS  | Reserva");
        System.out.println("  |_________|     ");
        System.out.println("   (_______)      ");

        System.out.println("0. Salir");
    }

    // Método para gestionar las operaciones relacionadas con los clientes.
    private static void gestionarClientes() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Eliminar Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("0. Volver al Menú Principal");
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> agregarCliente(); // Agregar un nuevo cliente.
                case 2 -> eliminarCliente(); // Eliminar un cliente existente.
                case 3 -> listarClientes(); // Listar todos los clientes.
                case 0 -> System.out.println("Volviendo al menú principal..."); // Volver al menú principal.
                default -> System.out.println("Opción no válida. Intente de nuevo y escoja la opcion adecuada ."); // Opción no válida.
            }
        } while (opcion != 0); // Repite el menú de gestión de clientes hasta que el usuario seleccione volver.
    }

    // Método para agregar un nuevo cliente.
    private static void agregarCliente() {
        System.out.println("\n--- Agregar Cliente ---");
        String id = leerCadena("Ingrese el ID del cliente: ");
        String nombre = leerCadena("Ingrese el nombre del cliente: ");
        String telefono = leerCadena("Ingrese el teléfono del cliente: ");
        gestorClientes.agregarCliente(new Cliente(id, nombre, telefono));
        System.out.println("Cliente agregado exitosamente al sistema .");
    }

    // Método para eliminar un cliente existente.
    private static void eliminarCliente() {
        System.out.println("\n--- Eliminar Cliente ---");
        String id = leerCadena("Ingrese el ID del cliente a eliminar: ");
        gestorClientes.eliminarCliente(id);
    }

    // Método para listar todos los clientes registrados.
    private static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        List<Cliente> clientes = gestorClientes.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el sistema .");
        } else {
            clientes.forEach(System.out::println);
        }
    }

    // Método para gestionar las operaciones relacionadas con los vehículos.
    private static void gestionarVehiculos() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Vehículos ---");
            System.out.println("1. Agregar Vehículo");
            System.out.println("2. Eliminar Vehículo");
            System.out.println("3. Listar Vehículos Disponibles");
            System.out.println("0. Volver al Menú Principal");
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> agregarVehiculo(); // Agregar un nuevo vehículo.
                case 2 -> eliminarVehiculo(); // Eliminar un vehículo existente.
                case 3 -> listarVehiculosDisponibles(); // Listar vehículos disponibles.
                case 0 -> System.out.println("Volviendo al menú principal..."); // Volver al menú principal.
                default -> System.out.println("Opción no válida. Intente de nuevo."); // Opción no válida.
            }
        } while (opcion != 0); // Repite el menú de gestión de vehículos hasta que el usuario seleccione volver.
    }

    // Método para agregar un nuevo vehículo.
    private static void agregarVehiculo() {
        System.out.println("\n--- Agregar Vehículo ---");
        String matricula = leerCadena("Ingrese la matrícula: ");
        String modelo = leerCadena("Ingrese el modelo: ");
        String tipo = leerCadena("Ingrese el tipo (Auto, Camioneta, Motocicleta): ");
        gestorVehiculos.agregarVehiculo(new Vehiculo(matricula, modelo, tipo, true));
        System.out.println("Vehículo agregado exitosamente en el sistema .");
    }

    // Método para eliminar un vehículo existente.
    private static void eliminarVehiculo() {
        System.out.println("\n--- Eliminar Vehículo ---");
        String matricula = leerCadena("Ingrese la matrícula del vehículo a eliminar: ");
        gestorVehiculos.eliminarVehiculo(matricula);
    }

    // Método para listar todos los vehículos disponibles.
    private static void listarVehiculosDisponibles() {
        System.out.println("\n--- Vehículos Disponibles ---");
        List<Vehiculo> vehiculos = gestorVehiculos.listarVehiculosDisponibles();
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos disponibles dentro del sistema.");
        } else {
            vehiculos.forEach(System.out::println);
        }
    }

    // Método para gestionar las operaciones relacionadas con las reservas.
    private static void gestionarReservas() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Reservas ---");
            System.out.println("1. Crear Reserva");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Listar Reservas");
            System.out.println("0. Volver al Menú Principal");
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> crearReserva(); // Crear una nueva reserva.
                case 2 -> cancelarReserva(); // Cancelar una reserva existente.
                case 3 -> listarReservas(); // Listar todas las reservas.
                case 0 -> System.out.println("Volviendo al menú principal..."); // Volver al menú principal.
                default -> System.out.println("Opción no válida. Intente de nuevo."); // Opción no válida.
            }
        } while (opcion != 0); // Repite el menú de gestión de reservas hasta que el usuario seleccione volver.
    }

    // Método para crear una nueva reserva.
    private static void crearReserva() {
        System.out.println("\n--- Crear Reserva ---");
        String idReserva = leerCadena("Ingrese el ID de la reserva: ");
        String idCliente = leerCadena("Ingrese el ID del cliente: ");
        Cliente cliente = gestorClientes.buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        String matricula = leerCadena("Ingrese la matrícula del vehículo: ");
        Vehiculo vehiculo = gestorVehiculos.buscarVehiculo(matricula);
        if (vehiculo == null || !vehiculo.isDisponible()) {
            System.out.println("Vehículo no disponible o no encontrado.");
            return;
        }

        LocalDate fechaInicio = leerFecha("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        LocalDate fechaFin = leerFecha("Ingrese la fecha de fin (YYYY-MM-DD): ");

        gestorReservas.agregarReserva(new Reserva(idReserva, cliente, vehiculo, fechaInicio, fechaFin));
        System.out.println("Reserva creada exitosamente.");
    }

    // Método para cancelar una reserva existente.
    private static void cancelarReserva() {
        System.out.println("\n--- Cancelar Reserva ---");
        String idReserva = leerCadena("Ingrese el ID de la reserva a cancelar: ");
        gestorReservas.cancelarReserva(idReserva);
    }

    // Método para listar todas las reservas.
    private static void listarReservas() {
        System.out.println("\n--- Lista de Reservas ---");
        List<Reserva> reservas = gestorReservas.listarReservas();
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            reservas.forEach(System.out::println);
        }
    }

    // Método para leer un entero desde la entrada del usuario.
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada no válida. " + mensaje);
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Método para leer una cadena desde la entrada del usuario.
    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    // Método para leer una fecha desde la entrada del usuario.
    private static LocalDate leerFecha(String mensaje) {
        System.out.print(mensaje);
        return LocalDate.parse(scanner.next());
    }
}
/*
    CONCLUSIONES:
    1. El programa implementa un sistema de alquiler de vehículos con funcionalidades completas, incluyendo la gestión de clientes, vehículos y reservas.
    2. Utiliza programación orientada a objetos para modularizar el código y facilitar su mantenimiento y escalabilidad.
    3. La inclusión de gráficos ASCII mejora la interfaz de usuario en consola y hace el sistema más intuitivo.

    RECOMENDACIONES:
    1. Mejorar la gestión de excepciones para manejar mejor los errores y evitar posibles fallos en la ejecución.
    2. Implementar persistencia de datos con una base de datos para almacenar la información a largo plazo.
    3. Expandir el sistema con una interfaz gráfica o una API REST para mayor accesibilidad y usabilidad.

    RESULTADOS:
    1. El usuario puede gestionar clientes, vehículos y reservas a través de un menú interactivo enriquecido con gráficos ASCII.
    2. Se pueden agregar, eliminar y listar clientes, vehículos y reservas de manera sencilla y visualmente atractiva.
    3. El sistema valida correctamente los datos de entrada, asegurando un flujo de trabajo correcto y eficiente.

    BIBLIOGRAFIA :
   1-  •	Bloch, J. (2017). Effective Java. Addison-Wesley.
   2-  •	PlantUML. (2023). PlantUML Documentation. Recuper- ado de https://plantuml.com/
   3- Analisis y clases de diseño, Lenguaje UML (Material de clase, presentado por David Mejia)[Consultado: 1-February-2025].

    */