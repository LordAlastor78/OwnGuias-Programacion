package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Aprendiendo Java");
            System.out.println("""
                    Este es mi primer programa en Java
                    """);

            System.out.print("Introduce tu edad: ");
            var edad = leerEntero(scanner, "Introduce tu edad: ");  
            scanner.nextLine();

            System.out.print("Introduce tu nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce tu nota: ");
            var nota = scanner.nextDouble();

            System.out.println("Datos introducidos:");
            System.out.println("Edad: " + edad);
            System.out.println("Nombre: " + nombre);
            System.out.println("Nota: " + nota);


        }


    }
    
    public static int leerEntero(Scanner scan, String mensaje) {

        System.out.print(mensaje);
        int num = scan.nextInt();
        return num; 
    }
}
