import org.junit.jupiter.api.Test;

import ejercicio1.Reunion;

import static org.junit.jupiter.api.Assertions.assertNotSame;

public class ReunionTest {

    @Test
    public void testReunion() {
        Reunion reunion = new Reunion("Programa", "Sala de conferencias", new ejercicio1.Fecha(15, 10, 2024), new ejercicio1.Hora(14, 30));
    }

}
