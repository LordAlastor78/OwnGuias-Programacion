package ejercicio2;

import java.util.List;

import ejercicio1.Fecha;
import ejercicio1.Hora;

public class Reunion {
    private String asunto;
    private String lugar;
    private Fecha fecha;
    private Hora hora;
    private List<Empleado> asistentes;
    private Empleado secretario;

    public Reunion(String asunto, String lugar, Fecha fecha, Hora hora) {
        this.asunto = asunto;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
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

    public List<Empleado> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Empleado> asistentes) {
        this.asistentes = asistentes;
    }

    public Empleado getSecretario() {
        return secretario;
    }

    public void setSecretario(Empleado secretario) {
        this.secretario = secretario;
    }

    public void agregarAsistente(Empleado e) {
        if (asistentes != null && !asistentes.contains(e)) {
            asistentes.add(e);
        }
    }

    public void eliminarAsistente(Empleado e) {
        if (asistentes != null) {
            asistentes.remove(e);
        }
    }

    public void setSecretario(Empleado nuevoSecretario) {

        if (!asistentes .contains(nuevoSecretario)) {
            throw new IllegalArgumentException("El secretario debe ser un asistente a la reunión");
        }
        this.secretario = nuevoSecretario;
    }


}
