//Deber07
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:10/06/2024
// Fecha de entrega: 12/06/2024
//Resultados:
//1-La clase CuentaBancaria establece una estructura sólida para cuentas bancarias con capacidad de depositar, retirar, transferir fondos, y manejar conversiones entre monedas.
//2-Se incluye la conversión entre Dólar y Sucre, lo que permite manejar transacciones en diferentes monedas.
//3- Las funcionalidades de depósito, retiro y transferencia están encapsuladas en métodos protegidos, lo que permite que las clases derivadas las usen sin riesgo de acceso externo.
//Conclusiones:
//El uso de métodos abstractos asegura que cualquier clase hija que extienda de CuentaBancaria deba implementar las operaciones esenciales como depositar, retirar y transferir.
//La clase está diseñada para ser reutilizable y flexible, permitiendo la implementación de cuentas específicas de distintos bancos y con diferentes reglas.
//Las conversiones de monedas se realizan de manera eficiente y con facilidad para futuras extensiones en caso de añadir más monedas.
//Recomendaciones:
//Implementar validaciones adicionales en los métodos de transferencia y retiro, como límites de transacciones o restricciones por tipo de cuenta.
//Mejorar la gestión de errores agregando excepciones personalizadas en lugar de simples mensajes de consola, para un manejo más robusto de fallos.
//Considerar la creación de una interfaz para la conversión de monedas, lo que permitiría implementar fácilmente nuevas monedas sin modificar el código existente.

public abstract class CuentaBancaria {
    // Atributos protegidos que definen al propietario, balance e id de la cuenta bancaria
    protected String propietario;
    protected double balance;
    protected final String idCuenta; // La id de la cuenta no puede ser modificada una vez creada
    protected static int cuentasBanco1 = 0; // Contador de cuentas del Banco 1
    protected static int cuentasBanco2 = 0; // Contador de cuentas del Banco 2

    // Constante para la tasa de conversión de Dólar a Sucre
    public static final double CONVERSION_DOLAR_A_SUCRE = 25000;

    // Constructor que inicializa el propietario, balance e id de la cuenta
    public CuentaBancaria(String propietario, double balanceInicial, String idCuenta) {
        this.propietario = propietario;
        this.balance = balanceInicial;
        this.idCuenta = idCuenta;
    }

    // Métodos abstractos que deberán ser implementados en las clases hijas
    public abstract void depositar(double cantidad);
    public abstract void retirar(double cantidad);
    public abstract void transferir(CuentaBancaria cuentaDestino, double cantidad);

    // Método privado para convertir entre Dólar y Sucre
    private double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
        if (monedaOrigen.equals("Dólar") && monedaDestino.equals("Sucre")) {
            return cantidad * CONVERSION_DOLAR_A_SUCRE; // Conversión de Dólar a Sucre
        } else if (monedaOrigen.equals("Sucre") && monedaDestino.equals("Dólar")) {
            return cantidad / CONVERSION_DOLAR_A_SUCRE; // Conversión de Sucre a Dólar
        }
        return cantidad; // Si las monedas son iguales, no se realiza conversión
    }

    // Métodos estáticos para mostrar información de los bancos 1 y 2
    public static void infoBanco1() {
        System.out.println("Banco 1 - Nombre: " + CuentaBanco1.NOMBRE_BANCO + ", Cuentas: " + cuentasBanco1);
    }

    public static void infoBanco2() {
        System.out.println("Banco 2 - Nombre: " + CuentaBanco2.NOMBRE_BANCO + ", Cuentas: " + cuentasBanco2);
    }

    // Método protegido para realizar un depósito
    protected void realizarDeposito(double cantidad) {
        if (cantidad > 0) {
            this.balance += cantidad; // Aumenta el balance si la cantidad es positiva
        } else {
            System.out.println("No se puede depositar una cantidad negativa."); // Mensaje de error si la cantidad es negativa
        }
    }

    // Método protegido para realizar un retiro
    protected void realizarRetiro(double cantidad) {
        if (cantidad > 0 && cantidad <= this.balance) {
            this.balance -= cantidad; // Disminuye el balance si la cantidad es válida y menor o igual al balance actual
        } else {
            System.out.println("Retiro inválido. Verifique la cantidad."); // Mensaje de error si la cantidad es inválida
        }
    }

    // Método protegido para realizar una transferencia entre cuentas
    protected void realizarTransferencia(CuentaBancaria cuentaDestino, double cantidad, String monedaOrigen, String monedaDestino) {
        if (cantidad > 0 && cantidad <= this.balance) {
            // Convierte la cantidad si las monedas de origen y destino son diferentes
            double cantidadConvertida = (monedaOrigen.equals(monedaDestino)) ? cantidad : convertir(cantidad, monedaOrigen, monedaDestino);
            this.balance -= cantidad; // Se descuenta la cantidad de la cuenta origen
            cuentaDestino.realizarDeposito(cantidadConvertida); // Se deposita la cantidad convertida en la cuenta destino
        } else {
            System.out.println("Transferencia inválida. Verifique la cantidad o el saldo."); // Mensaje de error si la transferencia es inválida
        }
    }
}
