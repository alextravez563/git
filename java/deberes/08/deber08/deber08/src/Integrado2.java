public class Integrado2 extends Integrado {
    public Integrado2(int cantidad) {
        super(cantidad);
    }

    @Override
    public double calcularCostoMateriales() {
        double hierro = 0.3 * PRECIOS_MATERIALES.get("hierro");
        double cobre = 0.3 * PRECIOS_MATERIALES.get("cobre");
        return (cantidad / 1000.0) * (hierro + cobre);
    }

    @Override
    public double calcularCostoFabricacion() {
        double p = (PESO_TOTAL / 1000.0) * cantidad;
        return Math.log(p) * p + 25 * p;
    }
}
