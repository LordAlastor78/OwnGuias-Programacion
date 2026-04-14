package ejercicio2;

import ejercicio1.Autor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticuloTest {

    @Test
    public void testArticuloConstructorAndGetters() {
        Autor autor = new Autor("0000-0001-2345-6789", "Pérez", "Ana", "Universidad de Vigo");
        Articulo articulo = new Articulo("Un artículo sobre Java", 2024, "Revista de Programación", 10, 5, 15, autor,
                12);

        assertEquals("Un artículo sobre Java", articulo.getTitulo());
        assertEquals(2024, articulo.getAnio());
        assertEquals(12, articulo.getCitas());
        assertEquals("Pérez", articulo.getPrimerAutor().getApellidos());
        assertEquals("Revista de Programación", articulo.getNombreRevista());
        assertEquals(10, articulo.getVolumen());
        assertEquals(5, articulo.getPaginaInicial());
        assertEquals(15, articulo.getPaginaFinal());
    }
}
