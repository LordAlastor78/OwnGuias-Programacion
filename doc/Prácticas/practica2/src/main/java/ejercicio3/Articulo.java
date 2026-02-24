package ejercicio3;

public class Articulo {
    // Atributos PRIVADOS (encapsulación)
    private String nombre;
    private double precioBase;
    private TipoIVA tipoIVA;

    public Articulo(String nombre, double precioBase, TipoIVA tipoIVA) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.tipoIVA = tipoIVA;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public TipoIVA getTipoIVA() {
        return tipoIVA;
    }

    public double getPrecioFinal() {
        return precioBase * (1 + tipoIVA.getPorcentaje());
    }

    @Override
    public String toString() {
        return nombre + ": " + String.format("%.2f", getPrecioFinal()) + " €";
    }

}