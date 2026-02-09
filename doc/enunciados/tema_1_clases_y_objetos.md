<!--
Posible prompt:
<prompt>
Tengo un cuestionario con preguntas sobre "Clases y Objetos". Debes tener en cuenta que los conocimientos previos que tengo (y por tanto tus respuestas deben ser adaptadas), son:
- C/C++ sin orientación a objetos.
- Temas de Java previos: ninguno.

Cada respuesta debe tener entre 2 - 4 párrafos de longitud (sin contar los trozos de código).

Por favor, escribe en impersonal las respuestas.

</prompt>
----
-->

# TEMA 1. Clases y objetos

## 1. ¿Cuáles son las cuatro características básicas de la programación orientada a objetos? Describe brevemente cada una

Las cuatro características básicas de la programación orientada a objetos son: encapsulación, herencia, polimorfismo y abstracción. La encapsulación se refiere a la agrupación de datos (atributos) y métodos (funciones) que operan sobre esos datos dentro de una unidad llamada clase, lo que permite ocultar la complejidad interna y proteger los datos de accesos no autorizados. La herencia es un mecanismo que permite crear nuevas clases a partir de clases existentes, heredando sus atributos y métodos, lo que facilita la reutilización de código y la creación de jerarquías de clases. El polimorfismo es la capacidad de una función o método para operar con objetos de diferentes clases a través de una interfaz común, lo que permite que el mismo código pueda trabajar con objetos de diferentes tipos. La abstracción es el proceso de ocultar los detalles de implementación y mostrar solo la funcionalidad esencial de un objeto, lo que permite a los desarrolladores centrarse en lo que hace un objeto en lugar de cómo lo hace. Estas características trabajan juntas para permitir la creación de programas más organizados, flexibles y fáciles de mantener.


## 2. Cita cuatro lenguajes populares que permitan la programación orientada a objetos

Estos serían algunos de los lenguajes populares que permiten la programación orientada a objetos: Java, Python, C++, y C#. Java es conocido por su portabilidad y uso en aplicaciones empresariales, mientras que Python es apreciado por su simplicidad y versatilidad en diversos campos como el desarrollo web y la ciencia de datos. C++ es un lenguaje de alto rendimiento utilizado en sistemas operativos y juegos, y C# es ampliamente utilizado en el desarrollo de aplicaciones para Windows y juegos con Unity. Cada uno de estos lenguajes tiene sus propias características y ventajas, pero todos comparten el soporte para la programación orientada a objetos.


## 3. Los paradigmas anteriores a la POO, ¿Qué es la **programación estructurada**? y, todavía mejor, ¿Qué es la **programación modular**?

Es un paradigma de programación que se centra en la estructura del programa, utilizando funciones, procedimientos y bloques de código para organizar y controlar el flujo de ejecución. La programación estructurada promueve el uso de estructuras de control como bucles, condicionales y subrutinas para mejorar la legibilidad y mantenibilidad del código. Por otro lado, la programación modular es una extensión de la programación estructurada que se enfoca en dividir el programa en módulos o unidades independientes, cada uno con una funcionalidad específica. Esto permite una mejor organización del código, facilita la reutilización y mejora la colaboración entre desarrolladores al permitir que trabajen en diferentes módulos sin interferir entre sí.

## 4. ¿Qué tres elementos definen a un objeto en programación orientada a objetos?

Un objeto en programación orientada a objetos se define por tres elementos fundamentales: atributos, métodos y estado. Los atributos son las características o propiedades que describen al objeto, como su nombre, edad o color. Los métodos son las funciones o comportamientos que el objeto puede realizar, como caminar, hablar o calcular algo. El estado se refiere a la combinación de los valores actuales de los atributos del objeto en un momento dado, lo que determina su situación o condición en ese instante. Estos tres elementos trabajan juntos para permitir que los objetos interactúen entre sí y realicen tareas específicas dentro de un programa orientado a objetos. 

## 5. ¿Qué es una clase? ¿Es lo mismo que un objeto? ¿Qué es una instancia? ¿Todos los lenguajes orientados a objetos manejan el concepto de clase?

Una clase es una plantilla o un molde que define las propiedades (atributos) y comportamientos (métodos) que los objetos de ese tipo tendrán. No es lo mismo que un objeto, ya que un objeto es una instancia concreta de una clase, es decir, una entidad específica creada a partir de la clase. La instancia es el proceso de crear un objeto a partir de una clase. No todos los lenguajes orientados a objetos manejan el concepto de clase; algunos, como JavaScript, utilizan prototipos en lugar de clases para definir objetos y su comportamiento.

## 6. ¿Dónde se almacenan en memoria los objetos? ¿Es igual en todos los lenguajes? ¿Qué es la **recolección de basura**? 

La recolección de basura es un proceso automático de gestión de memoria que se encarga de liberar la memoria ocupada por objetos que ya no son accesibles o necesarios en un programa. En lenguajes como Java, la recolección de basura se realiza automáticamente, lo que significa que el programador no tiene que preocuparse por liberar manualmente la memoria. El recolector de basura identifica los objetos que ya no tienen referencias activas y los elimina para liberar espacio en la memoria. Sin embargo, en otros lenguajes como C++, el programador es responsable de gestionar la memoria y debe liberar manualmente los recursos cuando ya no se necesitan, lo que puede llevar a errores como fugas de memoria si no se hace correctamente.


## 7. ¿Qué es un método? ¿Qué es la **sobrecarga de métodos**? 

La sobrecarga de métodos es una característica de algunos lenguajes de programación orientada a objetos que permite definir múltiples métodos con el mismo nombre pero con diferentes parámetros. Esto significa que se pueden crear varias versiones de un método, cada una con una firma diferente (es decir, un número diferente de parámetros o tipos de parámetros diferentes). El compilador o el intérprete del lenguaje determinará cuál versión del método se debe ejecutar en función de los argumentos proporcionados al llamar al método.   


## 8. Ejemplo mínimo de clase en Java, que se llame Punto, con dos atributos, x e y, con un método que se llame `calculaDistanciaAOrigen`, que calcule la distancia a la posición 0,0. Por sencillez, los atributos deben tener visibilidad por defecto. Crea además un ejemplo de uso con una instancia y uso del método

### Respuesta


## 9. ¿Cuál es el punto de entrada en un programa en Java? ¿Qué es `static` y para qué vale? ¿Sólo se emplea para ese método `main`? ¿Para qué se combina con `final`?

El punto de entrada en un programa en Java es el método `main`, que es donde comienza la ejecución del programa. El método `main` debe ser declarado como `public static void main(String[] args)`. La palabra clave `static` indica que el método pertenece a la clase en lugar de a una instancia específica de la clase, lo que permite que el método `main` sea llamado sin necesidad de crear un objeto de la clase. No se emplea exclusivamente para el método `main`; otros métodos también pueden ser declarados como `static` si se desea que pertenezcan a la clase en lugar de a una instancia. La combinación de `static` con `final` se utiliza para declarar constantes, es decir, variables cuyo valor no puede cambiar una vez asignado, lo que garantiza que su valor permanezca constante a lo largo del programa.

- No de necesita un objeto para para usarlos, de usa el nombre de la clase para acceder a ellos, por ejemplo `Clase.metodoEstatico()`.

- No existe el concepto de `this` dentro de un método `static`, ya que no hay una instancia específica a la que referirse.

-No puedo usar desde un método `static` atributos o métodos que no sean `static`, ya que estos últimos requieren una instancia para ser accedidos.

## 10. Intenta ejecutar un poco de Java de forma básica, con los comandos `javac` y `java`. ¿Cómo podemos compilar el programa y ejecutarlo desde linea de comandos? ¿Java es compilado? ¿Qué es la **máquina virtual**? ¿Qué es el *byte-code* y los ficheros `.class`?

### Respuesta


## 11. En el código anterior de la clase `Punto` ¿Qué es `new`? ¿Qué es un **constructor**? Pon un ejemplo de constructor en una clase `Empleado` que tenga DNI, nombre y apellidos

### Respuesta


## 12. ¿Qué es la referencia `this`? ¿Se llama igual en todos los lenguajes? Pon un ejemplo del uso de `this` en la clase `Punto`

### Respuesta


## 13. Añade ahora otro nuevo método que se llame `distanciaA`, que reciba un `Punto` como parámetro y calcule la distancia entre `this` y el punto proporcionado

### Respuesta


## 14. El paso del `Punto` como parámetro a un método, es **por copia** o **por referencia**, es decir, si se cambia el valor de algún atributo del punto pasado como parámetro, dichos cambios afectan al objeto fuera del método? ¿Qué ocurre si en vez de un `Punto`, se recibiese un entero (`int`) y dicho entero se modificase dentro de la función? 

### Respuesta


## 15. ¿Qué es el método `toString()` en Java? ¿Existe en otros lenguajes? Pon un ejemplo de `toString()` en la clase `Punto` en Java

### Respuesta


## 16. Reflexiona: ¿una clase es como un `struct` en C? ¿Qué le falta al `struct` para ser como una clase y las variables de ese tipo ser instancias?


### Respuesta


## 17. Quitemos un poco de magia a todo esto: ¿Como se podría “emular”, con `struct` en C, la clase `Punto`, con su función para calcular la distancia al origen? ¿Qué ha pasado con `this`?

### Respuesta
