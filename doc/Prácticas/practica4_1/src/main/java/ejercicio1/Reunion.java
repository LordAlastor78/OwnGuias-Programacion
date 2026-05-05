package ejercicio1;

import java.lang.invoke.StringConcatException;
import java.security.AlgorithmParameterGeneratorSpi;

public class Reunion {

    private String asunto;
    private String lugar;
    private Hora hora;
    private Fecha fecha;

    public Reunion(String asunto, String lugar, Hora hora, Fecha fecha) {

        this.asunto = asunto;
        this.lugar = lugar;
        this.hora = hora;
        this.fecha = fecha;

    }

    public void nuevaReunion(String asunto, String lugar, Hora hora, Fecha fecha) {

        Reunion newReunion = new Reunion(asunto, lugar, hora, leerFecha())

   

    }

}