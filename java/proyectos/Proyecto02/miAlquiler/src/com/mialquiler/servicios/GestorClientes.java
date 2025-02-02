// Definimos el paquete en el que se encuentra esta clase.
package com.mialquiler.servicios;

// Importamos la clase Cliente desde el paquete models.
import com.mialquiler.models.Cliente;

// Importamos las clases necesarias para manejar archivos y listas.
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Clase encargada de gestionar los clientes en el sistema.
public class GestorClientes {
    // Lista que almacena los clientes en memoria.
    private final List<Cliente> clientes;
    // Nombre del archivo donde se guardan los clientes.
    private static final String ARCHIVO_CLIENTES = "clientes.dat";

    // Constructor que inicializa la lista de clientes cargándolos desde el archivo.
    public GestorClientes() {
        this.clientes = cargarClientes();
    }

    // Método para agregar un cliente a la lista.
    public void agregarCliente(Cliente cliente) {
        // Verifica si el cliente ya existe en la lista.
        if (buscarCliente(cliente.getId()) == null) {
            clientes.add(cliente); // Agrega el cliente a la lista.
            guardarClientes(); // Guarda la lista actualizada en el archivo.
        } else {
            System.out.println("El cliente con ID " + cliente.getId() + " ya existe.");
        }
    }

    // Método para eliminar un cliente de la lista.
    public void eliminarCliente(String id) {
        Cliente cliente = buscarCliente(id); // Busca el cliente por su ID.
        if (cliente != null) {
            clientes.remove(cliente); // Lo elimina de la lista.
            guardarClientes(); // Guarda la lista actualizada en el archivo.
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    // Método para buscar un cliente por su ID.
    public Cliente buscarCliente(String id) {
        // Utiliza streams para buscar el cliente en la lista.
        return clientes.stream()
                .filter(c -> c.getId().equals(id)) // Filtra los clientes que tienen el mismo ID.
                .findFirst() // Toma el primer resultado encontrado.
                .orElse(null); // Si no encuentra nada, devuelve null.
    }

    // Método para listar todos los clientes almacenados.
    public List<Cliente> listarClientes() {
        // Retorna una nueva lista para evitar modificaciones directas en la lista original.
        return new ArrayList<>(clientes);
    }

    // Método privado para guardar la lista de clientes en un archivo.
    private void guardarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            oos.writeObject(clientes); // Escribe la lista de clientes en el archivo.
        } catch (IOException e) {
            System.err.println("Error al guardar los clientes: " + e.getMessage());
        }
    }

    // Método privado para cargar la lista de clientes desde un archivo.
    private List<Cliente> cargarClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
            return (List<Cliente>) ois.readObject(); // Lee la lista de clientes desde el archivo.
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Si hay un error, devuelve una lista vacía.
        }
    }
}
