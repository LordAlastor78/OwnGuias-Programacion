package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] valores = new int[10];

            for (int i = 0; i < valores.length; i++) {
                System.out.print("Introduce el numero " + (i + 1) + ": ");
                valores[i] = scanner.nextInt();
            }

            int max = maximo(valores);
            int min = minimo(valores);
            double promedio = promedio(valores);

            System.out.println("Valor maximo: " + max);
            System.out.println("Valor minimo: " + min);
            System.out.println("Promedio: " + promedio);
        }
    }

    public static int maximo(int[] valores) {
        int max = valores[0];
        for (int valor : valores) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }

    public static int minimo(int[] valores) {
        int min = valores[0];
        for (int valor : valores) {
            if (valor < min) {
                min = valor;
            }
        }
        return min;
    }

    public static double promedio(int[] valores) {
        long suma = 0;
        for (int valor : valores) {
            suma += valor;
        }
        return (double) suma / valores.length;
    }
}
