package proii_aedi2;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            int numero;
            System.out.print("Introduce un número entero: ");

            while (!entrada.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor introduce un número entero:");
                entrada.next(); // descartar token inválido
            }

            numero = entrada.nextInt();

            if (numero % 2 == 0) {
                System.out.println("El número " + numero + " es par.");
            } else {
                System.out.println("El número " + numero + " es impar.");
            }
        }
    }

}
