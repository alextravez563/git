import java.io.*;

/**
 * Clase Guardar gestiona la serialización y deserialización de los objetos de tipo Juego.
 */
public class Guardar {

    private static final String NOMBRE_ARCHIVO = "juego.dat"; // Nombre del archivo para guardar el juego

    /**
     * Guarda un objeto Juego en un archivo.
     *
     * @param juego el objeto Juego a guardar
     * @throws IOException si ocurre un error al escribir en el archivo
     */
    public static void guardarJuego(Juego juego) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(NOMBRE_ARCHIVO);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(juego);
        }
    }

    /**
     * Carga un objeto Juego desde un archivo.
     *
     * @return el objeto Juego cargado
     * @throws IOException si ocurre un error al leer el archivo
     * @throws ClassNotFoundException si la clase del objeto no se encuentra
     */
    public static Juego cargarJuego() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(NOMBRE_ARCHIVO);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Juego) ois.readObject();
        }
    }
}
