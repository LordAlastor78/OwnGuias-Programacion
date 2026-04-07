package ejercicio1;

public class Hora {

    private final int hora;
    private final int minuto;

    public Hora(int hora, int minuto) {

        this.hora = hora;
        this.minuto = minuto;
    }

    public Hora(Hora other) {
        this(other.hora, other.minuto);
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

}
