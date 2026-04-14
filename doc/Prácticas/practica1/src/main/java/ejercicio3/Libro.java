package ejercicio3;

public class Libro {
    // Atributos (datos del libro)
    private String titulo;
    private String autores;
    private String editorial;
    private String anio;
    private String isbn;

    // Constructor: recibe los datos y los guarda en los atributos
    public Libro(String titulo, String autores, String editorial, String anio, String isbn) {
        this.titulo = titulo; // this.titulo = atributo, titulo = parametro
        this.autores = autores;
        this.editorial = editorial;
        this.anio = anio;
        this.isbn = isbn;
    }

    // Método para mostrar el libro EXACTAMENTE como pide el enunciado
    @Override
    public String toString() {
        return "Titulo = " + titulo + "\n" +
                "Autores = " + autores + "\n" +
                "Editorial = " + editorial + "\n" +
                "Anio = " + anio + "\n" +
                "Isbn = " + isbn;
    }
}