
package paquete;
class Integrado3 extends Integrado{
    // constructor integrado1, para crear objetos el tipo Integrado1 pasandole los parametros de la clase padre
    public Integrado3(){
        super(0.4, 0, 0.6, 10);
    }
    //Metodo del costo de fabricacion para el integrado3
    @Override
    public double calcularCostoFabricacion(){
        return 2025*peso;
    }
}

