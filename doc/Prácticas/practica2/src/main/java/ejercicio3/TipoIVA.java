package ejercicio3;

public enum TipoIVA { // ENUMERACIÓN: conjunto de constantes (valores fijos)
    GENERAL(0.21, "general"),
    REDUCIDO(0.10, "reducido"),
    SUPERREDUCIDO(0.04, "superreducido"),
    EXENTO(0.0, "exento");

    private final double porcentaje;
    private final String nombre;

    TipoIVA(double porcentaje, String nombre) { // constructor del enum, se llama automáticamente para cada constante

        this.porcentaje = porcentaje; // quiero que el porcentaje se asigne al atributo de la clase " mi porcentaje = porcentaje "
        this.nombre = nombre;
    }

    public double getPorcentaje() { // método para obtener el porcentaje de IVA
        return porcentaje;
    }

    public String getNombre() {// método para obtener el nombre del tipo de IVA
        return nombre;
    }

    public double calcularPrecioFinal(double precioBase) {
        return precioBase * (1 + porcentaje);
    }

    

}