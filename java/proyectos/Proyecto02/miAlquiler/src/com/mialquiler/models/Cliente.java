// Definimos el paquete en el que se encuentra esta clase.
package com.mialquiler.models;

// Importamos la interfaz Serializable para permitir que los objetos de esta clase puedan ser guardados y recuperados.
import java.io.Serializable;

// Definimos la clase Cliente, que representa a un cliente en el sistema de alquiler.
// Implementa Serializable para que sus objetos puedan ser convertidos en una secuencia de bytes y almacenados.
public class Cliente implements Serializable {
    // Atributo que almacena el identificador único del cliente.
    private String id;
    // Atributo que almacena el nombre del cliente.
    private String nombre;
    // Atributo que almacena el número de teléfono del cliente.
    private String telefono;

    // Constructor de la clase que recibe los datos del cliente y los asigna a sus respectivos atributos.
    public Cliente(String id, String nombre, String telefono) {
        this.id = id; // Asigna el ID recibido al atributo id.
        this.nombre = nombre; // Asigna el nombre recibido al atributo nombre.
        this.telefono = telefono; // Asigna el teléfono recibido al atributo telefono.
    }

    // Método para obtener el ID del cliente.
    public String getId() {
        return id;
    }

    // Método para actualizar el ID del cliente.
    public void setId(String id) {
        this.id = id;
    }

    // Método para obtener el nombre del cliente.
    public String getNombre() {
        return nombre;
    }

    // Método para actualizar el nombre del cliente.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el teléfono del cliente.
    public String getTelefono() {
        return telefono;
    }

    // Método para actualizar el teléfono del cliente.
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Sobreescribe el método toString() para devolver una representación en cadena del objeto Cliente.
    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' + // Se incluye el ID en la representación de la cadena.
                ", nombre='" + nombre + '\'' + // Se incluye el nombre en la representación de la cadena.
                ", telefono='" + telefono + '\'' + // Se incluye el teléfono en la representación de la cadena.
                '}';
    }
}
