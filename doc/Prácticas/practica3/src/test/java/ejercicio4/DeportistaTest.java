package ejercicio4;
/*Ejercicio 4

Crea una clase Deportista, con un dni, un nombre, una edad y una categoría, que va a ir cambiando a lo largo del tiempo con los cambios de edad. Los valores de la categoría son: benjamín, alevín, infantil, cadete, juvenil y senior (debes emplear un enumerado), con los siguientes rangos de edad:
Categoría 	Edad
Benjamín 	≤ 8 años
Alevín 	9-10 años
Infantil 	11-12 años
Cadete 	13-14 años
Juvenil 	15-18 años
Sénior 	> 18 años

Implementa la clase como una clase mutable en lo necesario y haz las comprobaciones necesarias empleando excepciones. Fíjate que no es necesario añadir el atributo para categoría (se deduce de la edad), haz que el método getCategoria la calcule directamente.

Crea algunos tests unitarios para comprobar los casos de exito y los casos excepcionales. */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeportistaTest {

    @Test
    public void testDeportistaCategoria() {

        Deportista d1 = new Deportista("9", "bebé", 9);
        assertEquals(Categoria.BENJAMIN, d1.getCategoria());

    }

    @Test
    public void testDeportistaMayorEdad() {

        Deportista d1 = new Deportista("9", "bebé", 9);
        assertEquals(false, d1.esMayorDeEdad());

    }

    @Test
    public void crearDeportistaMenorQueCeroLanzaExcepcion() {
        try {
            Deportista d1 = new Deportista("9", "bebé", -1);
        } catch (IllegalArgumentException e) {
            assertEquals("Error: La edad no puede ser negativa.", e.getMessage());
        }
    }

}
