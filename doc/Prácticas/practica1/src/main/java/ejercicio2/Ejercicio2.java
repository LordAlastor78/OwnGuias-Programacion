package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("¿Desea introducir un usuario personalizado? (1: Sí, 0: No)");
        int opcion = 0;
        try {
            opcion = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            opcion = 0;
        }

        if (opcion == 1) {
            System.out.println("Introduzca nombre:");
            String nombre = sc.nextLine();
            System.out.println("Introduzca apellidos:");
            String apellidos = sc.nextLine();
            System.out.println("Introduzca usuario:");
            String usuario = sc.nextLine();
            System.out.println("Introduzca servidor:");
            String servidor = sc.nextLine();

            Correo c = new Correo(nombre, apellidos, usuario, servidor);
            System.out.println("El correo electrónico es: " + c.toString());

        } else {
            System.out.println("Introduzca nombre:");
            String nombre = sc.nextLine();
            System.out.println("Introduzca apellidos:");
            String apellidos = sc.nextLine();

            Correo c = new Correo(nombre, apellidos);
            System.out.println("El correo electrónico es: " + c.toString());
        }

        sc.close();
    }
}
