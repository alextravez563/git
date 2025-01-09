import java.util.Scanner;

/*
//Practica08
 // Nombre: Alex Travez , Mateo Oviedo
 // Fecha de realizacion:18/12/2024
 // Fecha de entrega: 19/12/2024
 */

public class Main {
    public static void main(String[] args) {
        // Se instancia una nueva biblioteca que gestionará autores, libros y préstamos.
        Biblioteca biblioteca = new Biblioteca();
        // Se utiliza un Scanner para leer datos introducidos por el usuario.
        Scanner lector = new Scanner(System.in);

        // Bucle infinito que muestra el menú de opciones hasta que el usuario decida salir.
        while (true) {
            // Menú principal con las opciones disponibles para el usuario.
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro");
            System.out.println("4. Agregar autor");
            System.out.println("5. Buscar autor");
            System.out.println("6. Realizar préstamo");
            System.out.println("7. Devolver préstamo");
            System.out.println("8. Salir");

            // Se solicita al usuario que seleccione una opción.
            int opcion = lector.nextInt();
            lector.nextLine(); // Limpieza del buffer después de leer un número.

            // Se utiliza un switch para determinar qué acción ejecutar según la opción seleccionada.
            switch (opcion) {
                case 1:
                    // Agregar un nuevo libro.
                    System.out.print("Ingrese título del libro: ");
                    String titulo = lector.nextLine();
                    System.out.print("Ingrese ISBN del libro: ");
                    String isbn = lector.nextLine();
                    System.out.print("Ingrese nombre del autor: ");
                    String nombreAutor = lector.nextLine();

                    // Se busca al autor ingresado para reutilizarlo si ya existe.
                    Autor autor = biblioteca.buscarAutor(nombreAutor);
                    if (autor == null) {
                        // Si el autor no existe, se solicita al usuario que proporcione su nacionalidad.
                        System.out.print("Autor no encontrado. Ingrese nacionalidad del autor: ");
                        String nacionalidad = lector.nextLine();
                        autor = new Autor(nombreAutor, nacionalidad);
                        biblioteca.agregarAutor(autor); // Se agrega el nuevo autor.
                    }

                    // Se crea el libro y se agrega a la biblioteca.
                    Libro libro = new Libro(titulo, isbn, autor);
                    biblioteca.agregarLibro(libro);
                    break;

                case 2:
                    // Eliminar un libro por su ISBN.
                    System.out.print("Ingrese ISBN del libro a eliminar: ");
                    String isbnEliminar = lector.nextLine();
                    biblioteca.eliminarLibro(isbnEliminar); // Elimina el libro si existe.
                    break;

                case 3:
                    // Buscar un libro por su ISBN.
                    System.out.print("Ingrese ISBN del libro a buscar: ");
                    String isbnBuscar = lector.nextLine();
                    Libro libroBuscado = biblioteca.buscarLibro(isbnBuscar);
                    System.out.println(libroBuscado != null ? libroBuscado : "Libro no encontrado");
                    break;

                case 4:
                    // Agregar un nuevo autor.
                    System.out.print("Ingrese nombre del autor: ");
                    String nombreNuevoAutor = lector.nextLine();
                    System.out.print("Ingrese nacionalidad del autor: ");
                    String nacionalidadNuevoAutor = lector.nextLine();
                    Autor nuevoAutor = new Autor(nombreNuevoAutor, nacionalidadNuevoAutor);
                    biblioteca.agregarAutor(nuevoAutor); // Agrega el nuevo autor.
                    break;

                case 5:
                    // Buscar un autor por su nombre.
                    System.out.print("Ingrese nombre del autor a buscar: ");
                    String nombreBuscarAutor = lector.nextLine();
                    Autor autorBuscado = biblioteca.buscarAutor(nombreBuscarAutor);
                    System.out.println(autorBuscado != null ? autorBuscado : "Autor no encontrado");
                    break;

                case 6:
                    // Realizar un préstamo de un libro.
                    System.out.print("Ingrese ISBN del libro a prestar: ");
                    String isbnPrestar = lector.nextLine();
                    Libro libroPrestar = biblioteca.buscarLibro(isbnPrestar);
                    if (libroPrestar != null) {
                        System.out.print("Ingrese nombre del usuario: ");
                        String usuario = lector.nextLine();
                        biblioteca.realizarPrestamo(libroPrestar, usuario); // Registra el préstamo.
                        System.out.println("Préstamo realizado con éxito");
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;

                case 7:
                    // Devolver un libro prestado.
                    System.out.print("Ingrese ISBN del libro a devolver: ");
                    String isbnDevolver = lector.nextLine();
                    Libro libroDevolver = biblioteca.buscarLibro(isbnDevolver);
                    if (libroDevolver != null) {
                        biblioteca.devolverPrestamo(libroDevolver); // Registra la devolución.
                        System.out.println("Préstamo devuelto con éxito");
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;

                case 8:
                    // Salir del programa.
                    System.out.println("Saliendo...");
                    lector.close(); // Cierra el scanner.
                    System.exit(0); // Finaliza la ejecución del programa.
                    break;

                default:
                    // Opción inválida.
                    System.out.println("Opción no válida");
            }
        }
    }

    // --- Conclusiones ---
    /*
     * 1. El programa implementa un sistema funcional de biblioteca, manejando libros,
     *    autores y préstamos de manera eficiente mediante un menú interactivo.
     * 2. La estructura modular permite un manejo claro de datos y facilita la extensión
     *    del programa para futuras funcionalidades.
     * 3. Los casos de uso básicos (agregar, buscar, prestar y devolver) están
     *    correctamente implementados, mostrando mensajes claros al usuario.
     */



    // --- Recomendaciones ---
    /*
     * 1. Mejorar la validación de entradas para manejar errores como cadenas vacías o formatos inválidos de ISBN.
     * 2. Agregar una opción para listar todos los libros y autores registrados en la biblioteca.
     * 3. Incorporar persistencia de datos (por ejemplo, con un archivo o base de datos)
     *    para que la información no se pierda al cerrar el programa.
     */


}


