package ejercicio1;

public final class Fecha {

    private final int mes;
    private final int dia;
    private final int anio;

    public Fecha(int dia, int mes, int anio) {

        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getAnio() {
        return anio;
    }
    

    

}
