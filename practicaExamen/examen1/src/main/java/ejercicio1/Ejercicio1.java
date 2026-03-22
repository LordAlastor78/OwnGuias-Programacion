package ejercicio1;

/*### Ejercicio 1 — Clases y objetos
**Temperatura**

Una temperatura tiene un valor numérico y una escala, que puede ser Celsius, Fahrenheit o Kelvin. Crea una clase `Temperatura` que permita:
- Crear una temperatura con su valor y escala
- Convertirla a Celsius (sea cual sea su escala original)
- Visualizarla como por ejemplo: `"36.6 °C"`

En el `main` de `Ejercicio1` crea varias temperaturas y muéstralas todas convertidas a Celsius.

> 💡 Fórmulas: `°C = (°F - 32) / 1.8` | `°C = K - 273.15` */

import java.util.Scanner;

class Temperatura {
    private double valor;
    private String escala;

    public Temperatura(double valor, String escala) {
        this.valor = valor;
        this.escala = escala;
    }

    public double toCelsius() {
        switch (escala.toUpperCase()) {
            case "CELSIUS":
                return valor;
            case "FAHRENHEIT":
                return (valor - 32) / 1.8;
            case "KELVIN":
                return valor - 273.15;
            default:
                throw new IllegalArgumentException("Escala desconocida: " + escala);
        }
    }

    @Override
    public String toString() {
        return String.format("%.1f °C", toCelsius());
    }
}

public class Ejercicio1 {

    public static void main(String[] args) {

        System.out.println("Introduce la temperatura que quieres convertir");

        Temperatura temp1 = new Temperatura(36.6, "Celsius");

        System.out.println(temp1.toCelsius());

    }

}
