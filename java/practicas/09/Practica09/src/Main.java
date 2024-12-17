import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner lector = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro");
            System.out.println("4. Agregar autor");
            System.out.println("5. Buscar autor");
            System.out.println("6. Realizar préstamo");
            System.out.println("7. Devolver préstamo");
            System.out.println("8. Salir");

            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese título del libro: ");
                    String titulo = lector.nextLine();
                    System.out.print("Ingrese ISBN del libro: ");
                    String isbn = lector.nextLine();
                    System.out.print("Ingrese nombre del autor: ");
                    String nombreAutor = lector.nextLine();

                    Autor autor = biblioteca.buscarAutor(nombreAutor);
                    if (autor == null) {
                        System.out.print("Autor no encontrado. Ingrese nacionalidad del autor: ");
                        String nacionalidad = lector.nextLine();
                        autor = new Autor(nombreAutor, nacionalidad);
                        biblioteca.agregarAutor(autor);
                    }

                    Libro libro = new Libro(titulo, isbn, autor);
                    biblioteca.agregarLibro(libro);
                    break;
                case 2:
                    System.out.print("Ingrese ISBN del libro a eliminar: ");
                    String isbnEliminar = lector.nextLine();
                    biblioteca.eliminarLibro(isbnEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese ISBN del libro a buscar: ");
                    String isbnBuscar = lector.nextLine();
                    Libro libroBuscado = biblioteca.buscarLibro(isbnBuscar);
                    System.out.println(libroBuscado != null ? libroBuscado : "Libro no encontrado");
                    break;
                case 4:
                    System.out.print("Ingrese nombre del autor: ");
                    String nombreNuevoAutor = lector.nextLine();
                    System.out.print("Ingrese nacionalidad del autor: ");
                    String nacionalidadNuevoAutor = lector.nextLine();
                    Autor nuevoAutor = new Autor(nombreNuevoAutor, nacionalidadNuevoAutor);
                    biblioteca.agregarAutor(nuevoAutor);
                    break;
                case 5:
                    System.out.print("Ingrese nombre del autor a buscar: ");
                    String nombreBuscarAutor = lector.nextLine();
                    Autor autorBuscado = biblioteca.buscarAutor(nombreBuscarAutor);
                    System.out.println(autorBuscado != null ? autorBuscado : "Autor no encontrado");
                    break;
                case 6:
                    System.out.print("Ingrese ISBN del libro a prestar: ");
                    String isbnPrestar = lector.nextLine();
                    Libro libroPrestar = biblioteca.buscarLibro(isbnPrestar);
                    if (libroPrestar != null) {
                        System.out.print("Ingrese nombre del usuario: ");
                        String usuario = lector.nextLine();
                        biblioteca.realizarPrestamo(libroPrestar, usuario);
                        System.out.println("Préstamo realizado con éxito");
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case 7:
                    System.out.print("Ingrese ISBN del libro a devolver: ");
                    String isbnDevolver = lector.nextLine();
                    Libro libroDevolver = biblioteca.buscarLibro(isbnDevolver);
                    if (libroDevolver != null) {
                        biblioteca.devolverPrestamo(libroDevolver);
                        System.out.println("Préstamo devuelto con éxito");
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    lector.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
