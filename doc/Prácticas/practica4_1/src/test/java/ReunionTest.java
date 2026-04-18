import ejercicio1.Fecha;
import ejercicio1.Hora;
import ejercicio1.Reunion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class ReunionTest {

    @Test
    public void testReunion() {

        Reunion reunion = new Reunion("Programa", "Sala de conferencias", new Fecha(15, 10, 2024), new Hora(14, 30));
        assertEquals("Programa", reunion.getAsunto());
        assertEquals("Sala de conferencias", reunion.getLugar());

        Fecha f = reunion.getFecha();
        Hora h = reunion.getHora();

        assertEquals(15, f.getDia());
        assertEquals(10, f.getMes());
        assertEquals(2024, f.getAnio());
        assertEquals(14, h.getHora());
        assertEquals(30, h.getMinuto());
        // Verificar que se devuelven copias, no referencias
        assertNotSame(f, reunion.getFecha());
        assertNotSame(h, reunion.getHora());
    }

}
