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

    System.out.print("Introduce el servidor (o deja en blanco para 'esei.uvigo.es'): ");

    String servidor = scanner.nextLine();

    if (servidor.isEmpty()) {
        servidor = "esei.uvigo.es";
    }


    DireccionCorreo direccion1 = new DireccionCorreo(nombre, apellidos, usuario, servidor);
    
    DireccionCorreo direccion2 = new DireccionCorreo("Ana", "García López", "ana.garcía", "gmail.com");
    scanner.close();
}
