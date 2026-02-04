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

        // Mostrar el nombre completo
        System.out.println("Nombre completo: " + nombre + " " + apellidos);

        System.out.print("Introduce el servidor (o deja en blanco para 'esei.uvigo.es'): ");
        String servidor = scanner.nextLine();

        // Crear el objeto DireccionCorreo según los datos proporcionados
        DireccionCorreo dc;
        if (usuario == null || usuario.isEmpty()) {
            // Generar usuario automáticamente
            if (servidor == null || servidor.isEmpty()) {
                dc = new DireccionCorreo(nombre, apellidos);
            } else {
                dc = new DireccionCorreo(nombre, apellidos, servidor);
            }
        } else {
            // Usar usuario proporcionado
            if (servidor == null || servidor.isEmpty()) {
                dc = new DireccionCorreo(nombre, apellidos, usuario, "esei.uvigo.es");
            } else {
                dc = new DireccionCorreo(nombre, apellidos, usuario, servidor);
            }
        }

        System.out.println(dc);

        scanner.close();
    }

}
