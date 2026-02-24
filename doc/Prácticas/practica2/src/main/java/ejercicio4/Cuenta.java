package ejercicio4;

public class Cuenta {

    private double saldo;
    private static double saldoBanco;

    Cuenta(double saldo) {
        if (saldo < 0) {
            System.err.println("El saldo inicial no puede ser negativo");
            System.exit(1);
            return;
        }

        this.saldo = saldo;
        saldoBanco += saldo;
    }

    public double retirarSaldo(double cantidad) {
        if (cantidad < 0) {
            System.err.println("La cantidad a retirar no puede ser negativa");
            System.exit(1);
            return saldo;
        }

        if (cantidad > saldo) {
            System.err.println("No hay suficiente saldo");
            System.exit(1);
            return saldo;
        }

        saldo -= cantidad;
        saldoBanco -= cantidad;
        return saldo;
    }

    public double ingresarSaldo(double cantidad) {
        if (cantidad < 0) {
            System.err.println("La cantidad a ingresar no puede ser negativa");
            System.exit(1);
            return saldo;

        }

        this.saldo += cantidad;

        saldoBanco += cantidad;

        return saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                '}';
    }

    public static double getSaldoBanco() {
        return saldoBanco;
    }

    public double getSaldo() {
        return saldo;
    }

}
