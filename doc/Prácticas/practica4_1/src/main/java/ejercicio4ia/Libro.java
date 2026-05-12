package ejercicio4ia;

import java.util.Objects;

public class Libro {
    private final String titulo;
    private final String isbn;
    private final int anioPublicacion;
    private Libro edicionAnterior;
    private Libro edicionSiguiente;

    public Libro(String titulo, String isbn, int anioPublicacion) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título obligatorio");
        }
        if (isbn == null || !isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("ISBN debe ser 13 dígitos numéricos");
        }
        if (anioPublicacion < 1400) {
            throw new IllegalArgumentException("Año inválido");
        }
        this.titulo = titulo;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public Libro getEdicionAnterior() { return edicionAnterior; }
    public Libro getEdicionSiguiente() { return edicionSiguiente; }

    // Método interno para conectar ediciones (solo usado por setEdicionSiguiente)
    void setEdicionSiguiente(Libro siguiente) {
        // 1. Desconectar edición siguiente actual
        if (this.edicionSiguiente != null) {
            this.edicionSiguiente.edicionAnterior = null;
        }
        // 2. Desconectar al nuevo siguiente de su anterior (si lo tenía)
        if (siguiente != null && siguiente.edicionAnterior != null) {
            Libro viejoAnterior = siguiente.edicionAnterior;
            viejoAnterior.edicionSiguiente = null;
        }
        // 3. Establecer nuevo enlace
        this.edicionSiguiente = siguiente;
        if (siguiente != null) {
            siguiente.edicionAnterior = this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro l)) return false;
        return Objects.equals(isbn, l.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}