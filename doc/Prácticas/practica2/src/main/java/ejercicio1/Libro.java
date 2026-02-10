package ejercicio1;

class Libro {
    String titulo;
    String autores;
    String editorial;
    int anho;
    String isbn;

    Libro(String titulo, String autores, String editorial, int anho, String isbn) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anho = anho;
        this.isbn = isbn;
    }

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
