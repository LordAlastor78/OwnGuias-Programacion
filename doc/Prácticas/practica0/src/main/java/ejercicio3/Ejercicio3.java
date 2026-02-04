
package ejercicio3;

/*Ejercicio 3

En un paquete ejercicio3, clase Ejercicio3, escribe un programa que lea por teclado un número entero e indique por pantalla, mediante mensajes que aparecerán en líneas diferentes, las características de dicho número:

    "Número par" si el número es par y "Número impar" en caso contrario.
    "Número cero" si el número es cero y "Número distinto de cero" en caso contrario.
    "Número elevado" si el número es mayor de 100 y "Número bajo" en caso contrario.*/
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        try (Scanner cin = new Scanner(System.in)) {
            System.out.println("Introduce un número entero: ");
            int numero = cin.nextInt();

            if (numero % 2 == 0) {
                System.out.println("Número par");
            } else {
                System.out.println("Número impar");
            }

            if (numero == 0) {
                System.out.println("Número cero");
            } else {
                System.out.println("Número distinto de cero");
            }

            if (numero > 100) {
                System.out.println("Número elevado");
            } else {
                System.out.println("Número bajo");
            }
        }
    }
}
