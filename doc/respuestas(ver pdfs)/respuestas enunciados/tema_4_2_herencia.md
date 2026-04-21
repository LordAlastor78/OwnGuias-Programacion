<!--
Posible prompt:
<prompt>
Tengo un cuestionario con preguntas sobre "Herencia". Debes tener en cuenta que los conocimientos previos que tengo (y por tanto tus respuestas deben ser adaptadas), son:
- C/C++ sin orientación a objetos.
- Temas de Java previos: Clases y Objetos, Encapsulación, Excepciones y Composición.

Cada respuesta debe tener entre 2 - 4 párrafos de longitud (sin contar los trozos de código).

Por favor, escribe en impersonal las respuestas.

</prompt>
----
-->


# Tema 4.2. Herencia

## 1. En orientación a objetos, ¿qué es la **herencia** y su relación con "A es-un B"?. Explica las dos implicaciones principales: (1) **compatibilidad de tipos** y (2) **herencia de estado y comportamiento**. Pon un ejemplo en Java muy sencillo, donde un `Soldado` tiene un `nombre` (privado) y un método `saludar()` que muestra su nombre. Hay dos subtipos: un `Artillero`, que es capaz de disparar cohetes y un `Zapador` que pone minas, ambos heredan el atributo nombre y la capacidad de saludar. Además, y de forma específica, el artillero tiene un número de cohetes y el zapador un número de minas, accesibles mediante "getters" específicos. Respecto a la compatibilidad de tipos, aprovechémosla: crea un array de `Soldado`, mete varios de distinto tipo (son todos compatibles con `Soldado`). Recórrela y que todos te saluden.

### Respuesta

La herencia es un mecanismo que permite definir una clase nueva a partir de otra existente. En este modelo, la clase derivada (`Artillero`, `Zapador`) es un subtipo del supertipo `Soldado`, y se cumple la relación lógica de que un `Artillero` es un `Soldado` y un `Zapador` es un `Soldado`.

La primera implicación es la compatibilidad de tipos: un objeto de la subclase puede tratarse como si fuera una instancia del supertipo. Esto permite, por ejemplo, guardar `Artillero` y `Zapador` en un mismo arreglo de `Soldado` y operar con ellos de forma uniforme. La segunda implicación es que la subclase hereda estado y comportamiento de la superclase: los atributos y métodos definidos en `Soldado` están disponibles dentro de `Artillero` y `Zapador`, de modo que ambos comparten la implementación común.

```java
public class Soldado {
    private String nombre;

    public Soldado(String nombre) {
        this.nombre = nombre;
    }

    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}

public class Artillero extends Soldado {
    private int cohetes;

    public Artillero(String nombre, int cohetes) {
        super(nombre);
        this.cohetes = cohetes;
    }

    public int getCohetes() {
        return cohetes;
    }
}

public class Zapador extends Soldado {
    private int minas;

    public Zapador(String nombre, int minas) {
        super(nombre);
        this.minas = minas;
    }

    public int getMinas() {
        return minas;
    }
}

public class EjemploHerencia {
    public static void main(String[] args) {
        Soldado[] unidad = {
            new Artillero("Ana", 5),
            new Zapador("Luis", 3),
            new Artillero("Marta", 2)
        };

        for (Soldado soldado : unidad) {
            soldado.saludar();
        }
    }
}
```

## 2. Al crear los soldados concretos, ¿cuántos constructores se ejecutan y en qué orden? ¿Qué significa `super` dentro de un constructor? Si la clase base no tiene visible el constructor sin parámetros, ¿debo llamar a `super` siempre?

### Respuesta

Al crear un objeto de una subclase se ejecutan dos constructores: primero el constructor de la superclase y luego el de la subclase. El orden garantiza que el estado heredado se inicialice antes de que la clase derivada procese sus propios atributos.

La palabra clave `super` dentro de un constructor se usa para invocar explícitamente el constructor del supertipo. Si la clase base no tiene un constructor sin parámetros visible, entonces sí hay que llamar a `super(...)` con los argumentos adecuados desde la subclase, porque el compilador necesita saber cómo construir la parte heredada.

```java
public class Artillero extends Soldado {
    public Artillero(String nombre, int cohetes) {
        super(nombre); // inicializa la parte de Soldado
        this.cohetes = cohetes; // luego inicializa lo propio de Artillero
    }
}
```

## 3. Respecto a los objetos de subclases en memoria, los atributos privados de la superclase, ¿forman parte de una instancia de la subclase en memoria? En caso afirmativo ¿implica que se puedan usar desde el código de la subclase? Explícalo con el ejemplo de `Soldado` y alguna de sus subclases.

### Respuesta

Sí, los atributos privados de la superclase forman parte de la instancia de la subclase en memoria. Un objeto de `Artillero` contiene tanto el estado definido en `Soldado` como el estado propio de `Artillero`, aunque algunos campos estén declarados `private` en la superclase.

Eso no significa que el código de la subclase pueda acceder directamente a esos campos privados. La visibilidad `private` impide el acceso directo desde `Artillero`, por lo que la subclase debe usar métodos públicos o protegidos de la superclase para leer o modificar ese estado.

## 4. ¿Qué implica en términos de **extensibilidad** de código el hecho de que sean compatibles a nivel de tipos? Ilustra esto añadiendo un nuevo tipo de `Soldado` y demostrando que el código para pedir el saludo a todos los soldados no se modifica.

### Respuesta

La compatibilidad a nivel de tipos hace que el código sea más extensible porque permite añadir nuevos subtipos sin cambiar el código cliente que trabaja con el supertipo. Si todas las clases comparten la misma interfaz o los mismos métodos básicos, se puede ampliar el sistema con nuevas variantes sin tocar la lógica de uso.

Por ejemplo, si se añade una clase `Explorador` que hereda de `Soldado`, el recorrido de un arreglo de `Soldado` sigue funcionando igual. Solo se incorporan nuevas instancias al conjunto, pero la llamada a `saludar()` permanece inalterada.

```java
public class Explorador extends Soldado {
    public Explorador(String nombre) {
        super(nombre);
    }
}

// Uso:
Soldado[] unidad = {
    new Artillero("Ana", 5),
    new Zapador("Luis", 3),
    new Explorador("Eva")
};
for (Soldado soldado : unidad) {
    soldado.saludar();
}
```

## 5. En Java, cuando trabajo con referencias y herencia. ¿Puedo tener una referencia del supertipo que apunte a objetos reales de un subtipo? ¿Puedo invocar con la referencia del supertipo a métodos públicos del subtipo? ¿En qué consiste el **"upcasting"** y el **"downcasting"**? ¿Qué es el `instanceof`? Pon un ejemplo de recorrido de un array de `Soldado`, comprobando que, si el objeto real es un `Artillero`, solicite el número de cohetes que tiene y los imprima.

### Respuesta

Sí, una referencia de tipo superclase puede apuntar a un objeto de subtipo. Esto es el comportamiento normal en Java y permite tratar objetos distintos como si fueran un tipo común. Con esa referencia solo se pueden invocar los métodos visibles desde el tipo declarado.

El `upcasting` es convertir una referencia de subtipo a su supertipo, algo que Java hace implícitamente. El `downcasting` es convertir una referencia de supertipo al subtipo real, y solo es seguro si el objeto es realmente de ese subtipo. El operador `instanceof` sirve para comprobar en tiempo de ejecución si una referencia apunta a un objeto de una clase concreta o de una subclase.

```java
for (Soldado soldado : unidad) {
    soldado.saludar();
    if (soldado instanceof Artillero) {
        Artillero artillero = (Artillero) soldado;
        System.out.println("Cohetes: " + artillero.getCohetes());
    }
}
```

## 6. Respecto a la ocultación de información y herencia, ¿qué significa acceso **"protegido"** de métodos y/o atributos? ¿Cómo se implementa en Java? Pon un ejemplo de uso de en la clase `Soldado` para que su nombre sea protegido y pueda usarse en el método de poner bombas del `Zapador`.

### Respuesta

El acceso `protected` en Java permite que los miembros sean visibles dentro del mismo paquete y también en las subclases, incluso si éstas están en paquetes distintos. Es un nivel intermedio entre `private` y `public` que facilita la herencia sin exponer el miembro a todo el mundo.

Si el nombre de `Soldado` se declara como `protected`, el método de `Zapador` puede usarlo directamente. Esto mantiene cierta ocultación frente a clases no relacionadas, pero permite reutilizar el estado heredado en las subclases.

```java
public class Soldado {
    protected String nombre;

    public Soldado(String nombre) {
        this.nombre = nombre;
    }
}

public class Zapador extends Soldado {
    public Zapador(String nombre, int minas) {
        super(nombre);
        this.minas = minas;
    }

    public void ponerBombas() {
        System.out.println(nombre + " coloca minas.");
    }
}
```

## 7. En los lenguajes orientados a objetos ¿hay una **clase base** para todos los objetos? ¿Ocurre en todos los lenguajes? ¿Qué ocurre en Java?

### Respuesta

No todos los lenguajes orientados a objetos tienen una clase base común. Algunos modelos de objeto, como el prototípico de JavaScript, no usan una jerarquía de clases rígida. En Java sí existe una clase raíz: `Object`.

En Java, todas las clases derivan indirectamente de `Object`, por lo que cualquier objeto hereda métodos como `toString()`, `equals()` y `hashCode()`. Esto permite tratar todos los objetos de manera uniforme y aprovechar comportamientos comunes.

## 8. ¿Qué es la **"herencia múltiple"**? ¿Existe en Java herencia múltiple?

### Respuesta

La herencia múltiple es la capacidad de una clase para heredar directamente de más de una superclase. En algunos lenguajes como C++ esto es posible, pero en Java la herencia múltiple de clases no está permitida.

Java evita la herencia múltiple de clases para reducir la complejidad y los problemas de ambigüedad en los métodos heredados. En su lugar, Java permite que una clase implemente varias interfaces, lo que aporta flexibilidad sin los riesgos asociados a la herencia múltiple tradicional.

## 9. Las excepciones en los lenguajes orientados a objetos son objetos. Por tanto, se pueden crear excepciones personalizadas. Pon un ejemplo en Java de una excepción personalizada (`UsuarioNoEncontradoException`), que sea *no controlada* y que además este compuesto con un `Usuario`, para saber qué `Usuario` dio el problema. Permite además que se pueda incluir la causa, es decir, sobrecarga el constructor para tener una versión que permita añadir la causa subyacente.

### Respuesta

Una excepción personalizada en Java se crea extendiendo `RuntimeException` si se desea que sea no controlada. Al incluir un objeto `Usuario` como campo se encapsula información útil sobre el origen del error, lo que mejora el manejo posterior.

La sobrecarga de constructores permite crear variantes con y sin causa subyacente, de modo que se puede encadenar la excepción original cuando procede.

```java
public class Usuario {
    private String id;
    private String nombre;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

public class UsuarioNoEncontradoException extends RuntimeException {
    private final Usuario usuario;

    public UsuarioNoEncontradoException(Usuario usuario) {
        super("Usuario no encontrado: " + usuario.getId());
        this.usuario = usuario;
    }

    public UsuarioNoEncontradoException(Usuario usuario, Throwable causa) {
        super("Usuario no encontrado: " + usuario.getId(), causa);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
```

## 10. Herencia vs. Composición. Se dice que no se debe emplear herencia simplemente por reutilizar código, es decir, que si quiero reutilizar código simplemente, no debo pensar en herencia como primera opción ¿por qué?

### Respuesta

La herencia implica una relación de tipo fuerte y una dependencia semántica entre clases. Si se usa solo para compartir código, se puede acabar creando una jerarquía artificial que no refleja una verdadera relación "es-un" y que dificulta la evolución del diseño.

Además, la herencia hace que el subtipo herede todos los detalles de la superclase, incluidos los que quizás no encajan. Reutilizar código mediante herencia puede forzar vínculos innecesarios y reducir la flexibilidad futura.

## 11. Herencia vs. Composición. Se dice que se debe *"favorecer la composición frente a la herencia"*, ¿por qué?

### Respuesta

La composición permite construir comportamientos a partir de otros objetos sin imponer una jerarquía rígida. Es más flexible porque un objeto compuesto puede cambiar sus componentes en tiempo de ejecución y no queda atado a una estructura de clases fija.

Al favorecer la composición, el diseño queda más desacoplado y se evita heredar implementaciones que no corresponden semánticamente. Esto conduce a un código más mantenible y adaptable.

## 12. Herencia vs. Composición. Se dice que la *"herencia rompe la encapsulación"*, ¿a qué se refiere esto?

### Respuesta

Se refiere a que la herencia expone detalles de la implementación de la superclase a las subclases. Para que las subclases puedan reutilizar la funcionalidad, a menudo se deben usar miembros `protected` o métodos que no forman parte de la interfaz pública, lo que puede debilitar la ocultación de información.

En consecuencia, la subclase puede depender de la implementación interna de la superclase, y cambios en esa implementación pueden afectar inesperadamente a los derivados. Por eso se dice que la herencia puede romper la encapsulación cuando no se usa con cuidado.

## 13. Pongamos un ejemplo de dos alternativas para lo mismo. Tenemos un `Estudiante` y un `Trabajador`, ambos tienen datos en común: el DNI y el nombre. Modelemos esto de dos formas: uno por herencia, con una superclase `Persona`, y otro con composición, con una clase `DatosPersonales`. Se debe recibir una instancia de `DatosPersonales` en el constructor de la clase `Estudiante` y `Trabajador`.

### Respuesta

Con herencia se define una clase común `Persona` que contiene el estado compartido, y `Estudiante` y `Trabajador` extienden de ella. Esta solución es natural cuando existe una relación de tipo clara: un estudiante es una persona y un trabajador es una persona.

Con composición se crea una clase `DatosPersonales` que encapsula `dni` y `nombre`, y cada clase usa una instancia de esa clase. Esta alternativa es útil cuando se quiere evitar una jerarquía de clases rígida y preferir reutilizar datos sin imponer una relación de tipo.

```java
public class Persona {
    private String dni;
    private String nombre;

    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }
}

public class Estudiante extends Persona {
    public Estudiante(String dni, String nombre) {
        super(dni, nombre);
    }
}

public class Trabajador extends Persona {
    public Trabajador(String dni, String nombre) {
        super(dni, nombre);
    }
}

public class DatosPersonales {
    private String dni;
    private String nombre;

    public DatosPersonales(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }
}

public class EstudianteCompuesto {
    private DatosPersonales datos;

    public EstudianteCompuesto(DatosPersonales datos) {
        this.datos = datos;
    }
}

public class TrabajadorCompuesto {
    private DatosPersonales datos;

    public TrabajadorCompuesto(DatosPersonales datos) {
        this.datos = datos;
    }
}
```
