package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {
    private static final String TABLA = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce el numero de DNI: ");
            long numero = scanner.nextLong();
            char letra = calcularLetra(numero);
            System.out.println("La letra del DNI es: " + letra);
        }
    }

    public static char calcularLetra(long numero) {
        int indice = Math.floorMod(numero, 23);
        return TABLA.charAt(indice);
    }
}
