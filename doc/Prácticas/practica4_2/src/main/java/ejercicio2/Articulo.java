// archivo: ejercicio2/Articulo.java
package ejercicio2;

import ejercicio1.Autor;

/*Ejercicio 1: Autor

Crea la clase Autor, que guarda la información del autor de una publicación científica: su identificador (ORCID: Open Researcher and Contributor ID, es un identificador alfanumérico único para cada investigador), su apellidos, nombre e institución al que corresponde. Deberá ser inmutable, tener al menos un constructor y métodos de acceso para todos los atributos (getter).
Ejercicio 2: Jerarquía Publicacion
Tarea 1

Implementa la jerarquía de Publicacion, donde al menos cada una de las clases tenga un constructor y un método toString, que muestre todo su estado (propio y heredado). Todas las clases son inmutables. Deben contener los métodos getter.

Para el método toString de las subclases, hay dos enfoques posibles para incluir los datos heredados:

    Usando super.toString(): la subclase delega en el toString del padre. Es conciso y evita duplicar lógica. Implementa así el toString de Articulo y ComunicacionEnCongreso.
    Usando los getters de la superclase: la subclase accede a los datos heredados a través de los métodos de acceso públicos. Es la única alternativa cuando los atributos del padre son private. Implementa así el toString de Libro.

Reflexiona: super.toString() usa la interfaz pública del padre y es conceptualmente correcto, pero introduce un acoplamiento al formato concreto de su salida. Los getters, en cambio, dependen solo del contrato estable de la clase. ¿Cuáles son las ventajas e inconvenientes de cada enfoque?
Tarea 2

Crea un test de unidad para cada subclase de Publicacion (cada test en su clase test específica). Ese test debe probar el constructor de la subclase, comprobando que se puede acceder después a todos sus atributos, tanto heredados como propios, obteniendo los valores esperados.
Tarea 3

Escribe un programa de prueba (crea un paquete principal y clase AplicacionPublicaciones) donde se utilicen objetos de tipo Articulo, ComunicacionEnCongreso y Libro. Crea un List (ArrayList) de objetos Publicacion, que contenga al menos un objeto de cada una de esas clases. Después, añade código para recorrer la lista mostrando su contenido (toString).
Tarea 4

Las publicaciones científicas normalmente citan a otras. Añade la posibilidad de guardar el número de citas que tiene una publicación dada. La clase debe seguir siendo inmutable.
Tarea 5

Usando la clase Autor, modifica la clase Publicacion para conocer el primer autor (primerAutor) de toda publicación científica. La clase debe seguir siendo inmutable.

*/

// Artículo es una publicación especializada. Hereda los datos comunes de Publicacion.
public final class Articulo extends Publicacion {
    private final String nombreRevista;
    private final int volumen;
    private final int paginaInicial;
    private final int paginaFinal;

    public Articulo(String titulo, int anio, String nombreRevista, int volumen, int paginaInicial, int paginaFinal,
            Autor primerAutor, int citas) {
        // Llamamos al constructor del padre para inicializar título, año, autor y
        // citas.
        super(titulo, anio, primerAutor, citas);
        if (nombreRevista == null || nombreRevista.isBlank()) {
            // isBlank() valida nulos/espacios en blanco en lugar de solo cadena vacía.
            throw new IllegalArgumentException("Error: El nombre de la revista no puede ser nulo o vacío.");
        }
        if (volumen <= 0) {
            throw new IllegalArgumentException("Error: El volumen debe ser mayor que cero.");
        }
        if (paginaInicial <= 0 || paginaFinal <= 0 || paginaFinal < paginaInicial) {
            throw new IllegalArgumentException("Error: Páginas inválidas.");
        }
        this.nombreRevista = nombreRevista;
        this.volumen = volumen;
        this.paginaInicial = paginaInicial;
        this.paginaFinal = paginaFinal;
    }

    // Getters
    public String getNombreRevista() {
        return nombreRevista;
    }

    public int getVolumen() {
        return volumen;
    }

    public int getPaginaInicial() {
        return paginaInicial;
    }

    public int getPaginaFinal() {
        return paginaFinal;
    }

    @Override
    public String toString() {
        // Usamos super.toString() para reutilizar el formato de Publicacion.
        return super.toString() + """
                Revista: %s
                Volumen: %d
                Páginas: %d-%d
                """.formatted(nombreRevista, volumen, paginaInicial, paginaFinal);
    }

}