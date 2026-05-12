package ejercicio4ia;

import java.time.LocalDate;
import java.util.Objects;

public class Prestamo {
    private final Libro libro;
    private final Usuario usuario;
    private final LocalDate fechaInicio;

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaInicio) {
        if (libro == null || usuario == null || fechaInicio == null) {
            throw new IllegalArgumentException("Parámetros no pueden ser null");
        }
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Prestamo p))
            return false;
        return Objects.equals(libro, p.libro) &&
                Objects.equals(usuario, p.usuario) &&
                Objects.equals(fechaInicio, p.fechaInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libro, usuario, fechaInicio);
    }
}