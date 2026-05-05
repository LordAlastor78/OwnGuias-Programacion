import org.junit.jupiter.api.Test;
import java.util.function.Consumer;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.*;

class ListaTest {

    @Test
    void tarea1_paraCada_copiaLista() {
        Lista<String> original = new Lista<>(5);
        original.añadir("uno");
        original.añadir("dos");
        original.añadir("tres");

        Lista<String> copia = new Lista<>(5);
        original.paraCada(copia::añadir); // closure: método referencia como lambda

        assertEquals("[uno, dos, tres]", copia.toString());
    }

    @Test
    void tarea2_existe_mayorQue() {
        Lista<Integer> nums = new Lista<>(5);
        nums.añadir(10);
        nums.añadir(50);
        nums.añadir(150);

        assertTrue(nums.existe(n -> n > 100));
        assertFalse(nums.existe(n -> n > 10000));
    }

    @Test
    void tarea3_soloLosQue_empiezanPorP() {
        Lista<String> nombres = new Lista<>(5);
        nombres.añadir("Pedro");
        nombres.añadir("Ana");
        nombres.añadir("Pablo");
        nombres.añadir("Luis");

        Lista<String> filtrados = nombres.soloLosQue(n -> n.startsWith("P"));
        assertEquals("[Pedro, Pablo]", filtrados.toString());
    }

    @Test
    void tarea4_transformar_longitudes() {
        Lista<String> textos = new Lista<>(5);
        textos.añadir("hola");
        textos.añadir("mundo");
        textos.añadir("java");

        Lista<Integer> longitudes = textos.transformar(String::length);
        assertEquals("[4, 5, 4]", longitudes.toString());
    }

    @Test
    void transformarAceptaFuncionMasGeneralConPecs() {
        Lista<String> nombres = new Lista<>(3);
        nombres.añadir("Ana");
        nombres.añadir("Pepe");
        nombres.añadir("Luis");

        Function<String, Integer> f = x -> x.toString().length();
        Lista<Integer> resultado = nombres.transformar(f);

        assertEquals("[3, 4, 4]", resultado.toString());
    }
}