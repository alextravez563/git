// Definimos el paquete en el que se encuentra esta clase.
package com.mialquiler.servicios;

// Importamos las clases necesarias para manejar reservas, clientes y vehículos.
import com.mialquiler.models.Cliente;
import com.mialquiler.models.Reserva;
import com.mialquiler.models.Vehiculo;

// Importamos las clases necesarias para manejar archivos y fechas.
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Clase encargada de gestionar las reservas en el sistema.
public class GestorReservas {
    // Lista que almacena las reservas en memoria.
    private final List<Reserva> reservas;
    // Nombre del archivo donde se guardan las reservas.
    private static final String ARCHIVO_RESERVAS = "reservas.dat";

    // Constructor que inicializa la lista de reservas cargándolas desde el archivo.
    public GestorReservas() {
        this.reservas = cargarReservas();
    }

    // Método para agregar una reserva.
    public void agregarReserva(Reserva reserva) {
        // Verifica si el vehículo está disponible para las fechas seleccionadas.
        if (esVehiculoDisponible(reserva.getVehiculo(), reserva.getFechaInicio(), reserva.getFechaFin())) {
            reservas.add(reserva); // Agrega la reserva a la lista.
            reserva.getVehiculo().setDisponible(false); // Marca el vehículo como no disponible.
            guardarReservas(); // Guarda la lista actualizada en el archivo.
        } else {
            System.out.println("El vehículo no está disponible para las fechas seleccionadas.");
        }
    }

    // Método para cancelar una reserva existente.
    public void cancelarReserva(String idReserva) {
        Reserva reserva = buscarReserva(idReserva); // Busca la reserva por su ID.
        if (reserva != null) {
            reserva.getVehiculo().setDisponible(true); // Marca el vehículo como disponible.
            reservas.remove(reserva); // Elimina la reserva de la lista.
            guardarReservas(); // Guarda la lista actualizada en el archivo.
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

    // Método para buscar una reserva por su ID.
    public Reserva buscarReserva(String idReserva) {
        // Utiliza streams para buscar la reserva en la lista.
        return reservas.stream()
                .filter(reserva -> reserva.getIdReserva().equals(idReserva)) // Filtra por ID de reserva.
                .findFirst() // Toma el primer resultado encontrado.
                .orElse(null); // Si no encuentra nada, devuelve null.
    }

    // Método para listar todas las reservas almacenadas.
    public List<Reserva> listarReservas() {
        // Retorna una nueva lista para evitar modificaciones directas en la lista original.
        return new ArrayList<>(reservas);
    }

    // Método privado que verifica si un vehículo está disponible en un rango de fechas.
    private boolean esVehiculoDisponible(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        for (Reserva reserva : reservas) {
            // Verifica si el vehículo ya está reservado en las fechas seleccionadas.
            if (reserva.getVehiculo().equals(vehiculo) &&
                    (fechaInicio.isBefore(reserva.getFechaFin()) && fechaFin.isAfter(reserva.getFechaInicio()))) {
                return false; // Retorna falso si hay una superposición de fechas.
            }
        }
        return true; // Retorna verdadero si el vehículo está disponible.
    }

    // Método privado para guardar la lista de reservas en un archivo.
    private void guardarReservas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_RESERVAS))) {
            oos.writeObject(reservas); // Escribe la lista de reservas en el archivo.
        } catch (IOException e) {
            System.err.println("Error al guardar las reservas: " + e.getMessage());
        }
    }

    // Método privado para cargar la lista de reservas desde un archivo.
    private List<Reserva> cargarReservas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_RESERVAS))) {
            return (List<Reserva>) ois.readObject(); // Lee la lista de reservas desde el archivo.
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Si hay un error, devuelve una lista vacía.
        }
    }
}
