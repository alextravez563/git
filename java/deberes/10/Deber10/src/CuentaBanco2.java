// Clase que representa una cuenta del Banco 2 (Banco La Previsora).
// Maneja cuentas con la moneda "Sucre".
class CuentaBanco2 extends CuentaBancaria {
    private static final String nombreBanco = "Banco La Previsora"; // Nombre del banco, constante e inmutable.
    private static final String tipoMoneda = "Sucre"; // Tipo de moneda utilizado por el banco.
    private static int contadorCuentas = 0; // Contador de cuentas creadas en Banco La Previsora.

    // Constructor: Inicializa una cuenta del Banco La Previsora con el propietario y un ID único.
    public CuentaBanco2(String nombrePropietario, int idCuenta) {
        super(nombrePropietario, idCuenta); // Llama al constructor de la clase base.
        contadorCuentas++; // Incrementa el contador de cuentas creadas para Banco La Previsora.
    }

    // Implementación del método abstracto para obtener el nombre del banco.
    @Override
    public String GetNombreBanco() {
        return nombreBanco; // Devuelve "Banco La Previsora".
    }

    // Implementación del método abstracto para obtener el tipo de moneda.
    @Override
    public String GetTipoMoneda() {
        return tipoMoneda; // Devuelve "Sucre".
    }

    // Implementación del método abstracto para obtener la cantidad de cuentas creadas.
    @Override
    public int GetCantidadCuentas() {
        return contadorCuentas; // Devuelve el número de cuentas creadas en Banco La Previsora.
    }
}
