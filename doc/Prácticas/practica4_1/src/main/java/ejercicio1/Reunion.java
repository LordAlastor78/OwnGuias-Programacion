package ejercicio1;

public class Reunion {

    private String asunto;
    private String lugar;
    private Fecha fecha;
    private Hora hora;


    public Reunion(String asunto, String lugar, Fecha fecha, Hora hora) {
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

    // Getters que garantizan composición fuerte devolviendo copias
    public Fecha getFecha() {
        return new Fecha(this.fecha);
    }

    public void setFecha(Fecha fecha) {
        if (fecha == null) throw new IllegalArgumentException("Fecha no puede ser nula");
        this.fecha = new Fecha(fecha);
    }

    public Hora getHora() {
        return new Hora(this.hora);
    }

    public void setHora(Hora hora) {
        if (hora == null) throw new IllegalArgumentException("Hora no puede ser nula");
        this.hora = new Hora(hora);
    }

    @Override
    public String toString() {
        return "Reunion{" +
                "asunto='" + asunto + '\'' +
                ", lugar='" + lugar + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                '}';
    }

}
