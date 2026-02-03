package proii_aedi2;

public class Ejercicio2 {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 2;

        System.out.println("Suma de " + num1 + " y " + num2 + " es: " + suma(num1, num2));
        System.out.println("Resta: " + resta(num1, num2));
        System.out.println("Multiplicación: " + multiplicacion(num1, num2));
        System.out.println("División: " + division(num1, num2));
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
            System.out.println("⚠️  División por cero → resultado = 0");
            return 0;
        }
        return n1 / n2;
    }
}