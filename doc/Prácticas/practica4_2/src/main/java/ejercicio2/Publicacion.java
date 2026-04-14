package ejercicio2;

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

public class Publicacion {// Lo que hace abstract es que no se puedan crear objetos de tipo Publicacion,
                          // pero como no lo hemos visto aun, lo dejamos asi. De hecho, en el ejercicio 3
                          // se pide crear un List de Publicacion, y si la clase es abstract no se pueden
                          // crear objetos de tipo Publicacion, por lo que no se podría hacer el ejercicio
                          // 3.

    protected int año;
    protected String titulo;

    public Publicacion(String titulo, int año) {

        if (año == 0) {
            throw new IllegalArgumentException("Error: El año no puede ser cero.");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Error: El título no puede ser nulo o vacío.");
        }

        this.titulo = titulo;
        this.año = año;

    }

    public int getAño() {
        return año;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return """
                Año: %s
                Título: %s
                 """.formatted(año, titulo);
    }

}
