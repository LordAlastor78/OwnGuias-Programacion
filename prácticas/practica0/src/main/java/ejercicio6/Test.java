package ejercicio6;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        int numero;
        try { 
            System.out.print("Introduce un numeroero entero: ");

            numero = scanner.nextInt();

            condiciones(numero);

            System.out.println();

            if (condiciones(numero)) {
                System.out.println("El numero es primo");
            } else {
                System.out.println("El numero no es primo");
            }

        } catch (Exception e) {

System.out.println("INTRODUE UN NUMERO VALIDO >:( ");

        }
        scanner.close();
    } 

    public static boolean condiciones(int numero) {

        if (numero < 2) {

            return false;

        }

        if (numero == 2) {

            return true;

        }

        if (numero % 2 == 0) {
            return true;

        }

        var i = 3;

        int raiz = (int) Math.sqrt(numero);

        while (i <= raiz && numero % i != 0) {

            i += 2;

        }

        return (i > raiz);

    }

}