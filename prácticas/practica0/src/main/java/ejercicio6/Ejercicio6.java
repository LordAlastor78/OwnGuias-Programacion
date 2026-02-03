package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce un numero entero: ");
            int numero = scanner.nextInt();
            boolean esPrimo = esPrimo(numero);

            if (esPrimo) {
                System.out.println("El numero es primo");
            } else {
                System.out.println("El numero no es primo");
            }

        }

        catch (Exception e) {
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero == 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }

        int limite = (int) Math.sqrt(numero);
        for (int i = 3; i <= limite; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
