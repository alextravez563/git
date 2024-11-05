//Deber06
// Nombre: Alex Travez, Mateo Oviedo
// Fecha de realizacion:04/11/2024
// Fecha de entrega:05/11/2024
//Resultados: modificación del deber05 para que el estado sea de tipo private, y genere los getters y settes que requiera. El estado de sus objetos debe estar protegido.
//*Conclusiones:
//El presente programa tiene la finalidad de crear clases con una orientacion a
//objetos, definiendo al codigo en distintos apartados como: definicion de instancias,
//contructores y métodos, los cuales son declarado previamente al método main
//el motivo, es que el codigo sea más entendible, estructurado y sobreto permitiendo
//lo que la programación orientada a objetos es, modelar objetos del mundo real definiendo
//en entidades, comportamientos y propiedades especificas.

//*Recomendaciomes:
//Se recomienda que antes de empezar a programar, primeramente se entienda lo que
//es la creacion de clase, las instacias, contructores y métodos, como se usan y
//el porque de usarlos.
//Tambien se recomienda que al momento de crear los constructores se entienda el
//uso del THIS, el cual es muy confuso de entender al principio, pero despues es
//casi simple, como: Hey constructor,estas son las características de este objeto en especifico que estoy creando ahora mismo (this moment).
// Se recomienda tambien como saber usar los GETTER y SETTER, para que por medio de estos metodos se pueda inclusive simplificar un METODO

//Bibliografía
//Diapositivas del docente

package paquete;

public class Contador {
    // Atributos en privado

    private int valor;

    // Creacion de CONSTRUCTORES-----------------------------------
    protected Contador() {
        this.valor = 0;
    }

    public Contador(int valorInicial) {
        this.valor = valorInicial;
    }

    // Creacion de METODOS------------------------------------------
    public void incrementar() {
        this.valor++;
    }

    // Creacion de GETTERS---------------------------------
    // GETTER son como los METODOS (se usa public)
    // tambien se usa el TIPO de la variable que tiene en el atributo, es decir INT
    // GETTER, "devuelve" un valor, entonces RETURN
    public int getValor() {
        return valor;
    }

    // Creacion de SETTERS---------------------------------
    // SETTER son como los METODOS(se usa public void)
    // Tienen argumentos de algún tipo, en este caso, el tipo de INT
    // se usa el THIS
    // SETTER "establece" un valor
    public void setValor(int valor) {
        this.valor = valor;
    }

    // Metodo MAIN-------------------------------------------------------
    public static void main(String[] args) {
        // Creacion de objetos
        Contador contadorSello = new Contador();
        Contador contadorCara = new Contador();

        // Realizando el conteo
        for (int i = 0; i < 100; i++) {
            if (Math.random() < 0.5) {
                // Incrementar el contador de caras

                contadorCara.incrementar();
            } else {
                // Incrementar el contador de sellos

                contadorSello.incrementar();
            }
        }
        System.out.println("Se produjeron " + contadorCara.getValor() + " caras");
        System.out.println("Se produjeron " + contadorSello.getValor() + " sellos");
    }

}
