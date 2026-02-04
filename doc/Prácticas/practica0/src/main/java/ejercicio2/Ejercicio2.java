/*Ejercicio 2

En un paquete ejercicio2, clase Ejercicio2, 
ejecuta el siguiente programa que declara dos 
números enteros, los suma a través de un método suma 
y finalmente muestra el resultado.


package ejercicio2; 

public class Ejercicio2 { 

  public static void main(String[] args) { 
     var num1 = 5; 
     var num2 = 2;  
     System.out.println("Suma de " + num1 + " y " + num2 + " es: " + suma(num1, num2)); 
  } 

  public static int suma (int n1, int n2) { 
      return n1 + n2; 
  }     

} 

Añade código al programa anterior para que realice, mediante métodos, 
las cuatro operaciones aritméticas básicas (suma, resta, multiplicación y división) sobre los dos números enteros. 
Se debe controlar que el divisor no sea cero, en cuyo caso el resultado de la división deberá ser 0. */

package ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) {
        var num1 = 5;
        var num2 = 2;

        System.out.println("Suma de " + num1 + " y " + num2 + " es: " + suma(num1, num2));

        System.out.println("Resta de " + num1 + " y " + num2 + " es: " + resta(num1, num2));

        System.out.println("Multiplicación de " + num1 + " y " + num2 + " es: " + multiplicacion(num1, num2));

        System.out.println("División de " + num1 + " y " + num2 + " es: " + division(num1, num2));
    }

    public static int suma(int n1, int n2) {
        return n1 + n2;
    }

    public static int resta(int n1, int n2) {
        return n1 - n2;
    }

    public static int multiplicacion(int n1, int n2) {
        return n1 * n2;
    }

    public static int division(int n1, int n2) {
        if (n2 == 0) {
            return 0;
        }
        return n1 / n2;
    }

}
