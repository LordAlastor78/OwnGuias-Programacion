package ejercicio3;

public class Libro {
    // Atributos (datos del libro)
    private String titulo;
    private String autores;
    private String editorial;
    private String año;
    private String isbn;

    // Constructor: recibe los datos y los GUARDA en los atributos
    public Libro(String titulo, String autores, String editorial, String año, String isbn) {
        this.titulo = titulo;       // "this.titulo" = atributo, "titulo" = parámetro
        this.autores = autores;
        this.editorial = editorial;
        this.año = año;
        this.isbn = isbn;
    }

    // Método para mostrar el libro EXACTAMENTE como pide el enunciado
    @Override
    public String toString() {
        return "Titulo = " + titulo + "\n" +
               "Autores = " + autores + "\n" +
               "Editorial = " + editorial + "\n" +
               "Año = " + año + "\n" +
               "Isbn = " + isbn;
    }
}