import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*
     ===========================
     Resultados obtenidos:
     ===========================
     1. Se registraron 10 cuentas bancarias con balances iniciales aleatorios.
     2. La información de las cuentas se almacenó exitosamente en un archivo binario.
     3. Las cuentas se recuperaron correctamente desde el archivo, mostrando sus detalles.
     4. El sistema soporta transferencias entre diferentes monedas con conversión automática.
     5. Se validaron correctamente operaciones como depósito, retiro y transferencia.

     ===========================
     Conclusiones:
     ===========================
     1. El uso de herencia y clases abstractas permite un diseño modular y extensible.
     2. La serialización garantiza la persistencia de datos entre sesiones del programa.
     3. El manejo de excepciones asegura que los errores se informen al usuario.
     4. La separación lógica entre bancos y monedas facilita futuras expansiones del sistema.
     5. Las pruebas realizadas muestran que el sistema es robusto y funcional.

     ===========================
     Recomendaciones:
     ===========================
     1. Agregar validaciones adicionales para evitar duplicados en los registros.
     2. Implementar autenticación de usuarios para mayor seguridad en el manejo de cuentas.
     3. Incluir un sistema de búsqueda para consultar detalles de una cuenta específica.
     4. Mejorar la interfaz del usuario para hacerla más intuitiva y atractiva.
     5. Extender la funcionalidad para manejar múltiples tipos de monedas internacionales.

      ===========================
     Bibliografía:
     ===========================
     1.Microsoft Learn. (s.f.). System.Text.Json Overview. Recuperado de https://learn.microsoft.com/es-es/dotnet/standard/serialization/system-text-json/overview.
     2.TutorialesProgramacionYa. (s.f.). Serialización y deserialización con el módulo JSON en Python. Recuperado de https://www.tutorialesprogramacionya.com/pythonya/detalleconcepto.php?codigo=102&inicio=90&punto=101.
     3.YouTube. (2023). Serialization and Deserialization Explained. Recuperado de https://www.youtube.com/watch?v=POj5owpInuY.
     */

public class TestBanco {
    private static final String ARCHIVO_DATOS = "cuentas_banco.dat"; // Nombre del archivo donde se almacenarán los datos.

    public static void main(String[] args) {
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>(); // Lista que almacenará las cuentas bancarias.
        Scanner scanner = new Scanner(System.in); // Objeto para recibir entrada del usuario.
        int opcion; // Variable para almacenar la opción seleccionada por el usuario.

        // Mensaje de bienvenida
        System.out.println("====================================");
        System.out.println("  Bienvenido al Sistema Bancario");
        System.out.println("====================================");

        // Ciclo principal del menú
        do {
            // Mostrar menú principal
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar 10 cuentas bancarias");
            System.out.println("2. Guardar información del banco en archivo");
            System.out.println("3. Cargar información del banco desde archivo");
            System.out.println("4. Salir del sistema");
            System.out.print("Por favor, seleccione una opción: ");
            opcion = scanner.nextInt(); // Leer opción del usuario.

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1 -> {
                    registrarCuentas(cuentas); // Llamar al método para registrar cuentas.
                    System.out.println("✔ ¡Cuentas bancarias registradas exitosamente!");
                }
                case 2 -> {
                    // Verificar si hay cuentas registradas antes de guardar.
                    if (cuentas.isEmpty()) {
                        System.out.println("⚠ No hay cuentas registradas. Regístrelas primero.");
                    } else {
                        almacenarInformacion(cuentas); // Guardar cuentas en el archivo.
                        System.out.println("✔ Información del banco guardada correctamente en '" + ARCHIVO_DATOS + "'.");
                    }
                }
                case 3 -> {
                    // Cargar información desde el archivo y asignarla a la lista.
                    cuentas = recuperarInformacion();
                    if (cuentas.isEmpty()) {
                        System.out.println("⚠ No se encontró información para cargar.");
                    } else {
                        System.out.println("✔ Información cargada y mostrada correctamente.");
                    }
                }
                case 4 -> System.out.println("Gracias por usar nuestro sistema bancario. ¡Hasta luego!");
                default -> System.out.println("⚠ Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4); // Continuar mostrando el menú mientras no se elija salir.
    }

    // Método para registrar 10 cuentas bancarias con balances iniciales aleatorios.
    private static void registrarCuentas(ArrayList<CuentaBancaria> cuentas) {
        cuentas.clear(); // Limpiar la lista para evitar duplicados.
        Random random = new Random(); // Objeto para generar valores aleatorios.

        // Registrar cuentas con balances iniciales aleatorios.
        cuentas.add(crearCuentaBanco1("Miguel Aviles", 1001, random));
        cuentas.add(crearCuentaBanco1("Ana Rodas ", 1002, random));
        cuentas.add(crearCuentaBanco1("Mateo Oviedo", 1003, random));
        cuentas.add(crearCuentaBanco2("Maria del Cisne", 2001, random));
        cuentas.add(crearCuentaBanco2("Luis Salazar", 2002, random));
        cuentas.add(crearCuentaBanco2("Alex Travez", 2003, random));
        cuentas.add(crearCuentaBanco1("Karen Tenorio", 1004, random));
        cuentas.add(crearCuentaBanco1("Laura Zambrano", 1005, random));
        cuentas.add(crearCuentaBanco2("Daniel Kirby", 2004, random));
        cuentas.add(crearCuentaBanco2("Andrea Toba", 2005, random));

        // Mostrar un resumen de las cuentas registradas.
        System.out.println("\nSe han registrado 10 cuentas predeterminadas con balances iniciales:");
        for (CuentaBancaria cuenta : cuentas) {
            System.out.println("  - Propietario: " + cuenta.nombrePropietario +
                    ", Banco: " + cuenta.GetNombreBanco() +
                    ", Balance inicial: " + cuenta.GetBalance() + " " + cuenta.GetTipoMoneda());
        }
    }

    // Crear una cuenta en Banco Pichincha con un balance inicial aleatorio.
    private static CuentaBanco1 crearCuentaBanco1(String propietario, int idCuenta, Random random) {
        CuentaBanco1 cuenta = new CuentaBanco1(propietario, idCuenta);
        cuenta.Depositar(50 + random.nextDouble() * 450); // Balance inicial entre 50 y 500 dólares.
        return cuenta;
    }

    // Crear una cuenta en Banco La Previsora con un balance inicial aleatorio.
    private static CuentaBanco2 crearCuentaBanco2(String propietario, int idCuenta, Random random) {
        CuentaBanco2 cuenta = new CuentaBanco2(propietario, idCuenta);
        cuenta.Depositar(25000 * (50 + random.nextDouble() * 450)); // Balance inicial entre 50 y 500 dólares convertido a sucres.
        return cuenta;
    }

    // Guardar la lista de cuentas en un archivo utilizando serialización.
    private static void almacenarInformacion(ArrayList<CuentaBancaria> cuentas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DATOS))) {
            oos.writeObject(cuentas); // Serializar y guardar la lista de cuentas.
        } catch (IOException e) {
            System.out.println("❌ Error al guardar la información: " + e.getMessage());
        }
    }

    // Cargar la lista de cuentas desde un archivo utilizando deserialización.
    @SuppressWarnings("unchecked")
    private static ArrayList<CuentaBancaria> recuperarInformacion() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_DATOS))) {
            ArrayList<CuentaBancaria> cuentas = (ArrayList<CuentaBancaria>) ois.readObject(); // Leer y deserializar la lista.
            System.out.println("\nInformación cargada exitosamente. Detalles de las cuentas:");
            for (CuentaBancaria cuenta : cuentas) {
                System.out.println("  - Propietario: " + cuenta.nombrePropietario +
                        ", Banco: " + cuenta.GetNombreBanco() +
                        ", Balance: " + cuenta.GetBalance() + " " + cuenta.GetTipoMoneda());
            }
            return cuentas;
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error al procesar los datos: " + e.getMessage());
        }
        return new ArrayList<>(); // Devuelve una lista vacía si ocurre un error.
    }


}
