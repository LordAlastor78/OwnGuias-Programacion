package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {
    private static final String[] LETRAS = {
            "T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"
    };

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Introduce el número del DNI: ");
            long num = sc.nextLong();
            int resto = (int) (Math.floorMod(num, 23));
            System.out.println("La letra correspondiente es: " + LETRAS[resto]);
        }
    }
}
