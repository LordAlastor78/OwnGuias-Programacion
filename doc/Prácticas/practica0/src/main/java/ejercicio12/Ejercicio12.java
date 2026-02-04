package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[][] m = new int[3][3];
            System.out.println("Introduce 9 enteros para la matriz 3x3:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                    m[i][j] = sc.nextInt();
                }
            }

            System.out.print("Introduce el número a buscar: ");
            int target = sc.nextInt();

            boolean encontrado = false;
            int fila = -1, col = -1;
            for (int i = 0; i < 3 && !encontrado; i++) {
                for (int j = 0; j < 3; j++) {
                    if (m[i][j] == target) {
                        encontrado = true;
                        fila = i + 1; // 1-based
                        col = j + 1;
                        break;
                    }
                }
            }

            if (encontrado) {
                System.out.println("Primera ocurrencia en fila " + fila + ", columna " + col);
            } else {
                System.out.println("El número no se encuentra en la matriz");
            }
        }
    }
}
