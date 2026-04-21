package ejercicio2;

import java.time.LocalDate;

public class OperacionFecha implements IOperacion {

    @Override
    public void ejecutar() {
        System.out.println("Hoy es: " + LocalDate.now());
    }

    @Override
    public String getDescripcion() {
        return "¿Qué día es hoy?";
    }

}
