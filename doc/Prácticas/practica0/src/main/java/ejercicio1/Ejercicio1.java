package ejercicio1;

/**
Ejercicio 1

En un paquete ejercicio1, clase Ejercicio1, entro del proyecto practica0, crea una clase con el siguiente código:

package ejercicio1; 

public class Ejercicio1 { 
    public static void main(String[] args) { 
        System.out.println("Aprendiendo Java");
    } 
}

    Ejecuta el código (empleando el icono de play visualizando el fichero). Haz cualquier modificación sencilla y vuelve a ejecutar.

    Añade al programa anterior las instrucciones necesarias para que visualice también el mensaje "Este es mi primer programa en Java". Prueba a usar bloque de textos (text blocks).

    Añade al programa una lectura por teclado de edad (entero), nombre (cadena de texto) y nota (decimal) y muestra los datos por salida estándar.

*/

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println(("Aprendiendo Java\nEste es mi primer programa en Java"));

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Introduce tu edad: ");

            int edad = sc.nextInt();

            System.out.println("Introduce tu nombre: ");
            String nombre = sc.next();

            System.out.println("Introduce tu nota: ");
            double nota = sc.nextDouble();

            System.out.println("Edad: " + edad + ", Nombre: " + nombre + ", Nota: " + nota);
        }
    }

}
