/*Ejercicio 1 (usando LAMBDAs)

Vamos a trabajar con la estructura de datos java.util.List, llamándole a un método que recibe una lambda, denominado forEach. Crea el siguiente código en el editor:

public class UsandoLambdas {

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("uno");      
        lista.add("dos");
        lista.add("tres");

    }
}

Tarea 1

Llama a la función forEach de lista para imprimir todos los elementos de la lista pasando una función lambda directamente en la llamada.
Tarea 2

Haciendo uso del concepto de closure, crea una variable local List<String> losDeTamañoMayorA3. Vuelve a recorrer la lista con forEach pasando otra vez una función lambda directamente en la llamada, pero que esta vez vaya acumulando en losDeTamañoMayorA3 solo aquellos String cuyo length() sea mayor que 3.

Además, intenta usar el closure para acumular la longitud total de todas las cadenas de la lista en una variable entera local. Observarás que si declaras un int longitudTotal = 0 normal, el compilador se quejará, ya que las lambdas en Java solo pueden capturar variables effectively final (variables que no cambian de valor tras su asignación inicial).

Para resolverlo, prueba y debate las dos soluciones siguientes:

    AtomicInteger: declara AtomicInteger longitudTotal = new AtomicInteger(0) y dentro de la lambda usa longitudTotal.set(longitudTotal.get() + s.length()) para acumular. Al terminar el forEach, imprime el resultado con longitudTotal.get().

    Array de una posición: declara int[] longitudTotal = {0} y dentro de la lambda usa longitudTotal[0] += s.length(). Al terminar el forEach, imprime longitudTotal[0].

Reflexiona: ¿por qué funciona cada una de estas soluciones si int no funcionaba? ¿Cuál te parece más legible?
Tarea 3

Declara una referencia a una función lambda en una variable local, que reciba un String y no devuelva nada. Dicha función imprime el tamaño del String por pantalla. Pasa dicha referencia a función lambda directamente en una nueva llamada a forEach de lista.
Tarea 4

Crea un método estático static void imprimir(String) en la clase UsandoLambdas. Intenta pasar una referencia a dicho método estático en una nueva llamada a forEach de lista (pista: usar operador ::).*/

package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer; // Importamos la interfaz funcional Consumer para usarla en la tarea 3
import java.util.function.Predicate; // Importamos la interfaz funcional Predicate para usarla en la tarea 2

public class UsandoLambdas {

    /*
     * El objetivo de este ejercicio es practicar el uso de expresiones lambda en
     * Java, así como entender cómo funcionan los closures y las referencias a
     * métodos. A través de las tareas, se busca que el estudiante se familiarice
     * con la sintaxis de las lambdas, la manipulación de listas con forEach, y la
     * captura de variables en lambdas. Además, se pretende que el estudiante
     * reflexione sobre las limitaciones de las variables capturadas en lambdas y
     * explore soluciones alternativas para acumular valores dentro de una lambda.
     * La explicacion detallada desde cero es :
     * 
     * Lambda es una función anónima que se puede usar para implementar un método de
     * una interfaz funcional (una interfaz con un solo método abstracto). En Java,
     * las lambdas se introdujeron en Java 8 y permiten escribir código más conciso
     * y legible. En este ejercicio, se trabaja con la interfaz funcional Consumer,
     * que representa una operación que acepta un solo argumento de entrada y no
     * devuelve ningún resultado. También se utiliza la interfaz Predicate, que
     * representa una función que toma un argumento y devuelve un valor booleano. El
     * ejercicio se centra en el uso de lambdas para iterar sobre una lista de
     * cadenas, imprimir sus elementos, y acumular información sobre ellos, como su
     * longitud total. Además, se explora cómo las lambdas pueden capturar variables
     * del entorno (closures) y las limitaciones que esto implica, así como
     * soluciones alternativas para superar estas limitaciones.
     */

    public void casiConsumer(String nombre) {
        System.out.println(nombre);
    }

    public boolean esMayorQue2(Integer numero) {
        return numero > 2;
    }

    public static void imprimir(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        Consumer<String> accion = nombre -> System.out.println(nombre);
        Predicate<Integer> condicion = numero -> numero > 2;

        System.out.println(condicion.test(100));

        List<String> lista = new ArrayList<>();

        lista.add("uno");
        lista.add("dos");
        lista.add("tres");

        lista.forEach(accion);
        lista.forEach(nombre -> System.out.println("adios " + nombre));

        // tarea 1
        lista.forEach(s -> System.out.println(s));

        // tarea 2

        List<String> losDeTamañoMayorA3 = new ArrayList<>();

        AtomicInteger longitudTotal = new AtomicInteger(0);
        lista.forEach(s -> {

            longitudTotal.set(longitudTotal.get() + s.length());
            if (s.length() > 3) {
                losDeTamañoMayorA3.add(s);
            }

        });

        int[] longitudTotalArray2 = { 0 };

        lista.forEach(s -> {
            longitudTotalArray2[0] += s.length();
            if (s.length() > 3) {
                losDeTamañoMayorA3.add(s);
            }
        });

        /// tarea 3
        Consumer<String> impirimirTamanoString = s -> System.out.println("La longitud de " + s + " es " + s.length());
        lista.forEach(impirimirTamanoString);


        // tarea 4
        lista.forEach(UsandoLambdas::imprimir);

    }
}