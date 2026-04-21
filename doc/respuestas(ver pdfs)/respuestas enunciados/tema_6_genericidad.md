<!--
Posible prompt:
<prompt>
Tengo un cuestionario con preguntas sobre "Genericidad". Debes tener en cuenta que los conocimientos previos que tengo (y por tanto tus respuestas deben ser adaptadas), son:
- C/C++ sin orientación a objetos.
- Temas de Java previos: clases y objetos, encapsulación, excepciones, composición, herencia y polimorfismo.

Cada respuesta debe tener entre 2 - 4 párrafos de longitud (sin contar los trozos de código).

Por favor, escribe en impersonal las respuestas.

</prompt>
----
-->
# TEMA 6. Genericidad

## 1. Empleando `void*` en C o `Object` en Java, pon un ejemplo de una estructura de datos, que empleando un array primitivo, permita alojar cualquier tipo de dato.

### Respuesta

En C se puede usar un array de `void*` para almacenar punteros a datos de distintos tipos. El contenedor no conoce el tipo real, por lo que el programador debe hacer conversiones explícitas al extraer elementos.

```c
#include <stdio.h>

int main() {
    void* almacenamiento[3];
    int x = 42;
    double y = 3.14;
    const char* texto = "hola";

    almacenamiento[0] = &x;
    almacenamiento[1] = &y;
    almacenamiento[2] = (void*)texto;

    printf("%d %f %s
", *(int*)almacenamiento[0], *(double*)almacenamiento[1], (char*)almacenamiento[2]);
    return 0;
}
```

En Java se puede usar un array de `Object` para el mismo propósito, porque todas las clases derivan de `Object`.

```java
Object[] almacenamiento = new Object[3];
almacenamiento[0] = 42;
almacenamiento[1] = 3.14;
almacenamiento[2] = "hola";

int x = (Integer) almacenamiento[0];
double y = (Double) almacenamiento[1];
String texto = (String) almacenamiento[2];
```

## 2. Brevemente, ¿Qué significa la **programación genérica**? ¿Es el ejemplo anterior un ejemplo básico de programación genérica? 

### Respuesta

La programación genérica consiste en definir estructuras y algoritmos independientes del tipo concreto de datos, usando parámetros de tipo que se concretan al usar el código. Permite crear contenedores y funciones reutilizables y con seguridad de tipos en tiempo de compilación.

El ejemplo anterior con `void*` o `Object` es una forma básica de abstracción, pero no es verdadera programación genérica en el sentido moderno, porque no ofrece verificación de tipos por el compilador y requiere casts inseguros.

## 3. Indica los problemas respecto al chequeo de tipos, de emplear `void*` o `Object` cuando se crean estructuras de datos genéricas. 

### Respuesta

El problema principal es la pérdida de comprobación de tipos en tiempo de compilación. Al usar `void*` en C o `Object` en Java, cualquier tipo puede almacenarse, pero es responsabilidad del programador convertirlo correctamente al recuperarlo.

Eso puede provocar fallos en tiempo de ejecución como `ClassCastException` en Java o comportamiento indefinido en C. También hace el código menos legible y más propenso a errores, porque el tipo real no está explícito.

## 4. Vamos entonces con mecanismos de mejora de la programación genérica ¿Qué son los **parámetros de tipo**? 

### Respuesta

Los parámetros de tipo son identificadores como `T`, `E`, `K` o `V` que se usan para definir clases o métodos genéricos. Representan un tipo variable que se sustituye por un tipo concreto cuando se instancia la clase o se invoca el método.

Este mecanismo permite que el mismo contenedor funcione con distintos tipos sin duplicar código y mantenga la seguridad del compilador, porque se conserva información de tipos en el nivel de la API.

## 5. En Java existe "generics", en C++ existen "templates". Pon un ejemplo de uso de programación genérica en ambos, instanciando una lista o vector dinámico que solo admite `String`. Introduce valores, y luego haz un recorrido de ellos mostrando cómo cada elemento es del tipo concreto con seguridad.

### Respuesta

En Java, `List<String>` garantiza que todos los elementos son `String`.

```java
import java.util.ArrayList;
import java.util.List;

List<String> lista = new ArrayList<>();
lista.add("uno");
lista.add("dos");
for (String elemento : lista) {
    System.out.println(elemento.toUpperCase());
}
```

En C++ se usa `std::vector<std::string>` para conseguir lo mismo.

```cpp
#include <iostream>
#include <vector>
#include <string>

int main() {
    std::vector<std::string> lista;
    lista.push_back("uno");
    lista.push_back("dos");
    for (const std::string& elemento : lista) {
        std::cout << elemento << "
";
    }
}
```

En ambos casos no hace falta hacer conversiones manuales para usar los elementos como `String` o `std::string`.

## 6. Sobre el funcionamiento de la programación genérica. ¿Qué hace el compilador cuando se instancia una clase que tiene parámetros de tipo? ¿Hace lo mismo C++ y Java? ¿Qué es el "type erasure" de Java y la "instanciación de plantillas" de C++?

### Respuesta

En C++ el compilador genera código concreto para cada tipo usado con la plantilla; ese proceso se llama instanciación de plantillas. Se crean versiones específicas como `vector<int>` y `vector<std::string>`.

En Java, el compilador aplica type erasure: elimina la información de tipo genérico para producir bytecode que usa tipos simples como `Object` o los límites especificados. La verificación de tipos se hace en el código fuente, pero el runtime no conserva `T`.

## 7. Vamos a crear una nueva clase con parámetros de tipo. Define en Java una clase `Par`, que permite alojar dos valores de tipos diferentes. Incluye un constructor y un getter para cada tipo. Pon un ejemplo de uso de ese `Par`, por ejemplo para especificar el tipo de retorno de una función que devuelve en un `Par` la media y desviación típica de un array de `double`. 

### Respuesta

```java
public class Par<A, B> {
    private final A primero;
    private final B segundo;

    public Par(A primero, B segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public A getPrimero() { return primero; }
    public B getSegundo() { return segundo; }
}

public class Estadistica {
    public static Par<Double, Double> calcularMediaYDesviacion(double[] valores) {
        double suma = 0;
        for (double v : valores) {
            suma += v;
        }
        double media = suma / valores.length;
        double sumaCuadrados = 0;
        for (double v : valores) {
            sumaCuadrados += Math.pow(v - media, 2);
        }
        double desviacion = Math.sqrt(sumaCuadrados / valores.length);
        return new Par<>(media, desviacion);
    }
}
```

## 8. En Java, se pueden declarar parámetros de tipo también a nivel de método, no solo a nivel de clase. Pon un ejemplo con un método genérico `seleccionaUno`, que pasados dos objetos del mismo tipo, te devuelva aleatoriamente uno de ellos. Muestra la diferencia de definirlo con dos `Object`, a definirlo con dos parámetros de tipo, en terminos de (i) evitar downcasting y (ii) forzar que ambos objetos sean del mismo tipo. 

### Respuesta

```java
public static Object seleccionaUnoObject(Object a, Object b) {
    return Math.random() < 0.5 ? a : b;
}

public static <T> T seleccionaUno(T a, T b) {
    return Math.random() < 0.5 ? a : b;
}
```

El método que usa `Object` obliga a hacer cast al recuperar el valor, y no garantiza que ambos parámetros sean del mismo tipo. El método genérico `<T>` evita downcasting y obliga al compilador a inferir un tipo común para `a` y `b`.

## 9. ¿Se pueden establecer restricciones en los parámetros de tipo? Por ejemplo, si quiero definir un tipo genérico `<T>`, ¿puedo decir que tenga que ser, al menos, un número para poder tratarlo como tal? Pon un ejemplo en Java de un `Punto` con dos coordenadas, metodos `getX`, `getY`, y una función `calcularDistanciaA` otro `Punto`. Permite que esas coordenadas sean cualquier tipo de número. Pon dos soluciones: una simplemente creando coordenadas de tipo `Number` y otra añadiendo generics para reforzar el chequeo de tipos y saber exactamente con qué tipo de número trabaja el `Punto`. En este caso y respecto al "type erasure", ¿cuál es el tipo final tras la compilación?

### Respuesta

Sí, se pueden establecer restricciones con `extends`, por ejemplo `T extends Number`. Eso obliga a que `T` sea un subtipo de `Number`.

Primera solución con `Number`:

```java
public class Punto {
    private final Number x;
    private final Number y;

    public Punto(Number x, Number y) {
        this.x = x;
        this.y = y;
    }

    public Number getX() { return x; }
    public Number getY() { return y; }

    public double calcularDistanciaA(Punto otro) {
        double dx = x.doubleValue() - otro.x.doubleValue();
        double dy = y.doubleValue() - otro.y.doubleValue();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
```

Segunda solución con generics:

```java
public class Punto<T extends Number> {
    private final T x;
    private final T y;

    public Punto(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() { return x; }
    public T getY() { return y; }

    public double calcularDistanciaA(Punto<T> otro) {
        double dx = x.doubleValue() - otro.x.doubleValue();
        double dy = y.doubleValue() - otro.y.doubleValue();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
```

Con type erasure en Java, el tipo final en el bytecode es `Punto` con `Number` como límite; la información concreta de `T` no se conserva en tiempo de ejecución.

## 10. Sobre las soluciones anteriores. Si bien ambas permiten trabajar con distintos tipos de número sin duplicar la clase `Punto`, reflexiona sobre el refuerzo del chequeo de tipos con generics. ¿Permiten ambas crear un punto con una coordenada de tipo entero y la otra coordenada de tipo real? ¿Qué tipo devuelve el `getX` con la solucion sin generics y qué tipo devuelve el que tiene la solución con generics?

### Respuesta

La solución sin genéricos permite crear puntos con coordenadas de distinto tipo, porque ambas son `Number`. Esto es flexible, pero pierde la garantía de que las dos coordenadas sean del mismo subtipo. La versión genérica refuerza el chequeo y asegura que ambas coordenadas comparten el mismo tipo concreto `T`.

En la versión sin genéricos, `getX()` devuelve `Number`. En la versión genérica, `getX()` devuelve `T`, el tipo concreto elegido al instanciar la clase.

## 11. Hagamos un ejemplo avanzado. El siguiente código, con interfaz `Punto`, que define un método `calcularDistanciaA(Punto p)`, junto con las implementaciones `Punto2D` y `Punto3D`. Añade generics para asegurarnos que la sobreescritura del método calcular distancia a otro `Punto` siempre es sobre un `Punto` del mismo tipo, evitando `instanceof` y el downcasting.
```java
public interface Punto { 
    public double distanciaA(Punto p); 
} 

public class Punto2D implements Punto { 
     private final double x, y; 
     public Punto2D(double x, double y) { 
        this.x = x; this.y = y; 
    } 

    @Override 
    public double distanciaA(Punto p) { 
        if (p instanceof Punto2D) { 
            Punto2D p2d = (Punto2D) p; 
            return Math.sqrt(Math.pow(x - p2d.x, 2) 
                    + Math.pow(y - p2d.y, 2)); 
        } else { 
            throw new RuntimeException("p debe ser Punto 2D"); 
        } 
    } 
} 
public class Punto3D implements Punto { 
    // Igual que Punto2D, pero con tres coordenadas
    ...
} 
```

### Respuesta

```java
public interface Punto<T extends Punto<T>> {
    double distanciaA(T p);
}

public class Punto2D implements Punto<Punto2D> {
    private final double x;
    private final double y;

    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double distanciaA(Punto2D p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

public class Punto3D implements Punto<Punto3D> {
    private final double x;
    private final double y;
    private final double z;

    public Punto3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double distanciaA(Punto3D p) {
        double dx = x - p.x;
        double dy = y - p.y;
        double dz = z - p.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
```

Este patrón evita el uso de `instanceof` y el downcast al garantizar que cada implementación recibe su tipo concreto.

## 12. Dado que `String` es subtipo de `Object`, ¿significa eso que `List<String>` es subtipo de `List<Object>`? ¿Y que `String[]` es subtipo de `Object[]`? Razona por qué la respuesta es diferente en cada caso y qué problema en tiempo de ejecución puede aparecer con los arrays. A partir de estos ejemplos, define qué significa que un tipo genérico sea **covariante**, **contravariante** o **invariante** respecto a su parámetro de tipo.

### Respuesta

No, `List<String>` no es subtipo de `List<Object>` en Java; los genéricos son invariantes. Esa decisión evita que listas de un tipo admitan elementos de otro tipo incompatible.

Sí, `String[]` es subtipo de `Object[]` porque los arrays son covariantes. Pero esa covarianza puede provocar un `ArrayStoreException` en tiempo de ejecución al intentar almacenar, por ejemplo, un `Integer` en un array de `String`.

La covarianza significa que `Contenedor<Subtipo>` puede usarse donde se espera `Contenedor<SobreTipo>`. La contravarianza significa que `Contenedor<SobreTipo>` puede usarse donde se espera `Contenedor<Subtipo>`. La invariancia significa que solo se admite el mismo tipo exacto.

## 13. Java permite recuperar covarianza y contravarianza en tipos genéricos de forma controlada mediante **wildcards**. ¿Qué es un wildcard (`?`)? Muestra la diferencia entre `List<? extends T>` y `List<? super T>`, indicando en qué casos se usa cada uno. Pon dos ejemplos: (i) un método que reciba una lista de números y calcule su suma, usando `? extends`; (ii) un método que reciba una lista y le añada varios números enteros, usando `? super`.

### Respuesta

Un wildcard (`?`) es un tipo desconocido en una expresión genérica. Permite declarar límites de lectura o escritura sin fijar un tipo concreto.

`List<? extends T>` se usa cuando se quiere leer elementos como `T` o subtipos de `T`, y `List<? super T>` se usa cuando se quiere escribir elementos de tipo `T` o subtipos en la colección.

```java
public static double sumaNumeros(List<? extends Number> lista) {
    double total = 0;
    for (Number n : lista) {
        total += n.doubleValue();
    }
    return total;
}

public static void añadeEnteros(List<? super Integer> lista) {
    lista.add(1);
    lista.add(2);
    lista.add(3);
}
```

Con `? extends` se puede leer de la lista de forma segura. Con `? super` se puede añadir enteros aunque no se conozca el tipo exacto de la lista.
