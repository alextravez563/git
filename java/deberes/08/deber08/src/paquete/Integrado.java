//Deber08
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:17/11/2024
// Fecha de entrega: 19/11/2024
//Resultados: El presente programa realiza el ingreso de 10 pedidos donde cada pedido puede ser
// un tipo de integrado de las 3 opciones que existen, ofreciendo el precio por cada uno.

package paquete;

public abstract class Integrado {
    double hierro;
    double cobre;
    double zinc;
    double peso;
    // Construccion de la clase para crear objetos del de las subclases del integrado.
    public Integrado(double hierro, double cobre, double zinc, double peso){
        this.hierro = hierro;
        this.cobre = cobre;
        this.zinc = zinc;
        this.peso = peso;

    }
    // Metodo para calcular el costo de fabricacion
    // como el costo es diferente para cada tipo de integrado, entonces no será un metodo unico para todos,entonces en lugar de usar el mtodo de la clase padre, se usa el metodo abstracto.
    public abstract double calcularCostoFabricacion();

    // Metodo para calcular el costo de materiales
    //Este es del tipo no abstracto, porque el coste de es unico o comun para cada tipo de integrado
    public double calcularCostoMateriales(){
        double costoHierro = (3211 * hierro)*1000;
        double costoCobre = (2705 * cobre)*1000;
        double costoZinc = (3050 * zinc)*1000;
        return costoHierro + costoCobre + costoZinc;
    }
    // Metodo para calcular el precio por los 1000 integrados, cuya formula es:
    // costoMilintegrados= costoMateriales + costoFabricacion
    public double costoMilintegrados(){
        return calcularCostoMateriales() + calcularCostoFabricacion();
    }
    //Metodo para imprimir en pantalla las caracteristicas del integrado
    public void imprimirCaracteristicas(){

        System.out.println("Caracteristicas del integrado: ");
        System.out.println("Hierro: " + hierro);
        System.out.println("Cobre: " +cobre);
        System.out.println("Zinc: "+zinc);
        System.out.println("Peso: "+peso+ "kg");

    }

}
/*Conclusiones:
 * El codigo presentado es un sistema de una fabrica que realiza
 * 3 tipos de circuitos integrados cada uno de diferente composicion
 * quimica, al mismo tiempo que cada uno tiene un precio especifico.
 * Este codigo busca que se realicen 10 pedidos de integrados, donde
 * el usuario en cada pedido podrá escoger cual de 3 tipos prefiere,
 * para posteriormente tener un resumen del precio total de los 10 pedidos
 *
 * Recomendaciomes:
 * Se recomienda que antes de empezar a programar, primeramente se entienda lo que
 * es la creacion de clase, las instacias, contructores y métodos, como se usan y
 * el porque de usarlos.
 * Se recomienda tambien como saber usar los GETTER y SETTER, para que por medio de estos metodos se pueda inclusive simplificar un METODO
 * Se recomienda tambien como saber usar las Superclase, Subclase, Clase abstracta, Interfaz.
 * Se recomienda que se sepa distinguir entre clase abstracta y superclase, porque la
 * realizacion de este programa es necesario saber su diferencia
 * Del mismo modo, tambien es necesario que se conozca la diferencia entre los
 * metodos abstractos y no abstractos, la herencia, la sobre escritura y el uso de ArrayList
 * Bibliografía
//Diapositivas del docente */