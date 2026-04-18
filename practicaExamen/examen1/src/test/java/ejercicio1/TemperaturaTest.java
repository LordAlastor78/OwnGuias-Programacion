package ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperaturaTest {

    @Test
    public void testToCelsius() {
        Temperatura t = new Temperatura(36.6f);
        assertEquals(36.6f, t.toCelsius(), 1e-6f);
    }
}
