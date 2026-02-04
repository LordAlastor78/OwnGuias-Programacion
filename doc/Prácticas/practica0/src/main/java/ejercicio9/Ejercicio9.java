package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 10; i++) {
                System.out.print("Introduce el número " + (i + 1) + ": ");
                nums[i] = sc.nextInt();
            }
        }

        int max = nums[0];
        int min = nums[0];
        int sum = 0;
        for (int v : nums) {
            if (v > max) max = v;
            if (v < min) min = v;
            sum += v;
        }

        double avg = sum / 10.0;

        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        System.out.println("Promedio: " + avg);
    }
}
