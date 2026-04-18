package ejercicio1;

public final class Fecha {

    private final int dia;
    private final int mes;
    private final int anio;

    public Fecha(int dia, int mes, int anio) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes fuera de rango: " + mes);
        }
        if (dia < 1 || dia > diasEnMes(mes, anio)) {
            throw new IllegalArgumentException("Día fuera de rango: " + dia);
        }
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Fecha(Fecha other) {
        this(other.dia, other.mes, other.anio);
    }

    private static int diasEnMes(int mes, int anio) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return esBisiesto(anio) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Mes inválido: " + mes);
        }
    }

    private static boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
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

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Fecha fecha = (Fecha) o;
        return dia == fecha.dia && mes == fecha.mes && anio == fecha.anio;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(dia);
        result = 31 * result + Integer.hashCode(mes);
        result = 31 * result + Integer.hashCode(anio);
        return result;
    }

}
