package ejercicio8;

import java.util.Scanner;

public class Test8 {

    public static void main(String[] args) {

        System.out.println("Introduce el DNI para calcular la letra");

        try (Scanner input = new Scanner(System.in)) {

            int dni = input.nextInt();

            String letraDNI = "TRWAGMYFPDXBNJZSQVHLCKE";

            char numberLetter = letraDNI.charAt(dni % 23);

            System.out.println("La letra del DNI " + dni + " es: " + numberLetter);

        }



    }

}
