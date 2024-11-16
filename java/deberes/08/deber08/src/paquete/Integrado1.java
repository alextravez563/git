//Deber08-Integrado1.java
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:17/11/2024
// Fecha de entrega: 19/11/2024
// / Resultados:
// * Esta clase calcula los costos específicos y devuelve una descripción del integrado.

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

/*
Conclusiones:
 * La clase `Integrado1` modela un circuito integrado con composición química
 * específica y un cálculo de costos de fabricación y materiales.
 *
 * Recomendaciones:
 * 1. Usar constantes para representar valores fijos como porcentajes y precios.
 * 2. Entender cómo implementar métodos abstractos definidos en la superclase.
 * 3. Asegurarse de que los cálculos sean precisos al trabajar con números decimales.
 * Bibliografía
//Diapositivas del docente
*/


