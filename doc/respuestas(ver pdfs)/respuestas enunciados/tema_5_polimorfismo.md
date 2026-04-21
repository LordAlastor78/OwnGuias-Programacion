<!--
Posible prompt:
<prompt>
Tengo un cuestionario con preguntas sobre "Polimorfismo". Debes tener en cuenta que los conocimientos previos que tengo (y por tanto tus respuestas deben ser adaptadas), son:
- C/C++ sin orientación a objetos.
- Temas de Java previos: Clases y Objetos, Encapsulación, Excepciones, Composición y Herencia.

Cada respuesta debe tener entre 2 - 4 párrafos de longitud (sin contar los trozos de código).

Por favor, escribe en impersonal las respuestas.

</prompt>
----
-->
# Tema 5. Polimorfismo

## 1. Brevemente, ¿qué es el **"polimorfismo"** y para qué sirve en programación orientada a objetos? ¿qué es la **"sobreescritura"** de métodos?

El polimorfismo es un principio que permite tratar objetos de diferentes clases de forma uniforme cuando comparten un mismo tipo o interfaz. En programación orientada a objetos, sirve para escribir código genérico que funciona con supertipos, pero se comporta de forma distinta según el subtipo real del objeto.

La sobreescritura de métodos es el mecanismo por el que una subclase proporciona una implementación distinta de un método que ya existe en su superclase. El nombre y los parámetros coinciden, pero la ejecución real depende del tipo del objeto en tiempo de ejecución.

## 2. ¿En qué consiste la **"ligadura dinámica"** o **"enlace tardío"**? ¿qué relación tiene con el polimorfismo? ¿hay que indicarlos explícitamente al programar o depende esto del lenguaje? Compara C++ y Java. Indicalo después también para Python.

La ligadura dinámica o enlace tardío es el proceso por el cual el método que se ejecuta se decide en tiempo de ejecución según el tipo real del objeto. Es la base del polimorfismo de ejecución: el mismo mensaje envía diferentes comportamientos según la clase concreta.

En C++ hay que marcar los métodos con `virtual` para obtener enlace dinámico; sin ello, la llamada se enlaza en tiempo de compilación. En Java, los métodos de instancia se enlazan dinámicamente por defecto, sin necesidad de declarar nada especial. En Python, el enlace es también dinámico siempre, porque el lenguaje resuelve métodos en tiempo de ejecución sobre el objeto real.

## 3. Pon un ejemplo sencillo en Java, de un `Soldado`, con un método `saluda`, con dos subclases: `Zapador` y `Artillero`, donde `Zapador` sobreescribe el método `saludar`, sustituyendo por completo su comportamiento. Ilustra el funcionamiento del polimorfismo creando un array de `Soldados` de dos tipos y luego recorriéndolo empleando referencias de tipo `Soldado` y llamando a `saludar`.

### Respuesta

```java
public class Soldado {
    public void saludar() {
        System.out.println("Hola, soldado.");
    }
}

public class Artillero extends Soldado {
    @Override
    public void saludar() {
        System.out.println("Hola, soy artillero.");
    }
}

public class Zapador extends Soldado {
    @Override
    public void saludar() {
        System.out.println("Hola, soy zapador.");
    }
}

public class EjemploPolimorfismo {
    public static void main(String[] args) {
        Soldado[] unidad = {new Artillero(), new Zapador(), new Artillero()};
        for (Soldado soldado : unidad) {
            soldado.saludar();
        }
    }
}
```

En este ejemplo, el arreglo es de tipo `Soldado`, pero cada objeto real puede ser `Artillero` o `Zapador`. Al recorrerlo, se invoca la versión correcta de `saludar` según el tipo del objeto.

## 4. Si sobreescribo un método, ¿puedo invocar el método base para trabajar a partir de su resultado? Haz que zapador cambie ligeramente la forma de saludar, que salude de forma normal, tal cual hace el soldado base, pero que además añada un "ZAPADOR A SUS ORDENES" ¿qué palabra clave del lenguaje has usado para invocar al método de la clase base?

### Respuesta

Sí, se puede invocar el método base desde la sobreescritura usando la palabra clave `super`. Esto permite reutilizar la lógica de la superclase y luego añadir un comportamiento específico del subtipo.

```java
public class Zapador extends Soldado {
    @Override
    public void saludar() {
        super.saludar();
        System.out.println("ZAPADOR A SUS ORDENES");
    }
}
```

En este caso, `super.saludar()` llama al método `saludar` de `Soldado` antes de imprimir el mensaje adicional.

## 5. Al sobreescribir un método en Java, ¿qué restricciones existen sobre los tipos de los parámetros y el tipo de retorno? ¿Qué diferencia hay entre sobreescritura (*overriding*) y sobrecarga (*overloading*)? ¿Para qué sirve la anotación `@Override` y por qué es recomendable usarla siempre?

### Respuesta

Al sobreescribir un método en Java, los parámetros deben tener la misma lista de tipos y el mismo orden; el nombre debe ser igual. El tipo de retorno puede ser covariante, es decir, puede devolver un subtipo del tipo de retorno declarado en la superclase, pero no un tipo incompatible.

La sobreescritura (`overriding`) redefine el mismo método en una subclase, mientras que la sobrecarga (`overloading`) consiste en varios métodos con el mismo nombre pero diferentes parámetros en la misma clase. La anotación `@Override` indica al compilador que esa implementación debe corresponder a un método heredado y evita errores si la firma es incorrecta.

Usar `@Override` es recomendable porque convierte errores de firma en fallos de compilación y hace el código más claro para quien lo lee.

## 6. Entonces, cuando se estudia Java, ¿se emplea el polimorfismo desde el principio? Por ejemplo, sobreescribiendo `toString` o sobreescribiendo `equals`, ¿ya estoy usando polimorfismo?

### Respuesta

Sí, en Java se emplea polimorfismo desde el principio. Cualquier método de instancia que sobrescribe un método heredado participa en el polimorfismo en tiempo de ejecución.

Cuando se sobrescribe `toString()` o `equals()` de `Object`, se está usando polimorfismo porque el código que llama a esos métodos puede operar sobre referencias de tipo `Object` o de la clase concreta, y la implementación elegida depende del tipo real del objeto.

## 7. ¿Qué es una **"clase abstracta"**? ¿Qué es un **"método abstracto"**? ¿Puedo crear instancias de una clase abstracta? Pongamos un ejemplo en Java: Redefinamos `Soldado`, hagamos que, además del método `saluda` que ya tenía, tenga un método `atacar`, que sea abstracto y que cada tipo de soldado haga su acción cuando se le pida atacar. ¿Donde debemos poner `abstract`?

### Respuesta

Una clase abstracta es una clase que no se puede instanciar y que puede contener métodos sin implementación. Un método abstracto declara su firma pero no tiene cuerpo, y obliga a las subclases concretas a implementarlo.

No se puede crear una instancia de una clase abstracta directamente. La palabra clave `abstract` se coloca en la definición de la clase y en las declaraciones de los métodos que no tienen implementación.

```java
public abstract class Soldado {
    public void saludar() {
        System.out.println("Hola, soy un soldado.");
    }

    public abstract void atacar();
}

public class Artillero extends Soldado {
    @Override
    public void atacar() {
        System.out.println("Disparo cohetes.");
    }
}

public class Zapador extends Soldado {
    @Override
    public void atacar() {
        System.out.println("Coloco minas.");
    }
}
```

## 8. ¿Qué efecto tiene la palabra clave `final` sobre métodos y clases en Java? ¿Cómo se relaciona con el polimorfismo? ¿Conoces algún ejemplo de clase `final` en la propia API estándar de Java?

### Respuesta

La palabra clave `final` aplicada a un método impide que dicho método sea sobrescrito en subclases. Si se aplica a una clase, impide que la clase sea heredada. Esto limita el polimorfismo porque bloquea la posibilidad de reemplazar o extender comportamientos.

En la API estándar de Java, `String` es un ejemplo clásico de clase `final`. También `Integer` y otras clases inmutables del paquete `java.lang` son finales para evitar subclases no deseadas y reforzar la seguridad del diseño.

## 9. En Java, qué son las **"interfaces"**? ¿Son como clases abstractas? ¿Una clase puede implementar más de una interfaz?

### Respuesta

Una interfaz en Java es un contrato que define métodos que una clase debe implementar. No puede contener estado mutable de instancia como una clase normal, aunque sí puede incluir métodos `default` y `static` con implementación.

Una interfaz es similar a una clase abstracta en que ambas pueden declarar métodos sin cuerpo, pero difieren en que una clase puede implementar varias interfaces, mientras que solo puede extender una única superclase. Por tanto, las interfaces son la forma preferida en Java para modelar comportamientos múltiples.

## 10. Vamos a poner un ejemplo nuevo con polimorfismo. Queremos implementar una clase `Punto`, con un método `calcularDistanciaA`, que permite calcular la distancia a otro `Punto`. Sin embargo, como queremos trabajar con puntos 2D y 3D, haz que ese método sea abstracto y haya dos implementaciones de ese cálculo de distancia. Emplea `instanceof` y *downcasting* para verificar que se recibe un punto compatible y poder calcular correctamente la distancia siempre entre puntos del mismo subtipo. Aprovecha este diseño para crear ahora una clase `Linea`, que acepta `Punto`, sin saber de qué tipo es, y es capaz de dar su longitud independientemente de las dimensiones de sus puntos (las cuales desconoce).

### Respuesta

```java
public abstract class Punto {
    public abstract double calcularDistanciaA(Punto otro);
}

public class Punto2D extends Punto {
    private final double x;
    private final double y;

    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calcularDistanciaA(Punto otro) {
        if (!(otro instanceof Punto2D)) {
            throw new IllegalArgumentException("Debe ser un Punto2D");
        }
        Punto2D p = (Punto2D) otro;
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

public class Punto3D extends Punto {
    private final double x;
    private final double y;
    private final double z;

    public Punto3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double calcularDistanciaA(Punto otro) {
        if (!(otro instanceof Punto3D)) {
            throw new IllegalArgumentException("Debe ser un Punto3D");
        }
        Punto3D p = (Punto3D) otro;
        double dx = x - p.x;
        double dy = y - p.y;
        double dz = z - p.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}

public class Linea {
    private final Punto inicio;
    private final Punto fin;

    public Linea(Punto inicio, Punto fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public double longitud() {
        return inicio.calcularDistanciaA(fin);
    }
}
```

En este diseño, `Linea` trabaja con `Punto` sin conocer si es 2D o 3D. La jerarquía hace posible que la implementación concreta realice la conversión segura y calcule la distancia correcta.

## 11. ¿Qué es la **"herencia de interfaces"** en Java? ¿Existe **"herencia múltiple de interfaces"**? Pon un ejemplo de una interfaz `Fichero` que tenga un método para leer su contenido en forma de `String` y luego dicha interfaz sea extendida por otra que sea `FicheroEscribible` que permita enviar contenido e incluso eliminar el fichero.

### Respuesta

La herencia de interfaces es cuando una interfaz extiende otra interfaz, heredando sus métodos. En Java sí existe herencia múltiple de interfaces: una interfaz puede extender varias interfaces al mismo tiempo.

Por ejemplo:

```java
public interface Fichero {
    String leerContenido();
}

public interface FicheroEscribible extends Fichero {
    void escribirContenido(String texto);
    void eliminar();
}
```

Así, cualquier clase que implemente `FicheroEscribible` debe definir `leerContenido`, `escribirContenido` y `eliminar`.

