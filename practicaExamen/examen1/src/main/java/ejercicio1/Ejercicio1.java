package ejercicio1;

public class Ejercicio1 {

    public static void main(String[] args) {

        System.out.println("Introduce la temperatura que quieres convertir");

        Temperatura temp1 = new Temperatura(36.6f);

        System.out.println(temp1.toCelsius());

    }

}
