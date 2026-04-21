package ejercicio2;

public class OperacionChiste implements IOperacion {

    @Override
    public void ejecutar() {
        System.out.println("¿Por qué los programadores confunden Halloween con Navidad? Porque OCT 31 == DEC 25.");
    }

    @Override
    public String getDescripcion() {
        return "Contar un chiste de programación";
    }

}
