package ejercicio3;

public enum TipoIVA {
    GENERAL(0.21, "general"),
    REDUCIDO(0.10, "reducido"),
    SUPERREDUCIDO(0.04, "superreducido"),
    EXENTO(0.0, "exento");

    private final double porcentaje;
    private final String nombre;

    TipoIVA(double porcentaje, String nombre) {
        this.porcentaje = porcentaje;
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public String getNombre() {
        return nombre;
    }
}