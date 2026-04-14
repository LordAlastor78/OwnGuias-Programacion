package ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SanityTest {

    @Test
    public void claseExiste() throws Exception {
        Class<?> cls = Class.forName("ejercicio1.Ejercicio1");
        assertNotNull(cls);
    }

}
