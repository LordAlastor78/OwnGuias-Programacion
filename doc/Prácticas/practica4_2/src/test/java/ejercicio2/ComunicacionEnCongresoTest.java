package ejercicio2;

import ejercicio1.Autor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComunicacionEnCongresoTest {

    @Test
    public void testComunicacionEnCongresoConstructorAndGetters() {
        Autor autor = new Autor("0000-0003-1111-2222", "Martínez", "Sara", "Universidad de Sevilla");
        ComunicacionEnCongreso comunicacion = new ComunicacionEnCongreso("Una comunicación sobre Java", 2022,
                "Congreso de Programación", "Barcelona", "Dr. Programador", autor, 3);

        assertEquals("Una comunicación sobre Java", comunicacion.getTitulo());
        assertEquals(2022, comunicacion.getAnio());
        assertEquals(3, comunicacion.getCitas());
        assertEquals("Sara", comunicacion.getPrimerAutor().getNombre());
        assertEquals("Congreso de Programación", comunicacion.getNombreCongreso());
        assertEquals("Barcelona", comunicacion.getLugar());
        assertEquals("Dr. Programador", comunicacion.getPresentador());
    }
}
