package ejercicio1;

public final class Fecha {

    private final int mes;
    private final int dia;
    private final int anio;
    private final Hora hora;

    public Fecha(int mes, int dia, int anio, Hora hora) {
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
        this.hora = hora;
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

    public Hora getHora() {
        return hora;
    }

}
