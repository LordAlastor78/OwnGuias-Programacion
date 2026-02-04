public class Libro {

    String titulo;

    String autor;

    String editorial;

    String anho;

    String isbn;

    public Libro(String titulo, String autor, String editorial, String anho, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
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
                Año = %s
                Isbn = %s
                """.formatted(titulo, autor, editorial, anho, isbn);
    }

}
