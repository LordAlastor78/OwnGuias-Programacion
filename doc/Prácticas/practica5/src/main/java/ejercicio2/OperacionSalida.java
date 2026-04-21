package ejercicio2;

public class OperacionSalida implements IOperacion {

    @Override
    public void ejecutar() {
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }

    @Override
    public String getDescripcion() {
        return "Salir";
    }



}
