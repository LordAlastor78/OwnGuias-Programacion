package ejercicio2;

import ejercicio1.Fecha;
import ejercicio1.Hora;

public class Ejercicio2 {

    private String asunto;
    private String lugar;
    private Fecha fecha;
    private Hora hora;

    public Ejercicio2(String asunto, String lugar, Fecha fecha, Hora hora) {
        this.asunto = asunto;
        this.lugar = lugar;
        this.fecha = new Fecha(fecha);
        this.hora = new Hora(hora);
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

}
