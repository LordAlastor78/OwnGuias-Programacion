package ejercicio5;

public class Ejercicio5 {

    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo(4, 60.0, 6.0);

        double distanciaLleno = vehiculo.distanciaConDepositoLleno();
        System.out.println("Distancia con deposito lleno: " + distanciaLleno + " km");

        double distanciaCon20 = vehiculo.distanciaConLitros(20.0);
        System.out.println("Distancia con 20 litros: " + distanciaCon20 + " km");
    }
}
