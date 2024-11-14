public class Integrado3 extends Integrado {
    public Integrado3(int cantidad) {
        super(cantidad);
    }

    @Override
    public double calcularCostoMateriales() {
        double hierro = 0.4 * PRECIOS_MATERIALES.get("hierro");
        double zinc = 0.6 * PRECIOS_MATERIALES.get("zinc");
        return (cantidad / 1000.0) * (hierro + zinc);
    }

    @Override
    public double calcularCostoFabricacion() {
        double p = (PESO_TOTAL / 1000.0) * cantidad;
        return 2025 * p;
    }
}
