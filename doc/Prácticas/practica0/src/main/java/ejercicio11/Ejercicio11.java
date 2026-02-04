package ejercicio11;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Número de estudiantes: ");
            int estudiantes = sc.nextInt();
            System.out.print("Número de notas por estudiante: ");
            int notas = sc.nextInt();

            double[][] matriz = new double[estudiantes][notas];

            for (int i = 0; i < estudiantes; i++) {
                System.out.println("Estudiante " + (i + 1));
                for (int j = 0; j < notas; j++) {
                    System.out.print("  Nota " + (j + 1) + ": ");
                    matriz[i][j] = sc.nextDouble();
                }
            }

            System.out.println("\nNotas registradas:");
            for (int i = 0; i < estudiantes; i++) {
                System.out.print("Estudiante " + (i + 1) + ": ");
                for (int j = 0; j < notas; j++) {
                    System.out.print(" " + matriz[i][j]);
                }
                System.out.println();
            }
        }
    }
}
