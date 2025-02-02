// Definimos el paquete en el que se encuentra esta clase.
package com.mialquiler.models;

// Importamos las clases necesarias para manejar listas dinámicas.
import java.util.ArrayList;
import java.util.List;

// Definimos la clase AgenciaAlquiler, que se encargará de gestionar clientes, vehículos y reservas.
public class AgenciaAlquiler {
    // Lista donde se almacenarán los clientes registrados en la agencia.
    private List<Cliente> clientes;
    // Lista donde se almacenarán los vehículos disponibles o alquilados.
    private List<Vehiculo> vehiculos;
    // Lista donde se guardarán las reservas realizadas por los clientes.
    private List<Reserva> reservas;

    // Constructor de la clase que inicializa las listas vacías al crear una instancia de AgenciaAlquiler.
    public AgenciaAlquiler() {
        this.clientes = new ArrayList<>(); // Se inicializa la lista de clientes como un ArrayList vacío.
        this.vehiculos = new ArrayList<>(); // Se inicializa la lista de vehículos como un ArrayList vacío.
        this.reservas = new ArrayList<>(); // Se inicializa la lista de reservas como un ArrayList vacío.
    }

    // Método para agregar un nuevo cliente a la lista de clientes.
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente); // Se añade el cliente a la lista de clientes.
    }

    // Método para agregar un nuevo vehículo a la lista de vehículos.
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo); // Se añade el vehículo a la lista de vehículos.
    }

    // Método para realizar una reserva de un vehículo.
    // Puede lanzar una excepción si el vehículo ya está ocupado.
    public void realizarReserva(Reserva reserva) throws VehiculoOcupadoException, com.mialquiler.models.VehiculoOcupadoException {
        // Verifica si el vehículo está disponible antes de proceder con la reserva.
        if (!reserva.getVehiculo().isDisponible()) {
            // Si el vehículo no está disponible, se lanza una excepción indicando que ya está ocupado.
            throw new com.mialquiler.models.VehiculoOcupadoException("El vehículo no está disponible.");
        }
        // Se marca el vehículo como no disponible ya que ha sido reservado.
        reserva.getVehiculo().setDisponible(false);
        // Se agrega la reserva a la lista de reservas registradas.
        reservas.add(reserva);
    }

    // Método para obtener la lista de clientes registrados en la agencia.
    public List<Cliente> getClientes() {
        return clientes; // Retorna la lista de clientes.
    }

    // Método para obtener la lista de vehículos registrados en la agencia.
    public List<Vehiculo> getVehiculos() {
        return vehiculos; // Retorna la lista de vehículos.
    }

    // Método para obtener la lista de reservas realizadas por los clientes.
    public List<Reserva> getReservas() {
        return reservas; // Retorna la lista de reservas.
    }

    // Definición de una excepción interna que se utilizará cuando un vehículo esté ocupado.
    private class VehiculoOcupadoException extends Exception {
    }
}
