package ejercicio3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuentaTest {

    @BeforeEach
    public void setUp() {
        Cuenta.resetearSaldoBanco(); // Reiniciar el saldo del banco antes de cada test
    }

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

    @Test
    public void crearCuentaConSaldoNegativoLanzaExcepcion() { // Test para verificar que no se puede crear una cuenta con saldo negativo
        assertThrows(IllegalArgumentException.class, () -> {
            new Cuenta(-500);
        });
    }

    @Test
    public void retirarMasDineroDelQueHayLanzaExcepcion() { // Test para verificar que no se puede retirar más dinero del que hay en la cuenta
        Cuenta cuenta = new Cuenta(500);
        assertThrows(IllegalArgumentException.class, () -> {
            cuenta.retirarSaldo(1000);
        });
    }

}
