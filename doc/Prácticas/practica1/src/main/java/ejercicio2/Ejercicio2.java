package ejercicio2;

/*Ejercicio 2

Una dirección de correo electrónico se compone de un nombre, 
apellidos, usuario y servidor. 
Las direcciones de correo se visualizan 
como "apellidos, nombre: usuario@servidor". 
Una de estas direcciones de correo se puede 
crear de dos maneras: aportando los cuatro valores,
o solamente dos (apellidos y nombre). 
 En este último caso, se construye el usuario del
correo con el primer apellido, y la inicial del nombre;
 el servidor será siempre "esei.uvigo.es". 
 Crea una clase para manejar dicha información.

Métodos útiles de String:

split(String regex): divide una cadena en un array 
de subcadenas usando el delimitador especificado.
 Ejemplo: "García López".split(" ") devuelve ["García", "López"]
*/

import java.util.Scanner;

public class Ejercicio2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String apellidos = "";
        String nombre = "";

        int opcion = 1;

        System.out
                .println("¿Desea introducir un usuario personalizado o basado en nombres y apellidos? (1: Sí, 0: No)");

        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:

                System.out.println("Introduzca nombre y apellidos (separados por un único espacio)");

                String correo = makeUser(apellidos, nombre);

                System.out.println("El correo electrónico es: " + correo);
                break;

            default:

                System.out.println("Introduzca nombre , apellidos y usuario por separado");

                nombre = sc.nextLine();
                apellidos = sc.nextLine();
                String usuario = sc.nextLine();

                System.out.println(
                        "El correo electrónico es: " + apellidos + nombre + usuario + "@esei.uvigo.es");

                break;
        }
    }

    public static String makeUser(String apellidos, String nombre) {

        System.out.println("Introduzca nombre y apellidos (separados por un único espacio)");

        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Apellidos: ");
        apellidos = sc.nextLine();

    /*  import java.text.Normalizer;
        
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            return "";
        }
    // 1. Normaliza: descompone "á" en "a" + diacrítico

    String normalizado = Normalizer.normalize(nombreCompleto, Normalizer.Form.NFD);

    // 2. Elimina todos los caracteres no ASCII (como acentos, virgulillas, etc.)

    String sinAcentos = normalizado.replaceAll("[^\\p{ASCII}]", "");

    // 3. Quita espacios y convierte a minúsculas

    return sinAcentos.replaceAll("\\s+", "").toLowerCase();
} */

        if (nombre != null && apellidos != null) {

            String inicialNombre = nombre.split("")[0].toLowerCase().charAt(0) + "";
            String apellido1 = apellidos.split(" ")[0];
            String apellido2 = apellidos.split(" ")[1];

            


            return inicialNombre + apellido1 + apellido2 + "@esei.uvigo.es";

        } else {

            return "Error: Nombre o apellidos no válidos.";

        }

    }
}
