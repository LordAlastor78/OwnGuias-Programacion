# 📘 **Apuntes completos: Excepciones, Invariantes, Interfaces y Sobrecarga en Java**  

*Para la Práctica 3 de Programación II – Enfoque práctico, detallado*

---

## 🔹 **1. Excepciones en Java: Fundamentos**

### ¿Qué es una excepción?
Una **excepción** es un evento que ocurre durante la ejecución de un programa y **interrumpe el flujo normal**. Representa una condición anómala (error o situación inesperada).

> **Objetivo**: manejar errores de forma controlada, evitando que el programa se cierre abruptamente.

---

### Tipos de excepciones

| Tipo | Hereda de | ¿Verificada? | ¿Obliga a try-catch? | Ejemplos |
|------|-----------|--------------|------------------------|---------|
| **Excepciones verificadas** (*checked*) | `Exception` (pero **no** `RuntimeException`) | ✅ Sí | ✅ Sí | `IOException`, `FileNotFoundException` |
| **Excepciones no verificadas** (*unchecked*) | `RuntimeException` | ❌ No | ❌ No | `ArithmeticException`, `NumberFormatException`, `IllegalArgumentException`, `NullPointerException` |
| **Errores** | `Error` | ❌ No | ❌ No | `OutOfMemoryError`, `StackOverflowError` |

> 💡 **Regla clave**:  
> - Si un método **puede lanzar una excepción verificada**, debes declararla con `throws` o capturarla con `try-catch`.  
> - Las no verificadas **no obligan**, pero igual debes manejarlas si quieres evitar fallos.

---

### Palabras clave esenciales

#### ✅ `throw`
- **Lanza** una excepción manualmente.
- Sintaxis:  
  ```java
  throw new NombreExcepcion("Mensaje descriptivo");
  ```
- Ejemplo:
  ```java
  if (divisor == 0) {
      throw new ArithmeticException("No se puede dividir por cero");
  }
  ```

#### ✅ `throws`
- **Declara** en la firma del método que puede lanzar una excepción **verificada**.
- Sintaxis:
  ```java
  public void metodo() throws IOException { ... }
  ```
- Permite **delegar** la responsabilidad al código que llama al método.

#### ✅ `try-catch`
- **Captura y maneja** excepciones.
- Sintaxis:
  ```java
  try {
      // Código riesgoso
  } catch (TipoExcepcion1 e) {
      // Manejo para TipoExcepcion1
  } catch (TipoExcepcion2 e) {
      // Manejo para TipoExcepcion2
  } finally {
      // Opcional: siempre se ejecuta
  }
  ```
- **Orden de los catch**: de más específico a más general.  
  ❌ Mal: `catch (Exception e)` antes que `catch (IOException e)`  
  ✅ Bien: `catch (AccessDeniedException e)` antes que `catch (IOException e)`

#### ✅ `finally`
- Bloque que **siempre se ejecuta**, incluso si hay `return` o excepción no capturada.
- Ideal para **liberar recursos** (cerrar ficheros, conexiones, etc.).

---

### Errores comunes con excepciones

| Error | Solución |
|------|--------|
| Capturar `Exception` genérica | Captura el tipo específico (`NumberFormatException`, `IOException`, etc.) |
| Ignorar la excepción (`catch { }` vacío) | Siempre muestra un mensaje o registra el error |
| Usar `throws Exception` en lugar del tipo real | Declara solo las excepciones que realmente lanza |
| Olvidar `throws` en métodos con excepciones verificadas | El código no compila |

---

## 🔹 **2. Aplicación en Ejercicio 1: Validación de entrada y división segura**

### Objetivo
- Validar que el usuario introduzca **enteros válidos**.
- Evitar **división por cero**.
- Reintentar hasta obtener datos correctos.

### Estrategia

#### Paso 1: Validar entrada con bucle + `try-catch`
```java
Scanner scan = new Scanner(System.in);
int num;

while (true) {
    System.out.print("Introduce un número: ");
    String input = scan.nextLine();
    try {
        num = Integer.parseInt(input); // ← Puede lanzar NumberFormatException
        break; // Sale si es válido
    } catch (NumberFormatException e) {
        System.err.println("❌ Entrada inválida. Debe ser un entero.");
        // El bucle se repite
    }
}
```

> ✅ Usa `nextLine()` + `parseInt()` → evita problemas del buffer de `nextInt()`.

#### Paso 2: Manejar división por cero (dos opciones)

**Opción A (lanzar tú la excepción)**:
```java
public static int divide(int a, int b) {
    if (b == 0) {
        throw new ArithmeticException("El divisor no puede ser cero");
    }
    return a / b;
}
```

**Opción B (dejar que Java la lance)**:
```java
public static int divide(int a, int b) {
    return a / b; // Java lanza ArithmeticException si b == 0
}
```

Ambas se capturan igual en `main`:
```java
try {
    int r = divide(n1, n2);
    System.out.println("Resultado: " + r);
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
```

> 💡 **Recomendación**: usa **Opción A** para mensajes más claros.

---

## 🔹 **3. Aplicación en Ejercicio 2: Ficheros y excepciones verificadas**

### Problema inicial
`Files.readAllBytes()` y `Files.write()` lanzan `IOException` → **excepción verificada** → obliga a manejarla.

### Principio de diseño: **Clases reutilizables**
- Una clase como `OperadorFichero` **no debe asumir cómo manejar errores**.
- Solo debe **avisar** de que pueden ocurrir → usa `throws`.

#### ✅ `OperadorFichero` corregido
```java
import java.io.IOException;
import java.nio.file.*;

public class OperadorFichero {
    private Path fichero;

    public OperadorFichero(Path fichero) {
        if (!Files.exists(fichero)) {
            throw new IllegalArgumentException("El fichero no existe: " + fichero);
        }
        this.fichero = fichero;
    }

    public String leerFichero() throws IOException {
        return new String(Files.readAllBytes(this.fichero));
    }

    public void añadirTexto(String texto) throws IOException {
        Files.write(this.fichero, texto.getBytes(), StandardOpenOption.APPEND);
    }
}
```

> ✅ Constructor: valida existencia → lanza `IllegalArgumentException` (no verificada).  
> ✅ Métodos: declaran `throws IOException` → delegan manejo al usuario.

---

### `AplicacionFichero`: manejo completo de errores

#### Tarea 4: Pedir ruta hasta que exista
```java
Path fichero;
OperadorFichero operador;

while (true) {
    System.out.print("Ruta del fichero: ");
    String ruta = entrada.nextLine();
    fichero = Path.of(ruta);
    try {
        operador = new OperadorFichero(fichero); // ← Puede lanzar IllegalArgumentException
        break;
    } catch (IllegalArgumentException e) {
        System.out.println("❌ Fichero no encontrado. Inténtalo de nuevo.");
    }
}
```

#### Tarea 3: Manejar `IOException` específicamente
```java
try {
    System.out.println(operador.leerFichero());
    // ... lógica de escritura ...
} catch (AccessDeniedException e) {
    System.err.println("❌ Acceso denegado: permisos insuficientes.");
    System.exit(1);
} catch (IOException e) {
    System.err.println("❌ Error de E/S: " + e.getMessage());
    System.exit(1);
}
```

> ✅ `AccessDeniedException` es subclase de `IOException` → debe ir **antes**.

#### Tarea 5: Garantizar limpieza final
```java
Scanner entrada = new Scanner(System.in);
try {
    // Toda la lógica aquí
} catch (Exception e) {
    // Manejo de errores
} finally {
    entrada.close();
    System.out.println("Que tengas un buen día");
}
```

> ✅ `finally` asegura que el mensaje y el cierre ocurran **siempre**.

---

## 🔹 **4. Invariantes de clase**

### ¿Qué es una invariante?
Una **condición que siempre debe ser verdadera** para cualquier objeto de la clase, en todo momento de su vida.

> **Principio**: *"Un objeto nunca debe estar en un estado inválido."*

### Cómo mantenerla
1. **Validar en el constructor**.
2. **Validar en cada método modificador**.
3. **Lanzar excepciones** si se intenta violarla.

### Ejemplo: `Cuenta` (Ejercicio 3)
- **Invariante**: `saldo >= 0`
- **Implementación**:
  ```java
  public class Cuenta {
      private double saldo;

      public Cuenta(double saldoInicial) {
          if (saldoInicial < 0) {
              throw new IllegalArgumentException("Saldo inicial no puede ser negativo");
          }
          this.saldo = saldoInicial;
      }

      public void retirar(double cantidad) {
          if (cantidad <= 0) {
              throw new IllegalArgumentException("Cantidad debe ser positiva");
          }
          if (this.saldo - cantidad < 0) {
              throw new IllegalStateException("Saldo insuficiente");
          }
          this.saldo -= cantidad;
      }

      public void ingresar(double cantidad) {
          if (cantidad <= 0) {
              throw new IllegalArgumentException("Cantidad debe ser positiva");
          }
          this.saldo += cantidad;
      }

      public double getSaldo() {
          return this.saldo;
      }
  }
  ```

> ✅ Nunca permite saldo negativo.  
> ✅ Usa `IllegalStateException` para violaciones de estado (no de argumentos).

---

## 🔹 **5. Enumerados (`enum`) y lógica condicional**

### ¿Qué es un `enum`?
Un tipo especial que define un **conjunto fijo de constantes**.

### Ejemplo: `Categoria` (Ejercicio 4)
```java
public enum Categoria {
    BENJAMIN, ALEVIN, INFANTIL, CADETE, JUVENIL, SENIOR
}
```

### Calcular categoría a partir de edad
```java
public Categoria getCategoria() {
    if (edad <= 8) return Categoria.BENJAMIN;
    else if (edad <= 10) return Categoria.ALEVIN;
    else if (edad <= 12) return Categoria.INFANTIL;
    else if (edad <= 14) return Categoria.CADETE;
    else if (edad <= 18) return Categoria.JUVENIL;
    else return Categoria.SENIOR;
}
```

> ✅ No almacenes `categoria` como atributo → se calcula → siempre coherente con `edad`.

### Validación en `Deportista`
```java
public void setEdad(int edad) {
    if (edad < 0) {
        throw new IllegalArgumentException("La edad no puede ser negativa");
    }
    this.edad = edad;
}
```

> ✅ La invariante aquí es: `edad >= 0` y `categoria = f(edad)`.

---

## 🔹 **6. Sobrecarga de métodos (`overloading`)**

### Definición
Múltiples métodos con **mismo nombre** pero **distinta lista de parámetros**.

### Reglas
- Mismo nombre.
- Distinto número, tipo o orden de parámetros.
- **El tipo de retorno NO cuenta** para distinguir.

### Ejemplo útil en `Cuenta`
```java
public void retirar(double cantidad) { ... }
public void retirar(String cantidadStr) {
    double cantidad = Double.parseDouble(cantidadStr);
    retirar(cantidad); // reutiliza el otro método
}
```

> ✅ Conveniencia para el usuario.  
> ❌ No confundir con *sobreescritura* (`@Override` en herencia).

---

## 🔹 **7. Interfaces (`interface`)**

### Definición
Contrato que define **qué métodos debe tener una clase**, sin implementación (excepto métodos `default`).

### Sintaxis
```java
public interface Operable {
    void operar(); // abstracto
    default void log() { System.out.println("Operación realizada"); }
}
```

### Implementación
```java
public class MiClase implements Operable {
    public void operar() {
        // implementación obligatoria
    }
}
```

> 🔗 En tu práctica: aunque no se pide, podrías definir una interfaz `GestorFichero` si tuvieras múltiples implementaciones.

---

## 🔹 **8. Tests unitarios con JUnit 5 (Ejercicios 3, 4, 5)**

### Estructura básica
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testIngresoValido() {
        Cuenta c = new Cuenta(100);
        c.ingresar(50);
        assertEquals(150, c.getSaldo());
    }

    @Test
    void testRetiroInvalidoLanzaExcepcion() {
        Cuenta c = new Cuenta(100);
        assertThrows(IllegalStateException.class, () -> {
            c.retirar(150);
        });
    }
}
```

### Para `OperadorFichero` (Ejercicio 5)
- Usa `Files.createTempFile()` para crear ficheros temporales.
- Usa `Files.delete()` para simular eliminación.
- Verifica que los métodos lancen excepciones cuando corresponda.

------------------------------------------------------------



