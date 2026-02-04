package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Introduce un carácter (+,-,*,/): ");
            char op = sc.next().charAt(0);

            System.out.print("Introduce el primer número: ");
            double a = sc.nextDouble();

            System.out.print("Introduce el segundo número: ");
            double b = sc.nextDouble();

            double resultado;
            switch (op) {
                case '+':
                    resultado = a + b;
                    break;
                case '-':
                    resultado = a - b;
                    break;
                case '*':
                    resultado = a * b;
                    break;
                case '/':
                    if (b == 0) {
                        System.out.println("La división no puede realizarse porque el divisor es cero");
                        resultado = Double.NaN;
                    } else {
                        resultado = a / b;
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    resultado = Double.NaN;
            }

            System.out.println("Resultado: " + resultado);
        }
    }
}
