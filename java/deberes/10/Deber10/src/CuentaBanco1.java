// Clase que representa una cuenta del Banco 1 (Banco Pichincha).
// Maneja cuentas con la moneda "Dólar".
class CuentaBanco1 extends CuentaBancaria {
    private static final String nombreBanco = "Banco Pichincha"; // Nombre del banco, constante e inmutable.
    private static final String tipoMoneda = "Dolar"; // Tipo de moneda utilizado por el banco.
    private static int contadorCuentas = 0; // Contador de cuentas creadas en Banco Pichincha.

    // Constructor: Inicializa una cuenta del Banco Pichincha con el propietario y un ID único.
    public CuentaBanco1(String nombrePropietario, int idCuenta) {
        super(nombrePropietario, idCuenta); // Llama al constructor de la clase base.
        contadorCuentas++; // Incrementa el contador de cuentas creadas para Banco Pichincha.
    }

    // Implementación del método abstracto para obtener el nombre del banco.
    @Override
    public String GetNombreBanco() {
        return nombreBanco; // Devuelve "Banco Pichincha".
    }

    // Implementación del método abstracto para obtener el tipo de moneda.
    @Override
    public String GetTipoMoneda() {
        return tipoMoneda; // Devuelve "Dólar".
    }

    // Implementación del método abstracto para obtener la cantidad de cuentas creadas.
    @Override
    public int GetCantidadCuentas() {
        return contadorCuentas; // Devuelve el número de cuentas creadas en Banco Pichincha.
    }
}
