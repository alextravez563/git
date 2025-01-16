import java.util.*;

/*
//Practica11
 // Nombre: Alex Travez , Mateo Oviedo
 // Fecha de realizacion:15/01/2025
 // Fecha de entrega: 16/01/2025

 */

public class Main {
    public static void main(String[] args) {
        // Crear sistema de gestión de vacaciones
        SistemaGestionVacaciones sistema = new SistemaGestionVacaciones(); // Instancia el sistema que gestionará vacaciones, empleados y departamentos.

        // Crear jefe y departamento
        Jefe jefe = new Jefe("Carlos Pérez", 1, null); // Crea un jefe para el departamento (sin departamento asignado inicialmente).
        Departamento departamento = new Departamento("Recursos Humanos", jefe); // Crea el departamento "Recursos Humanos" y asigna al jefe.

        // Crear empleados
        Funcionario empleado1 = new Funcionario("Ana Gómez", 2, departamento); // Crea un funcionario (empleado que puede pedir días prestados).
        Contratado empleado2 = new Contratado("Luis Martínez", 3, departamento); // Crea un empleado contratado (sin derecho a días prestados).

        // Asignar empleados al departamento
        departamento.asignarEmpleado(empleado1); // Asigna al empleado Ana Gómez al departamento.
        departamento.asignarEmpleado(empleado2); // Asigna al empleado Luis Martínez al departamento.

        // Agregar departamento al sistema
        sistema.agregarDepartamento(departamento); // Registra el departamento en el sistema de gestión.

        // Agregar empleados al sistema
        sistema.agregarEmpleado(empleado1); // Registra a Ana Gómez en el sistema de gestión.
        sistema.agregarEmpleado(empleado2); // Registra a Luis Martínez en el sistema de gestión.

        // Asignar vacaciones anuales
        sistema.asignarVacacionesAnuales(); // Otorga 21 días de vacaciones anuales a todos los empleados registrados.

        // Mostrar saldo inicial de vacaciones
        System.out.println("Saldo inicial de vacaciones:");
        for (Empleado empleado : departamento.getEmpleados()) {
            // Muestra el saldo de vacaciones inicial para cada empleado.
            System.out.println("Empleado: " + empleado.getNombre() + ", Días disponibles: " + empleado.consultarSaldoVacaciones());
        }

        // Procesar una solicitud de vacaciones
        SolicitudVacaciones solicitud1 = new SolicitudVacaciones(empleado1, 10); // Ana Gómez solicita 10 días de vacaciones.
        sistema.procesarSolicitud(solicitud1); // Procesa la solicitud de vacaciones de Ana Gómez.
        System.out.println("\nDespués de procesar solicitud de Ana Gómez:");
        System.out.println("Estado de la solicitud: " + solicitud1.getEstado()); // Muestra el estado de la solicitud ("Aprobada" o "Rechazada").
        System.out.println("Días restantes para Ana Gómez: " + empleado1.consultarSaldoVacaciones()); // Muestra los días restantes para Ana Gómez.

        // Intentar una solicitud de vacaciones para un empleado contratado
        SolicitudVacaciones solicitud2 = new SolicitudVacaciones(empleado2, 15); // Luis Martínez solicita 15 días de vacaciones.
        sistema.procesarSolicitud(solicitud2); // Procesa la solicitud de vacaciones de Luis Martínez.
        System.out.println("\nDespués de procesar solicitud de Luis Martínez:");
        System.out.println("Estado de la solicitud: " + solicitud2.getEstado()); // Muestra el estado de la solicitud ("Aprobada" o "Rechazada").
        System.out.println("Días restantes para Luis Martínez: " + empleado2.consultarSaldoVacaciones()); // Muestra los días restantes para Luis Martínez.

        // Funcionario pidiendo días prestados
        System.out.println("\nFuncionario pide días prestados:");
        boolean prestamoExitoso = empleado1.pedirPrestamoVacaciones(5); // Ana Gómez pide 5 días prestados del próximo año.
        if (prestamoExitoso) {
            System.out.println("Ana Gómez ahora tiene días prestados. Días restantes: " + empleado1.consultarSaldoVacaciones() + " (Días prestados: " + empleado1.getDiasPrestados() + ")");
        } else {
            System.out.println("Ana Gómez no pudo pedir días prestados."); // Informa si no pudo pedir los días prestados.
        }

        // --- RESULTADOS ---
        // 1. Ana Gómez pudo solicitar y consumir 10 días de vacaciones con éxito.
        // 2. Luis Martínez no pudo solicitar 15 días de vacaciones porque no tenía suficientes días disponibles.
        // 3. Ana Gómez pudo pedir 5 días prestados del próximo año, aumentando su saldo disponible.

        // --- CONCLUSIONES ---
        // 1. El sistema permite gestionar eficientemente vacaciones y préstamos de días, asegurando las reglas establecidas.
        // 2. Los empleados contratados tienen restricciones claras en la solicitud de vacaciones, protegiendo el uso excesivo.
        // 3. El sistema es flexible para empleados como funcionarios, que pueden tomar días prestados según políticas específicas.

        // --- RECOMENDACIONES ---
        // 1. Implementar notificaciones automáticas a los empleados cuando se actualice su saldo de vacaciones.
        // 2. Limitar el número de préstamos por empleado dentro de un período de tiempo para evitar abusos.
        // 3. Agregar reportes mensuales para el jefe del departamento con un resumen del uso de días de vacaciones.

         /*Bibliografia
    1) Oracle. (n.d.). Java Timer Documentation.
Recuperado de https://docs.oracle.com/javase/8/docs/api/java/util/Timer.html
2) TutorialsPoint. (n.d.). UML Tutorial.
Recuperado de https://www.tutorialspoint.com/uml/index.htm
3)  Analisis y clases de diseño, Lenguaje UML (Material de clase, presentado por David Mejia)[Consultado: 8-JANUARY-2025].

     */
    }
}
