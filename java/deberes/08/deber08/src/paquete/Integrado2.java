
package paquete;

class Integrado2 extends Integrado {
    // constructor integrado1, para crear objetos el tipo Integrado1 pasandole los parametros de la clase padre
    public Integrado2(){
        super(0.3, 0.3, 0,10);
    }

    //Metodo del costo de fabricacion para el integrado2
    @Override
    public double calcularCostoFabricacion(){
        return Math.log(peso) * peso +25*peso;
    }
}

