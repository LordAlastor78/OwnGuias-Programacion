package proii_aedi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Aprendiendo Java");

            System.out.println("""
                    esta es mi primera linea
                    esta es mi segunda linea
                    esta es la ultima linea
                        esta es una linea con sangria
                        esta es otra linea con sangria
                    """);

            System.out.print("Edad: ");
            int edad = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Nombre: ");
            String nombre = entrada.nextLine();

            System.out.print("Nota: ");
            double nota = entrada.nextDouble();

            System.out.println("la edad es: " + edad);
            System.out.println("El nombre es " + nombre);
            System.out.println("la nota es: " + nota);
        }
    }
}