package ejercicio1;

class Libro {
    private final String titulo;
    private final String autores;
    private final String editorial;
    private final int anho;
    private final String isbn;
    private final TipoLibro tipolibro;


    // Constructor con TipoLibro
    Libro(String titulo, String autores, String editorial, int anho, TipoLibro tipolibro) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anho = anho;
        this.isbn = "desconocido";
        this.tipolibro = tipolibro;
    }

    // Constructor sin TipoLibro
    Libro(String titulo, String autores, String editorial, int anho) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anho = anho;
        this.isbn = "desconocido";
        this.tipolibro = null;
    }

    // Getters(devolver un atributo concreto) y Setters(modificar un atributo
    // concreto)

    public String getTitulo() {
        return titulo;
    }

    public int getAnho() {
        return anho;
    }

    // Removed setter with final to maintain immutability
    /*
    public void setAnho(int anho) {
        if (anho > 0) this.anho = anho;

    }*/

    @Override
    public String toString() {
        return """
                Titulo = %s
                Autores = %s
                Editorial = %s
                Año = %d
                Isbn = %s""".formatted(titulo, autores, editorial, anho, isbn);
    }
}
