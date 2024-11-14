public class Pedido {
    private final Integrado integrado;

    public Pedido(int tipo, int cantidad) {
        switch (tipo) {
            case 1 -> this.integrado = new Integrado1(cantidad);
            case 2 -> this.integrado = new Integrado2(cantidad);
            case 3 -> this.integrado = new Integrado3(cantidad);
            default -> throw new IllegalArgumentException("Tipo de integrado no válido");
        }
    }

    public double obtenerPresupuesto() {
        return integrado.calcularPresupuestoTotal();
    }

    @Override
    public String toString() {
        return "Pedido - Tipo: " + integrado.getClass().getSimpleName() +
                ", Cantidad: " + integrado.cantidad +
                ", Presupuesto: " + String.format("%.2f", obtenerPresupuesto()) + " USD";
    }
}
