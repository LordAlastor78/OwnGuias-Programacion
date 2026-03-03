package ejercicio3;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Ingrese el saldo inicial: ");
            double saldoInicial = sc.nextDouble();
            Cuenta miCuenta = new Cuenta(saldoInicial);
            System.out.println(miCuenta);
            
            System.out.print("Ingrese cantidad a depositar: ");
            double deposito = sc.nextDouble();
            miCuenta.ingresarSaldo(deposito);
            System.out.println("Tras depositar " + deposito + ": " + miCuenta);
            
            System.out.print("Ingrese cantidad a retirar: ");
            double retiro = sc.nextDouble();
            miCuenta.retirarSaldo(retiro);
            System.out.println("Tras retirar " + retiro + ": " + miCuenta);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Error aritmético: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
