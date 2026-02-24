package ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TipoIVATest {

    @Test
    public void calcularPrecioFinalConIVAGeneral() {

        TipoIVA tipoIVA = TipoIVA.GENERAL;
        double precioBase = 100.0;
        double precioEsperado = 121.0;
        double precioCalculado = tipoIVA.calcularPrecioFinal(precioBase);

        assertEquals(precioEsperado, precioCalculado, 0.001, "El precio final con IVA general debería ser 121.0"); // Tolerancia
        // de 0.001 para manejar errores de precisión flotante
    }

    @Test
    public void testGetPorcentaje() {

        assertEquals(0.21, TipoIVA.GENERAL.getPorcentaje(), 0.001, "El porcentaje de IVA general debería ser 0.21");
        assertEquals(0.10, TipoIVA.REDUCIDO.getPorcentaje(), 0.001, "El porcentaje de IVA reducido debería ser 0.10");
        assertEquals(0.04, TipoIVA.SUPERREDUCIDO.getPorcentaje(), 0.001,
                "El porcentaje de IVA superreducido debería ser 0.04");
        assertEquals(0.0, TipoIVA.EXENTO.getPorcentaje(), 0.001, "El porcentaje de IVA exento debería ser 0.0");

    }
}
