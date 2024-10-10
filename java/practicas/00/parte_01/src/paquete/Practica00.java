package paquete;

//*************************************************
//Práctica 00
//Mateo Oviedo/Alex Trávez
//Fecha de realizacion: 08/10/2024
//Fecha de entrega: 10/10/2024
//Resultados:
//* El codigo permite generar una tabla
//con potencias, otra tabla con angulos en grados
//radianes, su seno y coseno y por ultimo mostrar 
//el area de un triángulo
//Conclusiones:
//*El código refleja una implementación exacta de las instrucciones proporcionadas,
// asegurando que los pasos indicados para mostrar potencias,
// conversiones de ángulos y el cálculo de áreas se sigan correctamente.
//
//*Siguiendo el pdf de la práctica00 paso a paso,
// se refuerzan conceptos básicos de programación como el uso de funciones, 
// bucles y cálculos matemáticos, consolidando habilidades de programación
// además del conocimiento de la herramienta de debug o depuración con los puntos de parada.
//Recomendaciones:
//* Al seguir la practica, es importante no solo copiar el código,
// sino también comprender cada paso y experimentar con modificaciones.
// Por ejemplo, cambiar los rangos o valores de entrada en las funciones puede ayudar
// a reforzar los conceptos y descubrir cómo afecta el resultado,
// facilitando un aprendizaje más profundo y aplicable en otros contextos.
//
//* Para guardar y poder cargar el archivo en algún lugar, como en este caso
//  el aula virtual o compartirlo con algún compañero, es necesario comprimir el archivo
//	una vez tengamos guardados todos los cambios.
//Bibliografia:
//* PDF, Práctica00.
//* PDF, Hoja Resumen del Lenguaje Java.
//**************************************************

public class Practica00 {

	public static void main(String[] args) {

		System.out.println("Esta es una prueba en Eclipse de: Mateo y Alex");

		System.out.println();
		mostrarPotencias(5, 10);

		System.out.println();
		mostrarAngulos(0, 180);

		System.out.println();
		calculoAreaTriangulo(3, 2);

	}

	public static void mostrarPotencias(int desde, int hasta) {
		System.out.println("x << x^2 << x^3");
		for (int x = desde; x <= hasta; x = x + 1) {
			System.out.println(x + "<<" + x * x + "<<" + x * x * x);

		}
	}

	public static void mostrarAngulos(int desde, int hasta) {
		double PI = 3.141592653589793;

		System.out.println("grados << radianes << seno << coseno");
		for (double x = desde; x <= hasta; x = x + 5.0) {
			double radianes;
			radianes = x * PI / 180.0;
			System.out.println(x + " << " + radianes + " << " + Math.sin(radianes) + " << " + Math.cos(radianes));
		}
	}

	public static void calculoAreaTriangulo(int base, int altura) {
		double area = (base * altura) / 2;
		System.out.println("(base * altura / 2 = area) >> " + "(" + base + " * " + altura + " / 2 = " + area + ")");
	}

}
