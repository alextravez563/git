//Deber08-Integrado3.java
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:17/11/2024
// Fecha de entrega: 19/11/2024
// Resultados:
// * Calcula los costos específicos para el tipo `Integrado3` y proporciona una descripción.

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

/*
Conclusiones:
 * La clase `Integrado3` utiliza la herencia para definir cálculos específicos
 * para el tipo de circuito integrado con alto contenido de zinc.
 *
 * Recomendaciones:
 * 1. Comprender cómo definir y sobrescribir métodos en subclases.
 * 2. Validar los porcentajes de materiales para asegurar cálculos precisos.
 * 3. Revisar el cálculo del peso para adaptarse a cambios en las cantidades.

 * Bibliografía
//Diapositivas del docente
*/