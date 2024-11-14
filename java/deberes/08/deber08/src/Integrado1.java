public class Integrado1 extends Integrado {
    public Integrado1(int cantidad) {
        super(cantidad);
    }

    @Override
    public double calcularCostoMateriales() {
        double hierro = 0.7 * PRECIOS_MATERIALES.get("hierro");
        double cobre = 0.2 * PRECIOS_MATERIALES.get("cobre");
        double zinc = 0.1 * PRECIOS_MATERIALES.get("zinc");
        return (cantidad / 1000.0) * (hierro + cobre + zinc);
    }

    @Override
    public double calcularCostoFabricacion() {
        double p = (PESO_TOTAL / 1000.0) * cantidad;
        return 200 * Math.pow(p, 2) + 125 * p;
    }
}
