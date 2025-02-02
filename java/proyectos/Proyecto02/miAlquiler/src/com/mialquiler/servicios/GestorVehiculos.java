// Definimos el paquete donde se encuentra la clase.
package com.mialquiler.servicios;

// Importamos la clase Vehiculo.
import com.mialquiler.models.Vehiculo;

// Importamos las clases necesarias para manejar archivos y listas.
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Clase encargada de gestionar los vehículos en el sistema.
public class GestorVehiculos {
    // Lista que almacena los vehículos en memoria.
    private final List<Vehiculo> vehiculos;
    // Nombre del archivo donde se guardan los vehículos.
    private static final String ARCHIVO_VEHICULOS = "vehiculos.dat";

    // Constructor que inicializa la lista de vehículos cargándolos desde el archivo.
    public GestorVehiculos() {
        this.vehiculos = cargarVehiculos();
    }

    // Método para agregar un vehículo a la lista.
    public void agregarVehiculo(Vehiculo vehiculo) {
        // Verifica si el vehículo ya existe en la lista por su matrícula.
        if (buscarVehiculo(vehiculo.getMatricula()) == null) {
            vehiculos.add(vehiculo); // Agrega el vehículo si no existe.
            guardarVehiculos(); // Guarda la lista actualizada en el archivo.
        } else {
            System.out.println("El vehículo con matrícula " + vehiculo.getMatricula() + " ya existe.");
        }
    }

    // Método para eliminar un vehículo por su matrícula.
    public void eliminarVehiculo(String matricula) {
        Vehiculo vehiculo = buscarVehiculo(matricula); // Busca el vehículo.
        if (vehiculo != null) {
            vehiculos.remove(vehiculo); // Elimina el vehículo si existe.
            guardarVehiculos(); // Guarda la lista actualizada en el archivo.
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    // Método para buscar un vehículo por su matrícula.
    public Vehiculo buscarVehiculo(String matricula) {
        // Utiliza Streams para buscar el vehículo en la lista.
        return vehiculos.stream()
                .filter(v -> v.getMatricula().equals(matricula)) // Filtra por matrícula.
                .findFirst() // Toma el primer resultado encontrado.
                .orElse(null); // Retorna null si no encuentra nada.
    }

    // Método para listar todos los vehículos registrados.
    public List<Vehiculo> listarVehiculos() {
        return new ArrayList<>(vehiculos); // Retorna una copia de la lista para evitar modificaciones externas.
    }

    // Método para listar solo los vehículos disponibles para alquiler.
    public List<Vehiculo> listarVehiculosDisponibles() {
        // Filtra la lista para devolver solo los vehículos que están disponibles.
        return vehiculos.stream().filter(Vehiculo::isDisponible).toList();
    }

    // Método privado para guardar la lista de vehículos en un archivo binario.
    private void guardarVehiculos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_VEHICULOS))) {
            oos.writeObject(vehiculos); // Escribe la lista de vehículos en el archivo.
        } catch (IOException e) {
            System.err.println("Error al guardar los vehículos: " + e.getMessage());
        }
    }

    // Método privado para cargar la lista de vehículos desde un archivo binario.
    private List<Vehiculo> cargarVehiculos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_VEHICULOS))) {
            return (List<Vehiculo>) ois.readObject(); // Lee la lista de vehículos desde el archivo.
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Si hay un error, devuelve una lista vacía.
        }
    }
}
