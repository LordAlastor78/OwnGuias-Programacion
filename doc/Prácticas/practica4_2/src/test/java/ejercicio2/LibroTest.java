package ejercicio2;

import ejercicio1.Autor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibroTest {

    @Test
    public void testLibroConstructorAndGetters() {
        Autor autor = new Autor("0000-0002-9876-5432", "García", "Luis", "Universidad Complutense");
        Libro libro = new Libro("Un libro sobre Java", 2023, "Editorial de Programación", "Madrid", autor, 5);

        assertEquals("Un libro sobre Java", libro.getTitulo());
        assertEquals(2023, libro.getAnio());
        assertEquals(5, libro.getCitas());
        assertEquals("Luis", libro.getPrimerAutor().getNombre());
        assertEquals("Editorial de Programación", libro.getEditorial());
        assertEquals("Madrid", libro.getLugar());
    }
}
