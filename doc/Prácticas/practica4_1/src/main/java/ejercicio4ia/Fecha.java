package ejercicio4ia;

public class Fecha {

    private final int dia;

    private final int mes;

    private final int anio;

    public Fecha(int dia, int mes, int anio) {

        if (dia <= 0 || mes <= 0 || anio <= 0) {

            throw new IllegalArgumentException("Dia, mes y anio deben ser mayores que 0");
        }
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

}
