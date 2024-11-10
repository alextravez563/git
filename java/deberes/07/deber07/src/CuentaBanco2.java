//Deber07-CuentaBanco2.java
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:10/06/2024
// Fecha de entrega: 12/06/2024
//Resultados:
//La clase CuentaBanco2 gestiona correctamente operaciones de depósito, retiro y transferencia, utilizando la moneda Sucre para las cuentas del Banco de Guayaquil.
//Se ha implementado la capacidad de realizar transferencias entre cuentas de distintos bancos, manejando adecuadamente la conversión entre monedas.
//Las operaciones son realizadas eficientemente utilizando los métodos heredados de la clase base, manteniendo la coherencia y simplicidad del diseño.
//Conclusiones:
//La clase CuentaBanco2 sigue el mismo patrón de diseño que CuentaBanco1, demostrando cómo la herencia y la abstracción ayudan a reducir la duplicación de código.
//La correcta implementación de la moneda Sucre permite manejar cuentas y transacciones dentro de un contexto económico diferente, destacando la flexibilidad del diseño.
//La solución es extensible, ya que facilita la integración de más bancos en el futuro sin necesidad de reestructurar el sistema central.
//Recomendaciones:
//Se sugiere incluir un sistema de auditoría para las transacciones que registre cada operación con detalles como la fecha y hora, aumentando la trazabilidad de las transacciones.
//Implementar límites específicos para las transacciones en función de las políticas de cada banco, por ejemplo, límites de retiro diario o de transferencia máxima.
//Considerar la adición de una capa de seguridad que verifique la identidad del usuario antes de permitir transacciones críticas como retiros o transferencias.

public class CuentaBanco2 extends CuentaBancaria {
    // Nombre del banco y la moneda predeterminada (Sucre)
    public static final String NOMBRE_BANCO = "Banco de Guayaquil";
    public static final String MONEDA = "Sucre";

    // Constructor que incrementa el número de cuentas del Banco 2
    public CuentaBanco2(String propietario, double balanceInicial, String idCuenta) {
        super(propietario, balanceInicial, idCuenta);  // Llama al constructor de la clase padre
        cuentasBanco2++;  // Incrementa el contador de cuentas del Banco 2
    }

    // Implementación del método depositar
    @Override
    public void depositar(double cantidad) {
        realizarDeposito(cantidad);  // Llama al método protegido de la clase padre
        System.out.println("Depósito realizado en " + propietario + ". Nuevo balance: " + balance + " " + MONEDA);
    }

    // Implementación del método retirar
    @Override
    public void retirar(double cantidad) {
        realizarRetiro(cantidad);  // Llama al método protegido de la clase padre
        System.out.println("Retiro realizado en " + propietario + ". Nuevo balance: " + balance + " " + MONEDA);
    }

    // Implementación del método transferir
    @Override
    public void transferir(CuentaBancaria cuentaDestino, double cantidad) {
        // Determina la moneda de la cuenta destino (Sucre si es CuentaBanco2, caso contrario utiliza la moneda del Banco 1)
        String monedaDestino = (cuentaDestino instanceof CuentaBanco2) ? MONEDA : CuentaBanco1.MONEDA;

        // Realiza la transferencia utilizando el método protegido de la clase padre
        realizarTransferencia(cuentaDestino, cantidad, MONEDA, monedaDestino);

        // Mensajes que muestran los balances después de la transferencia
        System.out.println("Transferencia realizada. Balance cuenta origen (" + propietario + "): " + balance + " " + MONEDA);
        System.out.println("Balance cuenta destino (" + cuentaDestino.propietario + "): " + cuentaDestino.balance + " " + monedaDestino);
    }
}
