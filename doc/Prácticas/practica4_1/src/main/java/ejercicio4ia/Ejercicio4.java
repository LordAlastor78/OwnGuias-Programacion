package ejercicio4ia;

/*

 📝 **Ejercicio de Examen: Sistema de Biblioteca**

#### Diagrama UML (multiplicidades):

prestamo
0..*
0..*
1
1

Libro      Usuario
   \         /
    \       /
     Prestamo


> Además, `Libro` tiene una relación reflexiva:

edicionAnterior / edicionSiguiente
0..1           0..1
0..1           0..1

Libro ─── Libro


---

### 📚 Enunciado

Queremos modelar un sistema sencillo de **préstamos de libros** en una biblioteca.

#### Tarea 1: Clase `Libro` (inmutable)
Crea una clase `Libro` con los siguientes atributos:
- `titulo` (String)
- `isbn` (String, debe tener exactamente 13 caracteres numéricos)
- `anioPublicacion` (int, ≥ 1400)

La clase debe ser **inmutable**.  
Además, un libro puede tener una **edición anterior** y una **edición siguiente** 
(por ejemplo, 2ª edición → 3ª edición). Esta relación es **reflexiva**, **bidireccional** y **débil**.

Implementa:
- Constructor con validación de ISBN y año.
- Getters para todos los atributos.
- Métodos `getEdicionAnterior()` y `getEdicionSiguiente()`.
- **Método privado** `setEdicionSiguiente(Libro siguiente)` que garantice consistencia bidireccional 
(similar al Ejercicio 3 del tren):  
  - Si este libro ya tenía una edición siguiente, se desconecta.
  - Si la nueva edición siguiente ya tenía una anterior, también se desconecta.
  - Luego se conectan mutuamente.

> ⚠️ No expongas ningún setter público para `edicionAnterior` ni `edicionSiguiente`.

#### Tarea 2: Clase `Usuario` (inmutable)
Crea una clase `Usuario` con:
- `nombre` (String)
- `idUsuario` (String, no vacío)

Inmutable. Solo constructor y getters.

#### Tarea 3: Clase `Prestamo`
Un préstamo asocia **un libro** y **un usuario**, con una fecha de inicio 
(`LocalDate` de Java — puedes usar `java.time.LocalDate`).

Relación:
- `Prestamo → Libro`: `1..1`
- `Libro → Prestamo`: `0..1`  
- `Prestamo → Usuario`: `1..1`
- `Usuario → Prestamo`: `0..*`

Implementa:
- Constructor que reciba `Libro`, `Usuario` y `LocalDate`.
- Validación: ningún parámetro puede ser `null`.
- Getters.
- La clase `Prestamo` es **inmutable**.

#### Tarea 4: Clase `Biblioteca`
La biblioteca gestiona préstamos. Tiene:
- Una lista de `Prestamo` (mutable).
- Método `registrarPrestamo(Prestamo p)` → añade a la lista.
- Método `librosPrestadosA(Usuario u)` → devuelve una `List<Libro>` con los libros actualmente prestados a ese usuario.
- Método `esUltimaEdicion(Libro l)` → devuelve `true` si `l` **no tiene edición siguiente**.

> Usa composición débil: la biblioteca **usa** los préstamos, pero no los posee exclusivamente.

#### Tarea 5: Tests unitarios
Escribe tests que verifiquen:
1. Que al conectar dos ediciones de un libro (ej: "Java 17" → "Java 21"), los enlaces `anterior`/`siguiente` son consistentes.
2. Que `esUltimaEdicion()` devuelve `true` solo para la última edición.
3. Que `librosPrestadosA(usuario)` devuelve la lista correcta cuando hay 2 préstamos a ese usuario y 1 a otro.
4. Que se lanza excepción si se intenta crear un `Libro` con ISBN inválido (ej: "123", o "123456789012X").


*/

public class Ejercicio4 {

}
