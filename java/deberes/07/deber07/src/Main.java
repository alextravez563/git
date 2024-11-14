//Deber07-main.java
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:10/06/2024
// Fecha de entrega: 12/06/2024
//Resultados:
//Se crean dos cuentas: una para Alex en Banco Pichincha con un saldo inicial de 1000 dólares, y otra para Mateo en Banco de Guayaquil con 2,500,000 sucres.
//Se realizan operaciones bancarias: depósito de 500 dólares en la cuenta de Alex, retiro de 1,000,000 sucres de la cuenta de Mateo y transferencia de 20 dólares de Alex a Mateo, con conversión de moneda.
//Se muestra la información del número de cuentas creadas en cada banco, demostrando que el contador de cuentas funciona correctamente.
//Conclusiones:
//La clase Main implementa correctamente las operaciones de cuentas bancarias, demostrando el funcionamiento de depósitos, retiros y transferencias entre cuentas de distintos bancos y monedas.
//El código muestra la capacidad de los sistemas de banca para manejar conversiones de moneda automáticamente, mejorando la flexibilidad del sistema en un entorno multi-divisa.
//El manejo de las cuentas y las operaciones es sencillo y eficiente, gracias a la correcta implementación de la herencia y los métodos reutilizables en las clases base.
//Recomendaciones:
//Se recomienda manejar posibles excepciones en las operaciones, como saldo insuficiente o errores en la conversión de moneda, utilizando bloques try-catch para evitar interrupciones del programa.
//Se podría añadir una interfaz gráfica o un menú interactivo para que los usuarios puedan realizar operaciones de manera más accesible y amigable.
//Incluir más pruebas y escenarios, como transferencias entre múltiples cuentas o validaciones más estrictas sobre los datos ingresados, para mejorar la robustez y la fiabilidad del sistema.

public class Main {
    public static void main(String[] args) {
        // Crear cuentas para Alex en Banco Pichincha (Dólar) y Mateo en Banco de Guayaquil (Sucre)
        CuentaBanco1 cuentaAlex = new CuentaBanco1("Alex", 1000, "ID1");
        CuentaBanco2 cuentaMateo = new CuentaBanco2("Mateo", 2500000, "ID2");

        // Realizar operaciones en ambas cuentas
        cuentaAlex.depositar(500);           // Depositar 500 dólares en la cuenta de Alex
        cuentaMateo.retirar(1000000);        // Retirar 1,000,000 sucres de la cuenta de Mateo
        cuentaAlex.transferir(cuentaMateo, 20);  // Transferir 20 dólares de la cuenta de Alex a la cuenta de Mateo

        // Mostrar la información del número de cuentas creadas en ambos bancos
        CuentaBancaria.infoBanco1();  // Información del Banco 1 (Banco Pichincha)
        CuentaBancaria.infoBanco2();  // Información del Banco 2 (Banco de Guayaquil)
    }
}
