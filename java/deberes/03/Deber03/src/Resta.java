import java.util.Scanner;

public class Resta {
    public static void main(String[] args) {
        int a,b;
        System.out.println("Bienvenido a la calculadora de resta by Mateo Oviedo y Alex Travez");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número: ");
        a = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        b = sc.nextInt();
        System.out.println("Resultado: " + a + " - " + b + " = " + (a-b));
    }
}
