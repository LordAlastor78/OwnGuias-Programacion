package ejercicio1;

class Libro {
    String titulo;
    String autores;
    String editorial;
    int anho;
    String isbn;

    // Constructor
    Libro(String titulo, String autores, String editorial, int anho) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anho = anho;
        this.isbn = "desconocido";
    }

    // Getters(devolver un atributo concreto) y Setters(modificar un atributo
    // concreto)

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
