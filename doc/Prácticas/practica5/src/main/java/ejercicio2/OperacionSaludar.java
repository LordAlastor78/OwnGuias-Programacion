package ejercicio2;

public class OperacionSaludar implements IOperacion {

    @Override
    public void ejecutar() {
        System.out.println("¡Hola! Bienvenido al programa.");
    }

    @Override
    public String getDescripcion() {
        return "Saludar";
    }
}
