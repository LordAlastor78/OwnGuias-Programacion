package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce un numero entero: ");
            int numero = scanner.nextInt();

            if (numero % 2 == 0) {
                System.out.println("Numero par");
            } else {
                System.out.println("Numero impar");
            }

            if (numero == 0) {
                System.out.println("Numero cero");
            } else {
                System.out.println("Numero distinto de cero");
            }

            if (numero > 100) {
                System.out.println("Numero elevado");
            } else {
                System.out.println("Numero bajo");
            }
        }
    }
}
