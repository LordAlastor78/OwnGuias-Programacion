/* Ejercicio 2: Diseñando APIs con LAMBDA

Vamos a trabajar con una estructura lineal (Lista<T>) a la que le vamos a ir añadiendo funcionalidades nuevas que reciben funciones lambda como parámetro. Partimos de este código que debes copiar y pegar en el editor de código:

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Lista<T> {

    private T[] elementos;
    private int numElementos = 0;

    public Lista(int tamañoMaximo) {
        this.elementos = (T[]) new Object[tamañoMaximo];
    }

    public void añadir(T elem) {
        if (this.numElementos == elementos.length) {
            throw new IllegalArgumentException("Lista llena");
        }
        this.elementos[numElementos++] = elem;
    }

    public T obtener(int pos) {
        validarPosicion(pos);

        return this.elementos[pos];
    }

    public void eliminar(int pos) {
        validarPosicion(pos);

        for (int i = pos; i < this.numElementos - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.numElementos--;
    }

    private void validarPosicion(int pos) throws IllegalArgumentException {
        if (pos < 0 || pos >= this.numElementos) {
            throw new IllegalArgumentException("eliminar: posicion no valida: " + pos);
        }
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("[");
        for (int i = 0; i < this.numElementos; i++) {
            if (i > 0) {
                toString.append(", ");
            }
            toString.append(this.elementos[i].toString());
        }
        toString.append("]");
        return toString.toString();
    }

}

Tarea 1

Implementa en Lista<T> un método paraCada(...) que no devuelve nada (es nuestra versión de forEach), pero que recibe una lambda a la que se le permita pasar cada elemento de la lista (pista: usa Consumer<T>). Crea un test de unidad con paraCada que demuestre que funciona. Por ejemplo, usando closures podrías hacer una copia de una Lista<String> en otra lista inicialmente vacía que está como variable local al test.

Para comparar si la copia es igual a lo esperado, puedes hacerlo con el toString():

String toStringEsperado = "[uno, dos, tres]";
assertEquals(toStringEsperado, copia.toString());

Tarea 2

Implementa en Lista<T> un método existe(...), que devuelve booleano, y recibe una lambda que permita tratar un elemento y decir si ese elemento es el que se busca, es decir, recibe un elemento y devuelve booleano (pista: usa Predicate<T>). Haz un test de unidad para comprobar el método funciona buscando si hay un número mayor a 100 en una lista de números (Lista<Integer>) y que no existe un número mayor a 10000.
Tarea 3

Implementa en Lista<T> un método soloLosQue(...), que devuelve otra Lista<T> nueva, pero con solo los elementos para los que una función lambda recibida como parámetro dice que se quieren incluir (pista: usa Predicate<T>). Haz un test de unidad para, de una Lista<String> que tiene nombres de persona, devuelva solo los que empiezan por P.
Tarea 4

Implementa en Lista<T> un método transformar(...), que devuelva otra Lista<R> nueva, pero donde cada elemento de la lista original (de tipo T), ha sido transformado en un elemento de tipo R (pista: usa Function<T, R>). Haz un test de unidad para probar que una Lista<String> se puede transformar en una Lista<Integer> con las longitudes de las cadenas de texto.
Tarea 5 (ampliación): mejorar la API con PECS

Ahora vamos a mejorar las firmas de los métodos para que la API sea más flexible.

    Copia este test tal cual y ejecútalo:

@Test
void transformarAceptaFuncionMasGeneralConPecs() {
    Lista<String> nombres = new Lista<>(3);
    nombres.añadir("Ana");
    nombres.añadir("Pepe");
    nombres.añadir("Luis");

    Function<Object, Integer> f = x -> x.toString().length();

    Lista<Number> resultado = nombres.transformar(f);

    assertEquals("[3, 4, 4]", resultado.toString());
}

Reflexiona: ¿por qué no compila el test?

    Ajusta ahora las firmas (sin cambiar la lógica interna) aplicando PECS:

    paraCada(...): Consumer<? super T> (consume elementos T)
    existe(...) y soloLosQue(...): Predicate<? super T> (consumen elementos T para evaluarlos)
    transformar(...): Function<? super T, ? extends R> (consume T y produce R)

    Vuelve a ejecutar los tests, donde debe funcionar el test nuevo y también deben seguir pasando los tests de las tareas 1-4.

Regla para recordar: entrada -> super, salida -> extends.

*/

package ejercicio2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Lista<T> {

    private T[] elementos;
    private int numElementos = 0;

    public Lista(int tamañoMaximo) {
        this.elementos = (T[]) new Object[tamañoMaximo];
    }

    public void añadir(T elem) {
        if (this.numElementos == elementos.length) {
            throw new IllegalArgumentException("Lista llena");
        }
        this.elementos[numElementos++] = elem;
    }

    

    public void paraCada(Consumer<? super T> accion) {
        for (int i = 0; i < numElementos; i++)
            accion.accept(elementos[i]);
    }

    public boolean existe(Predicate<? super T> condicion) {
        for (int i = 0; i < numElementos; i++) {
            if (condicion.test(elementos[i]))
                return true;
        }
        return false;
    }

    public Lista<T> soloLosQue(Predicate<? super T> condicion) {
        Lista<T> resultado = new Lista<>(numElementos);
        for (int i = 0; i < numElementos; i++) {
            if (condicion.test(elementos[i]))
                resultado.añadir(elementos[i]);
        }
        return resultado;
    }

    public <R> Lista<R> transformar(Function<? super T, ? extends R> mapeador) {
        Lista<R> resultado = new Lista<>(numElementos);
        for (int i = 0; i < numElementos; i++) {
            resultado.añadir(mapeador.apply(elementos[i]));
        }
        return resultado;
    }

}