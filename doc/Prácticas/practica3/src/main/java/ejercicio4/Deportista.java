package ejercicio4;

public class Deportista {
    private String dni;
    private String nombre;
    private int edad;

    public Deportista(String dni, String nombre, int edad) {

        if (edad < 0) {
            throw new IllegalArgumentException("Error: La edad no puede ser negativa.");
        }
        if (dni == null || dni.isBlank()) {
            throw new IllegalArgumentException("Error: El DNI no puede ser nulo o vacío.");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Error: El nombre no puede ser vacío.");
        }

        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }
    public Categoria getCategoria()
    {
        return Categoria.fromCategoria(edad);
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Error: La edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    public String toString() {
        return "Deportista \n\t DNI: %s, Nombre: %s, Edad: %d, Categoria: %s".formatted(dni, nombre, edad,
                getCategoria());
    }
}
