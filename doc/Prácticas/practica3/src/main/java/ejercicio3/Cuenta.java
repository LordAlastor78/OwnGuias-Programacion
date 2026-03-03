package ejercicio3;


public class Cuenta {

    private double saldo;
    private static double saldoBanco;

    public Cuenta(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.saldo = saldo;
        saldoBanco += saldo;
    }

    public double retirarSaldo(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a retirar no puede ser negativa");
        }
        if (cantidad > saldo) {
            throw new IllegalArgumentException("No hay suficiente saldo");
        }
        saldo -= cantidad;
        saldoBanco -= cantidad;
        return saldo;
    }

    public double ingresarSaldo(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a ingresar no puede ser negativa");
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

    public static void resetearSaldoBanco() {
        saldoBanco = 0;
    }

    public double getSaldo() {
        return saldo;
    }

}
