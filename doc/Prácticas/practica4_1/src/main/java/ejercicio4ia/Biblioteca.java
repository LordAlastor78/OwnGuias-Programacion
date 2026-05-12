package ejercicio4ia;

import java.util.*;

public class Biblioteca {
    private final List<Prestamo> prestamos = new ArrayList<>();

    public void registrarPrestamo(Prestamo prestamo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("Préstamo no puede ser null");
        }
        prestamos.add(prestamo);
    }

    public List<Libro> librosPrestadosA(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no puede ser null");
        }
        List<Libro> resultado = new ArrayList<>();

        for (Prestamo p : prestamos) {
            if (p.getUsuario().equals(usuario)) {   
                resultado.add(p.getLibro());
            }
        }
        return resultado;   
    }

    public boolean esUltimaEdicion(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("Libro no puede ser null");
        }
        return libro.getEdicionSiguiente() == null;
    }
}