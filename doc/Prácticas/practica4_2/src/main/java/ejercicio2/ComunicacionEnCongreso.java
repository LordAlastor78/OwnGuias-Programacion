package ejercicio2;

import ejercicio1.Autor;

// La comunicación en congreso es también una Publicacion especializada.
public final class ComunicacionEnCongreso extends Publicacion {
    private final String nombreCongreso;
    private final String lugar;
    private final String presentador;

    public ComunicacionEnCongreso(String titulo, int anio, String nombreCongreso, String lugar, String presentador,
            Autor primerAutor, int citas) {
        super(titulo, anio, primerAutor, citas);
        if (nombreCongreso == null || nombreCongreso.isBlank()) {
            throw new IllegalArgumentException("Error: El nombre del congreso no puede ser nulo o vacío.");
        }
        if (lugar == null || lugar.isBlank()) {
            throw new IllegalArgumentException("Error: El lugar no puede ser nulo o vacío.");
        }
        if (presentador == null || presentador.isBlank()) {
            throw new IllegalArgumentException("Error: El presentador no puede ser nulo o vacío.");
        }
        this.nombreCongreso = nombreCongreso;
        this.lugar = lugar;
        this.presentador = presentador;
    }

    public String getNombreCongreso() {
        return nombreCongreso;
    }

    public String getLugar() {
        return lugar;
    }

    public String getPresentador() {
        return presentador;
    }

    @Override
    public String toString() {
        // De nuevo reutilizamos super.toString() para la parte heredada.
        return super.toString() + """
                Congreso: %s
                Lugar: %s
                Presentador: %s
                """.formatted(nombreCongreso, lugar, presentador);
    }
}
