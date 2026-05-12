package ejercicio1;

public final class Autor {
    private final String orcid;
    private final String apellidos;
    private final String nombre;
    private final String institucion;

    // Constructor completo
    public Autor(String orcid, String apellidos, String nombre, String institucion) {

        if (orcid == null || orcid.isBlank()) {
            throw new IllegalArgumentException("El ORCID no puede ser nulo o vacío.");
        }
        this.orcid = orcid;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.institucion = institucion;
    }

    // Constructor con institución por defecto
    public Autor(String orcid, String apellidos, String nombre) {
        this(orcid, apellidos, nombre, "Universidad de Vigo"); // delegación al constructor anterior
    }

    // Getters
    public String getOrcid() {
        return orcid;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInstitucion() {
        return institucion;
    }

    @Override
    public String toString() {
        return """
                ORCID: %s
                Apellidos: %s
                Nombre: %s
                Institución: %s
                """.formatted(orcid, apellidos, nombre, institucion);
    } // TEXT BLOCK + FORMATTED
}