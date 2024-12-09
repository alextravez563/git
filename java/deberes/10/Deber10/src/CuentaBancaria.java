import java.io.Serializable;

// Clase abstracta que representa una cuenta bancaria y es serializable.
// Al ser abstracta, no se puede instanciar directamente, pero sirve como plantilla para otras clases.
// Implementa Serializable para permitir la persistencia de datos (almacenamiento y recuperación).
abstract class CuentaBancaria implements Serializable {
    protected String nombrePropietario; // Nombre del titular de la cuenta.
    protected double balance; // Monto de dinero actual en la cuenta.
    protected int idCuenta; // Número único de identificación de la cuenta.

    protected static int contadorCuentas = 0; // Contador que lleva la cantidad total de cuentas creadas.

    // Constructor: Inicializa una cuenta bancaria con un propietario y un ID.
    // El balance inicial es 0.0 por defecto.
    public CuentaBancaria(String nombrePropietario, int idCuenta) {
        this.nombrePropietario = nombrePropietario;
        this.idCuenta = idCuenta;
        this.balance = 0.0;
    }

    // Método para depositar dinero en la cuenta.
    // Valida que el monto sea mayor a 0 antes de sumarlo al balance actual.
    public void Depositar(double monto) {
        if (monto > 0) {
            balance += monto; // Incrementa el balance de la cuenta.
        } else {
            System.out.println("El monto a depositar debe ser positivo."); // Mensaje de error si el monto no es válido.
        }
    }

    // Método para retirar dinero de la cuenta.
    // Valida que el monto no supere el balance disponible antes de realizar la operación.
    public void Retirar(double monto) {
        if (monto <= balance) {
            balance -= monto; // Reduce el balance de la cuenta.
        } else {
            System.out.println("Fondos insuficientes."); // Mensaje de error si no hay suficiente dinero.
        }
    }

    // Método para transferir dinero entre cuentas bancarias.
    // Valida que la cuenta tenga suficiente balance antes de realizar la transferencia.
    // Si las monedas son diferentes, convierte el monto al tipo de moneda de la cuenta destino.
    public void Transferir(CuentaBancaria destino, double monto) {
        if (monto <= balance) {
            balance -= monto; // Reduce el balance de la cuenta origen.

            // Si las monedas son diferentes, realiza la conversión.
            if (!this.GetTipoMoneda().equals(destino.GetTipoMoneda())) {
                if (destino instanceof CuentaBanco1) {
                    // Si la cuenta destino es de Banco 1 (Dólares), convierte el monto a dólares.
                    monto = Convertir(monto, true);
                } else if (destino instanceof CuentaBanco2) {
                    // Si la cuenta destino es de Banco 2 (Sucres), convierte el monto a sucres.
                    monto = Convertir(monto, false);
                }
            }
            destino.Depositar(monto); // Deposita el monto (convertido si aplica) en la cuenta destino.
        } else {
            System.out.println("Fondos insuficientes para transferir."); // Error si no hay fondos suficientes.
        }
    }

    // Método para convertir el monto entre dólares y sucres.
    // Recibe el monto a convertir y un booleano para indicar si la conversión es a dólares.
    protected double Convertir(double monto, boolean aDolar) {
        final int CONVERSION_RATE = 25000; // Tasa de conversión: 1 dólar = 25000 sucres.
        return aDolar ? monto / CONVERSION_RATE : monto * CONVERSION_RATE;
    }

    // Método para obtener el balance actual de la cuenta.
    public double GetBalance() {
        return balance;
    }

    // Métodos abstractos que deben ser implementados por las subclases.
    // Sirven para obtener información específica del banco y la moneda.
    public abstract String GetNombreBanco(); // Devuelve el nombre del banco.
    public abstract String GetTipoMoneda(); // Devuelve el tipo de moneda (Dólar/Sucre).
    public abstract int GetCantidadCuentas(); // Devuelve la cantidad de cuentas creadas.
}
