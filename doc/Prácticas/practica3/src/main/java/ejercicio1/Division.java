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

class Division {
    public static int divide(int a, int b) throws NumberFormatException {

        if (b == 0) {

            throw new ArithmeticException(" El denominador no puede ser cero");
        }

        return a / b;

    }

    public static void main(String[] args) {
        int num1;
        int num2;
        String linea;
        Scanner scan = new Scanner(System.in);

        System.out.print("\nIntroduzca dividendo: ");
        linea = scan.nextLine();
        
        num1 = Integer.parseInt(linea); 

        System.out.print("\nIntroduzca divisor: ");
        linea = scan.nextLine();
        num2 = Integer.parseInt(linea);

        System.out.println("\nEl resultado es: " + divide(num1, num2));

        scan.close();
    }
}