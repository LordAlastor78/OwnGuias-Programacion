package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = pedirPositivo(scanner);
            long suma = sumarPares(n);
            System.out.println("La suma de los primeros " + n + " numeros pares es: " + suma);
        }
    }

    private static int pedirPositivo(Scanner scanner) {
        int n;
        do {
            System.out.print("Introduce un numero positivo: ");
            n = scanner.nextInt();
        } while (n <= 0);
        return n;
    }

    private static long sumarPares(int n) {
        long suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i * 2L;
        }
        return suma;
    }
}
