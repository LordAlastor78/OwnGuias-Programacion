
## 🧪 Ejercicios de práctica — Programación II

---

### Ejercicio 1 — Clases y objetos
**Temperatura**

Una temperatura tiene un valor numérico y una escala, que puede ser Celsius, Fahrenheit o Kelvin. Crea una clase `Temperatura` que permita:
- Crear una temperatura con su valor y escala
- Convertirla a Celsius (sea cual sea su escala original)
- Visualizarla como por ejemplo: `"36.6 °C"`

En el `main` de `Ejercicio1` crea varias temperaturas y muéstralas todas convertidas a Celsius.

> 💡 Fórmulas: `°C = (°F - 32) / 1.8` | `°C = K - 273.15`

---

### Ejercicio 2 — Encapsulación + enumerado
**Producto de supermercado**

Un producto tiene nombre, precio base y una categoría que puede ser: `ALIMENTACION`, `LIMPIEZA`, `ELECTRONICA` o `ROPA`. Cada categoría tiene un descuento automático aplicado al precio:
- Alimentación → 5%
- Limpieza → 10%
- Electrónica → 0%
- Ropa → 15%

Crea un enumerado `CategoriaProducto` que **encapsule dentro de sí mismo el porcentaje de descuento** y la lógica para calcular el precio final. Crea la clase `Producto` inmutable y encapsulada. Muestra el producto con nombre y precio final.

Crea al menos **2 tests JUnit** para el enumerado `CategoriaProducto`.

---

### Ejercicio 3 — Arrays + menú interactivo
**Gestión de una biblioteca**

Un libro tiene título, autor y año. Crea la clase `Libro` encapsulada e inmutable.

En `Ejercicio3`, almacena los libros en un **array primitivo** de tamaño máximo 10 e implementa un menú con estas opciones:

1. Añadir un libro (datos por teclado, si hay espacio)
2. Listar todos los libros
3. Buscar libros por autor (muestra todos los que coincidan)
4. Estadísticas: total de libros y espacios libres

Apóyate en **métodos estáticos auxiliares** para que el `main` sea limpio y legible.

---

### Ejercicio 4 — Excepciones
**Cuenta de ahorro con límite**

Crea una clase `CuentaAhorro` con saldo, un límite máximo de saldo permitido (fijado en la construcción) y que permita ingresar y retirar. Las invariantes son:
- El saldo **nunca puede ser negativo**
- El saldo **nunca puede superar el límite máximo**

Si se viola cualquiera de las dos, lanza una `IllegalArgumentException` con un mensaje descriptivo.

No crees `main`. Crea **4 tests JUnit**: 2 para casos normales, 2 para casos que violan las invariantes (usando `assertThrows`).

---

### Ejercicio 5 — Todo mezclado
**Club de atletismo**

Un atleta tiene un dni, nombre, y una marca personal en segundos (un `double`). La categoría del atleta se determina por su marca:

| Categoría | Marca (segundos, 100m) |
|---|---|
| `ELITE` | < 11.0 |
| `AVANZADO` | 11.0 – 12.9 |
| `INTERMEDIO` | 13.0 – 15.9 |
| `PRINCIPIANTE` | ≥ 16.0 |

Crea el enumerado `CategoriaAtleta` con la lógica de clasificación encapsulada dentro (un método estático `calcular(double marca)`). La clase `Atleta` es mutable en la marca (puede mejorarla), pero valida que la marca no sea negativa lanzando una excepción.

En `Ejercicio5`, guarda atletas en un array de tamaño 5 con un menú:
1. Añadir atleta
2. Listar atletas con su categoría
3. Actualizar la marca de un atleta (por posición)

Crea **3 tests JUnit** para `CategoriaAtleta` y **2 tests** para `Atleta` (un caso normal y uno excepcional).

---
