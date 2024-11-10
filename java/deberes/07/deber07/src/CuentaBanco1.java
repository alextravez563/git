//Deber07-CuentaBanco1.java
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:10/06/2024
// Fecha de entrega: 12/06/2024
//Resultados:
//La clase CuentaBanco1 implementa las operaciones de depósito, retiro y transferencia para cuentas del Banco Pichincha, con transacciones manejadas en Dólares.
//Las transferencias entre cuentas de diferentes bancos tienen en cuenta las conversiones de moneda, lo que garantiza la compatibilidad entre cuentas de distintas instituciones.
//La implementación de métodos reutiliza eficientemente los métodos protegidos de la clase base CuentaBancaria, evitando duplicación de código.
//Conclusiones:
//La clase CuentaBanco1 hereda correctamente de CuentaBancaria, asegurando una separación clara entre la lógica bancaria genérica y las particularidades del Banco Pichincha.
//El uso del atributo estático cuentasBanco1 permite mantener un registro preciso de cuántas cuentas se han creado en el Banco Pichincha.
//La clase es extensible y fácil de mantener, lo que permite manejar cuentas de múltiples bancos sin modificar las funcionalidades principales.
//Recomendaciones:
//Se recomienda agregar validaciones adicionales en los métodos de retiro y transferencia para evitar errores de saldo insuficiente o cantidades negativas.
//Incluir un manejo de errores más avanzado mediante excepciones personalizadas, en lugar de mensajes de consola, para mejorar la robustez del sistema.
//Para mejorar la escalabilidad, se podría implementar un sistema de seguimiento más detallado del historial de transacciones por cada cuenta.

public class CuentaBanco1 extends CuentaBancaria {
    // Nombre del banco y la moneda predeterminada (Dólar)
    public static final String NOMBRE_BANCO = "Banco Pichincha";
    public static final String MONEDA = "Dólar";

    // Constructor que incrementa el número de cuentas del Banco 1
    public CuentaBanco1(String propietario, double balanceInicial, String idCuenta) {
        super(propietario, balanceInicial, idCuenta);  // Llama al constructor de la clase padre
        cuentasBanco1++;  // Incrementa el contador de cuentas del Banco 1
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
        // Determina la moneda de la cuenta destino (Dólar si es CuentaBanco1, caso contrario utiliza la moneda del Banco 2)
        String monedaDestino = (cuentaDestino instanceof CuentaBanco1) ? MONEDA : CuentaBanco2.MONEDA;

        // Realiza la transferencia utilizando el método protegido de la clase padre
        realizarTransferencia(cuentaDestino, cantidad, MONEDA, monedaDestino);

        // Mensajes que muestran los balances después de la transferencia
        System.out.println("Transferencia realizada. Balance cuenta origen (" + propietario + "): " + balance + " " + MONEDA);
        System.out.println("Balance cuenta destino (" + cuentaDestino.propietario + "): " + cuentaDestino.balance + " " + monedaDestino);
    }
}
