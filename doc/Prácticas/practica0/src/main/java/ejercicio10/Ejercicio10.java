package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        // Implementación equivalente a Ejercicio9 usando métodos
        int[] arr = new int[10];
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print("Introduce el número " + (i + 1) + ": ");
                arr[i] = sc.nextInt();
            }
        }

        System.out.println("Máximo: " + max(arr));
        System.out.println("Mínimo: " + min(arr));
        System.out.println("Promedio: " + avg(arr));
    }

    private static int max(int[] a) {
        int m = a[0];
        for (int v : a) if (v > m) m = v;
        return m;
    }

    private static int min(int[] a) {
        int m = a[0];
        for (int v : a) if (v < m) m = v;
        return m;
    }

    private static double avg(int[] a) {
        int s = 0;
        for (int v : a) s += v;
        return s / (double) a.length;
    }
}
