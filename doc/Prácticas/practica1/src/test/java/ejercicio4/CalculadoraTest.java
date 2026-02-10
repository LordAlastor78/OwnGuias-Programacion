package ejercicio4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void testSumarDosEnteros() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.sumar(2, 3));
    }

    @Test
    void testSumarTresEnteros() {
        Calculadora calc = new Calculadora();
        assertEquals(6, calc.sumar(1, 2, 3));
    }

    @Test
    void testSumarDosDecimales() {
        Calculadora calc = new Calculadora();
        assertEquals(5.5, calc.sumar(2.2, 3.3), 1e-9);
    }

    @Test
    void testRestar() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.restar(10, 5));
    }

    @Test
    void testMultiplicar() {
        Calculadora calc = new Calculadora();
        assertEquals(20, calc.multiplicar(4, 5));
    }

    @Test
    void testMultiplicarEnteroPorDecimal() {
        Calculadora calc = new Calculadora();
        assertEquals(7.5, calc.multiplicar(3, 2.5), 1e-9);
    }

    @Test
    void testDividir() {
        Calculadora calc = new Calculadora();
        assertEquals(2.5, calc.dividir(5, 2), 1e-9);
    }

    @Test
    void testDescuentoPorcentual() {
        Calculadora calc = new Calculadora();
        assertEquals(90.0, calc.aplicarDescuento(100.0, 10), 1e-9);
    }

    @Test
    void testDescuentoFijo() {
        Calculadora calc = new Calculadora();
        assertEquals(85.0, calc.aplicarDescuento(100.0, 15.0), 1e-9);
    }

    @Test
    void testDescuentoPorcentualConTope() {
        Calculadora calc = new Calculadora();
        assertEquals(170.0, calc.aplicarDescuento(200.0, 20, 30.0), 1e-9);
    }
}
