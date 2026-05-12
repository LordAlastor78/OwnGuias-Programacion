package ejercicio4ia;

import java.util.Objects;

public class Usuario {
    private final String nombre;
    private final String idUsuario;

    public Usuario(String nombre, String idUsuario) {
        if (nombre == null || nombre.isBlank() ||
            idUsuario == null || idUsuario.isBlank()) {
            throw new IllegalArgumentException("Datos de usuario obligatorios");
        }
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    public String getNombre() { return nombre; }
    public String getIdUsuario() { return idUsuario; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario u)) return false;
        return Objects.equals(idUsuario, u.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario);
    }
}