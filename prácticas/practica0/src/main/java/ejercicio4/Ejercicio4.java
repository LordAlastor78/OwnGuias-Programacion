package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce un caracter (+, -, *, /): ");
            char operador = scanner.next().charAt(0);

            System.out.print("Introduce el primer numero: ");
            double num1 = scanner.nextDouble();

            System.out.print("Introduce el segundo numero: ");
            double num2 = scanner.nextDouble();

            double resultado = calcular(operador, num1, num2);
            System.out.println("Resultado: " + resultado);
        }
    }

    public static double calcular(char operador, double num1, double num2) {
        switch (operador) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("La division no puede realizarse porque el divisor es cero");
                    return Double.NaN;
                }
                return num1 / num2;
            default:
                System.out.println("Opcion incorrecta");
                return Double.NaN;
        }
    }
}
