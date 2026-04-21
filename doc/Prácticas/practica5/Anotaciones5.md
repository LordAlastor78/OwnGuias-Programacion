


Práctica 5: Polimorfismo 


El prolimorfismo de define de manera dencilla con que  un mismo mensaje se pueden obtener diferentes comportamientos.

De esta manera de usa `abstract` para definir una clase que no se puede instanciar, pero que si se pueden crear subclases que hereden de ella.

En el siguiente ejemplo se define una clase `Animal` que es abstracta, y luego se crean dos subclases `Perro` y `Gato` que heredan de `Animal` y implementan el método `hacerSonido()` de manera diferente.

Puedes hacer con herencia que sería un "es-un" , es decir, un perro es un animal, un gato es un animal, pero no se puede crear un animal directamente.

```java
abstract class Animal {
    abstract void hacerSonido();
}
abstract class Perro extends Animal {
    void hacerSonido() {
        System.out.println("Guau");
    }
}
abstract class Gato extends Animal {
    void hacerSonido() {
        System.out.println("Miau");
    }
}
```


otro ejemplo avanzado más complejo :

```java
abstract class Figura {
    abstract double area();
}
class Circulo extends Figura {
    double radio;
    Circulo(double radio) {
        this.radio = radio;
    }
    double area() {
        return Math.PI * radio * radio;
    }
}
class Rectangulo extends Figura { //herencia->extends
    double ancho;
    double alto;
    Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
    double area() {
        return ancho * alto;
    }
}
```
En este ejemplo se define una clase `Figura` que es abstracta, y luego se crean dos subclases `Circulo` y `Rectangulo` que heredan de `Figura` y implementan el método `area()` de manera diferente.

Herencia -> override -> polimorfismo ( toString)

Overload ->sobre->escritura
            |
            |-> sobrecarga

*Clases abstractas: es-un , " abstract " , estado -> metodo abstracto

*Interfaces: tiene un contrato, no tiene estado, solo tiene metodos abstractos, se implementa con " implements " , es-una. COMPORTAMIENTO -> metodo abstracto



Como todo esto es " abstracto " de entender veamos herencia , polimorfismo y composición comparándolas entre sí.

Composición: es un mecanismo que permite `crear una nueva clase a partir de otras clases`, utilizando sus atributos y métodos como parte de su propia implementación. La composición se utiliza para modelar relaciones "tiene-un" entre clases, pero a diferencia de la herencia, no implica una relación de tipo "es-un".

Herencia: es un mecanismo que permite `crear una nueva clase` a partir de una clase existente, heredando sus atributos y métodos. La nueva clase se llama subclase o clase hija, y la clase existente se llama superclase o clase padre. La herencia se utiliza para modelar relaciones "es-un" entre clases.

Polimorfismo: es un mecanismo que permite que una `misma operación o método pueda tener diferentes comportamientos` dependiendo del tipo de objeto que lo invoque. El polimorfismo se utiliza para modelar relaciones "tiene-un" entre clases.



