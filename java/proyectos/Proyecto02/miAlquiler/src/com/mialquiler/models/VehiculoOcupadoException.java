// Definimos el paquete en el que se encuentra esta clase.
package com.mialquiler.models;

// Definimos la clase VehiculoOcupadoException, que representa una excepción personalizada
// para indicar que un vehículo ya está ocupado y no se puede reservar.
public class VehiculoOcupadoException extends Throwable {

    // Constructor que recibe un mensaje de error y lo pasa a la clase base (Throwable).
    public VehiculoOcupadoException(String s) {
        super(s); // Llama al constructor de la superclase Throwable con el mensaje de error.
    }
}
