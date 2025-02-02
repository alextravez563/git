package com.mialquiler.models;// Importamos la clase LocalDate para manejar fechas.
import java.time.LocalDate;
// Importamos Serializable para permitir la serialización de objetos de esta clase.
import java.io.Serializable;

// Definimos la clase Reserva, que representa una reserva de un vehículo en el sistema.
// Implementa Serializable para permitir que los objetos puedan ser guardados y recuperados.
public class Reserva implements Serializable {
    // Identificador único de la reserva.
    private String idReserva;
    // Cliente que ha realizado la reserva.
    private Cliente cliente;
    // Vehículo que ha sido reservado.
    private Vehiculo vehiculo;
    // Fecha de inicio de la reserva.
    private LocalDate fechaInicio;
    // Fecha de finalización de la reserva.
    private LocalDate fechaFin;

    // Constructor que inicializa todos los atributos de la reserva.
    public Reserva(String idReserva, Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReserva = idReserva; // Se asigna el ID de la reserva.
        this.cliente = cliente; // Se asigna el cliente que realiza la reserva.
        this.vehiculo = vehiculo; // Se asigna el vehículo reservado.
        this.fechaInicio = fechaInicio; // Se asigna la fecha de inicio de la reserva.
        this.fechaFin = fechaFin; // Se asigna la fecha de finalización de la reserva.
    }

    // Método para obtener el ID de la reserva.
    public String getIdReserva() {
        return idReserva;
    }

    // Método para establecer un nuevo ID de reserva.
    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    // Método para obtener el cliente asociado a la reserva.
    public Cliente getCliente() {
        return cliente;
    }

    // Método para actualizar el cliente de la reserva.
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método para obtener el vehículo reservado.
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    // Método para actualizar el vehículo de la reserva.
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    // Método para obtener la fecha de inicio de la reserva.
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    // Método para actualizar la fecha de inicio de la reserva.
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    // Método para obtener la fecha de finalización de la reserva.
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    // Método para actualizar la fecha de finalización de la reserva.
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Sobreescribe el método toString() para proporcionar una representación en texto del objeto Reserva.
    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva='" + idReserva + '\'' + // Se incluye el ID de la reserva.
                ", cliente=" + cliente + // Se incluye la información del cliente.
                ", vehiculo=" + vehiculo + // Se incluye la información del vehículo.
                ", fechaInicio=" + fechaInicio + // Se incluye la fecha de inicio.
                ", fechaFin=" + fechaFin + // Se incluye la fecha de finalización.
                '}';
    }
}
