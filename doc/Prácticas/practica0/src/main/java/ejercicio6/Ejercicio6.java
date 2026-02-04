package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Introduce un número entero: ");
            int n = sc.nextInt();

            if (n <= 1) {
                System.out.println("No es primo");
                return;
            }

            boolean primo = true;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    primo = false;
                    break;
                }
            }

            System.out.println(primo ? "Es primo" : "No es primo");
        }
    }
}
