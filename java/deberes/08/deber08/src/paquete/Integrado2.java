//Deber08-Integrado2.java
// Nombre: Alex Travez , Mateo Oviedo
// Fecha de realizacion:17/11/2024
// Fecha de entrega: 19/11/2024
//Resultados:
//* Se calcula los costos totales de los circuitos tipo `Integrado2` y ofrece una descripción.

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

/*
Conclusiones:
 * La clase `Integrado2` representa un circuito integrado con diferente composición
 * química y cálculos específicos para costos de fabricación y materiales.
 *
 * Recomendaciones:
 * 1. Comprender el uso de funciones matemáticas como `Math.log` en cálculos.
 * 2. Aprovechar el polimorfismo para implementar métodos comunes en subclases.
 * 3. Validar los cálculos de peso para evitar errores al trabajar con grandes cantidades.

 * Bibliografía
//Diapositivas del docente
*/