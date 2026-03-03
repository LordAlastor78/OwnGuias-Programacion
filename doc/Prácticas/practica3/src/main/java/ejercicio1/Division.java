package ejercicio1;
/*Ejercicio 1

Dado el siguiente código,
 completa con el control de excepciones que sea necesario. 
 a) lanza tú mismo la excepción desde el método divide(...), o bien 
 b) deja que sea la operación aritmética de dividir (/) la que 
 lance su propia excepción (dividir por 0 también genera una excepción 
 automáticamente), en cuyo caso, prueba el código antes y observa qué
  excepción se lanza si pedimos una división por cero. 
  Captura dicha excepción (la que tú hayas decido lanzar,
   o la que se lanza sóla) en el main para mostrar un mensaje al usuario.
Por otra parte, valida la entrada del usuario también mediante 
excepciones. Concretamente, el método Integer.parseInt de Java puede
lanzar una excepción de tipo NumberFormatException en el caso de que
la entrada no sea un entero. Captura esta excepción y vuelve a 
pedir al usuario las veces que sea necesario hasta que introduzca 
un número correcto. */

import java.util.Scanner;

public class Division {

    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) { // Si el divisor es cero, se lanza una excepción de tipo ArithmeticException
            throw new ArithmeticException("División por cero no permitida");
        }
        return a / b;
    }

    public static void main(String[] args) {
        int num1;
        int num2;
        String linea;
        Scanner scan = new Scanner(System.in);

        num1 = leerEntero(scan, "Introduzca dividendo: "); // Se puede usar el mismo método para ambos números, ya que el mensaje se le pasa como argumento

        num2 = leerEntero(scan, "Introduzca divisor: ");

        try {
            System.out.println("\nEl resultado es: " + divide(num1, num2));
        } catch (ArithmeticException e) { // Si se produce una división por cero, se captura la excepción y se muestra un mensaje de error
            System.out.println("No se puede dividir por cero: " + e.getMessage());
        }

        scan.close();

    }

    private static int leerEntero(Scanner entrada, String mensaje) {

        String linea;
        int num;

        while (true) { // Bucle infinito hasta que se introduzca un número entero válido

            System.out.println("\n " + mensaje);

            linea = entrada.nextLine();
            try { // Intentamos convertir la entrada a un número entero
                return Integer.parseInt(linea); // Si la conversión es exitosa, se devuelve el número entero
            } catch (NumberFormatException e) { // Si la conversión falla, se captura la excepción y se muestra un mensaje de error

                System.out.println("Solo numeros enteros" + e.getMessage()); // Se muestra el mensaje de error y se vuelve a pedir la entrada
            }   
        }

    }

}