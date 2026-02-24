package ejercicio5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperacionTest {


    @Test
    public void testCalcular() {
        double n1 = 10;
        double n2 = 5;

        // Prueba de suma
        assertEquals(15, Operacion.SUMA.calcular(n1, n2), 0.001);

        // Prueba de resta
        assertEquals(5, Operacion.RESTA.calcular(n1, n2), 0.001);

        // Prueba de multiplicación
        assertEquals(50, Operacion.MULTIPLICACION.calcular(n1, n2), 0.001);

        // Prueba de división
        assertEquals(2, Operacion.DIVISION.calcular(n1, n2), 0.001);

        // Prueba de división por cero
        assertTrue(Double.isNaN(Operacion.DIVISION.calcular(n1, 0)));
    }

}
