import java.util.Map;

public abstract class Integrado {
    protected int cantidad;
    protected static final double PESO_TOTAL = 10.0;
    protected static final Map<String, Double> PRECIOS_MATERIALES = Map.of(
            "hierro", 3211.0,
            "cobre", 2705.0,
            "zinc", 3050.0
    );

    public Integrado(int cantidad) {
        this.cantidad = cantidad;
    }

    public abstract double calcularCostoMateriales();
    public abstract double calcularCostoFabricacion();

    public double calcularPresupuestoTotal() {
        return calcularCostoMateriales() + calcularCostoFabricacion();
    }
}
