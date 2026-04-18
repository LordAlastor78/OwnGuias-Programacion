package ejercicio2;

/*Ejercicio 4

Crea una clase Calculadora que permita realizar operaciones matemáticas mediante 
sobrecarga de métodos. La clase debe tener métodos para:

    Sumar dos números enteros
    Sumar tres números enteros
    Sumar dos números decimales (double)
    Multiplicar dos números enteros
    Multiplicar un número entero por un decimal
    Aplicar un descuento porcentual a un precio (recibe precio y porcentaje de descuento)
    
    

En vez de probar la clase Calculadora en el método main, 
empleando JUnit 5, crea un CalculadoraTest. Para introducirte en JUnit 5 y 
resolver el ejercicio debes consultar la documentación que te aportamos. 

*/

import java.util.Scanner;

public class ejercicio2 {

   public static void main(String[] args) {

      Calculadora calc = new Calculadora();

      Scanner scanner = new Scanner(System.in);

      System.out.println("""
            Que quieres hacer ? :

            -Sumar
            -Restar
            -ApplyDiscount
            """);

      String choice;

      choice = scanner.nextLine();

      switch (choice) {
         case "Sumar":

            try {

               int a = scanner.nextInt();

               int b = scanner.nextInt();

               calc.suma(a, b);

            } catch (Exception e) {
               System.out.println("Introduce un numero valido");
            }

            break;

         case "Restar":

            System.out.println("Loquesea");

         case "ApplyDiscount":

            try {

            } catch (Exception e) {

               float precio = scanner.nextFloat();

               float discount = scanner.nextFloat();

               calc.applyDiscount(precio, discount);

               scanner.nextLine();
               System.out.println("Introduce un numero valido");
            }

            break;

         default:

            System.out.println("Introduce una opcion valida");

            break;

      }

   }

}
