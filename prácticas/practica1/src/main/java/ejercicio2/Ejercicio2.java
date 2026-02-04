package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el usuario: ");

        String usuario = scanner.nextLine();

        System.out.print("Introduce el nombre: ");

        String nombre = scanner.nextLine();

        System.out.print("Introduce los apellidos: ");

        String apellidos = scanner.nextLine();

        // Mostrar el nombre completo para usar las variables leídas
        System.out.println("Nombre completo: " + nombre + " " + apellidos);

        System.out.print("Introduce el servidor (o deja en blanco para 'esei.uvigo.es'): ");

        String servidor = scanner.nextLine();

        if (servidor.isEmpty()) {
            servidor = "esei.uvigo.es";
        }

        String email = usuario + "@" + servidor;
        System.out.println("El email generado es: " + email);

        scanner.close();
    }

}
