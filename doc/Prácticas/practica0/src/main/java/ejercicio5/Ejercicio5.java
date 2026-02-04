package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n;
            do {
                System.out.print("Introduce un N positivo: ");
                n = sc.nextInt();
            } while (n <= 0);

            int suma = 0;
            for (int i = 1; i <= n; i++) {
                suma += 2 * i; // i-th even number = 2*i
            }

            System.out.println("Suma de los " + n + " primeros números pares: " + suma);
        }
    }
}
