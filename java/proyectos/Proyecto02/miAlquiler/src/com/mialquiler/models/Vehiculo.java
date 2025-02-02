// Definimos el paquete en el que se encuentra esta clase.
package com.mialquiler.models;

// Importamos Serializable para permitir la serialización de objetos de esta clase.
import java.io.Serializable;

// Definimos la clase Vehiculo, que representa un vehículo dentro del sistema de alquiler.
// Implementa Serializable para que los objetos puedan ser almacenados y recuperados.
public class Vehiculo implements Serializable {
    // Atributo que almacena la matrícula del vehículo (número de placa).
    private String matricula;
    // Atributo que almacena el modelo del vehículo.
    private String modelo;
    // Atributo que indica el tipo de vehículo (por ejemplo: sedán, SUV, motocicleta, etc.).
    private String tipo;
    // Atributo que indica si el vehículo está disponible para alquilar o no.
    private boolean disponible;

    // Constructor de la clase que inicializa todos los atributos del vehículo.
    public Vehiculo(String matricula, String modelo, String tipo, boolean disponible) {
        this.matricula = matricula; // Se asigna la matrícula del vehículo.
        this.modelo = modelo; // Se asigna el modelo del vehículo.
        this.tipo = tipo; // Se asigna el tipo de vehículo.
        this.disponible = disponible; // Se asigna el estado de disponibilidad del vehículo.
    }

    // Método para obtener la matrícula del vehículo.
    public String getMatricula() {
        return matricula;
    }

    // Método para establecer una nueva matrícula al vehículo.
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Método para obtener el modelo del vehículo.
    public String getModelo() {
        return modelo;
    }

    // Método para actualizar el modelo del vehículo.
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Método para obtener el tipo de vehículo.
    public String getTipo() {
        return tipo;
    }

    // Método para actualizar el tipo de vehículo.
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método para verificar si el vehículo está disponible para alquilar.
    public boolean isDisponible() {
        return disponible;
    }

    // Método para cambiar el estado de disponibilidad del vehículo.
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Sobreescribe el método toString() para devolver una representación en cadena del objeto Vehiculo.
    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' + // Se incluye la matrícula en la representación.
                ", modelo='" + modelo + '\'' + // Se incluye el modelo en la representación.
                ", tipo='" + tipo + '\'' + // Se incluye el tipo en la representación.
                ", disponible=" + disponible + // Se incluye el estado de disponibilidad en la representación.
                '}';
    }
}
