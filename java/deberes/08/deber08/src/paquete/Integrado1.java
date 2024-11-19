
package paquete;

class Integrado1 extends Integrado {
    // constructor integrado1, para crear objetos el tipo Integrado1 pasandole los parametros de la clase padre
    public Integrado1(){
        super(0.7, 0.2, 0.1, 10);
    }

    //Metodo del costo de fabricacion para el integrado1
    @Override
    public double calcularCostoFabricacion(){
        return 200*Math.pow(peso,2)+125*peso;
    }

}



