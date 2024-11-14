//Deber05
// Nombre: Alex Travez, Mateo Oviedo
// Fecha de realizacion:28/10/2024
// Fecha de entrega:29/10/2024
//Resultados: El código funciona correctamente de acuerdo a las instrucciones que se han dispuesto
// *Conclusiones:
//El codigo incluye comentarios que expliquen la intencion detras de ciertas practicas y conceptos de programacion orientada a objetos y esto es util para otros desarrolladores puedan ler y mantener el codigo .
//El presente programa tiene la finalidad de crear clases con una orientacion a
//objetos, definiendo al codigo en distintos apartados como: definicion de instancias,
//contructores y métodos, los cuales son declarado previamente al metodo main
//el motivo, es que el codigo sea más entendible, estructurado y sobreto permitiendo
//lo que la programación orientada a objetos es, modelar objetos del mundo real definiendo
//en entidades, comportamientos y propiedades especificas.

// *Recomendaciomes:
//Se recomienda que antes de empezar a programar, primeramente se entienda lo que
// es la creacion de clase, las instacias, contructores y métodos, como se usan y
//el porque de usarlos.
//Tambien se recomienda que al momento de crear los constructores se entienda el
//uso del THIS, el cual es muy confuso de entender al principio, pero despues es
//casi simple, como: Hey constructor,estas son las características de este objeto en especifico que estoy creando ahora mismo (this moment).
// se recomienda no declarar variables para el contador de hecho esa practica estaria mal abriendo espacio en la memoria.
//Bibliografía
//Diapositivas del docente


public class Contador {
    // Variable de instancia que representa el valor del contador
    private int cuenta;

    // Constructor por defecto que inicializa la cuenta en 0
    public Contador() {

        this.cuenta = 0;
    }

    // Constructor que acepta como argumento el valor inicial de la cuenta
    public Contador(int cuentaInicial) {

        this.cuenta = cuentaInicial;
    }
    // Método para incrementar el contador en 1
    public void incrementar() {
        this.cuenta++;

    }


    // Método para obtener el valor del contador
    public int obtenerValor() {

        return this.cuenta;
    }
}
