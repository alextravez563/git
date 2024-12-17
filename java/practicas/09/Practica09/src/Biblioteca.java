import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Biblioteca {
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        autores = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(String isbn) {
        libros.removeIf(libro -> libro.getIsbn().equals(isbn));
    }

    public Libro buscarLibro(String isbn) {
        return libros.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public Autor buscarAutor(String nombre) {
        return autores.stream().filter(autor -> autor.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public void realizarPrestamo(Libro libro, String usuario) {
        Prestamo prestamo = new Prestamo(libro, usuario, new Date());
        prestamos.add(prestamo);
    }

    public void devolverPrestamo(Libro libro) {
        Prestamo prestamo = prestamos.stream()
                .filter(p -> p.getLibro().equals(libro))
                .findFirst().orElse(null);
        if (prestamo != null) {
            prestamo.setFechaDevolucion(new Date());
        }
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
