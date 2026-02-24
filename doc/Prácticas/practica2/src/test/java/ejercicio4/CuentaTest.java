package ejercicio4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaTest {


    @Test

    public void ingresarDinero() { // Test para verificar que el método ingresarSaldo funciona correctamente y actualiza el saldo del banco
        double saldoInicialBanco = Cuenta.getSaldoBanco();


        Cuenta cuenta = new Cuenta(1000);
        cuenta.ingresarSaldo(500);

        double saldoEsperado = saldoInicialBanco + 1500;
        double saldoActual = Cuenta.getSaldoBanco();

        assertEquals(saldoEsperado, saldoActual, 0.001);
        assertEquals(1500, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void retirarDinero() { // Test para verificar que el método retirarSaldo funciona correctamente y actualiza el saldo del banco
        double saldoInicialBanco = Cuenta.getSaldoBanco();

        Cuenta cuenta = new Cuenta(800);
        cuenta.retirarSaldo(200);

        double saldoEsperado = saldoInicialBanco + 600;
        double saldoActual = Cuenta.getSaldoBanco();

        assertEquals(saldoEsperado, saldoActual, 0.001);
        assertEquals(600, cuenta.getSaldo(), 0.001);
    }





}
