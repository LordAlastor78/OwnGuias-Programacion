package ejercicio1;

import java.util.Scanner;

/* Ejercicio 1: 

Los puntos son coordenadas cartesianas de dos 
dimensiones x e y que se expresan como "(x, y)".
Es posible calcular la distancia al origen 
(que siempre es (0, 0)) mediante la 
raíz cuadrada de la suma de las coordenadas al cuadrado. 
Crea una clase para manejar dicha información. */

public class Ejercicio1 {

    public static void main(String[] args) {
        Punto punto = new Punto(3, 4);

        Punto punto2 = new Punto(6, 8);

        Punto punto3 = new Punto(1, 1);

        Punto punto4 = new Punto(0, 0);

        System.out.println("Distancia del punto " + punto + " al origen: " + punto.distanciaAlOrigen());

        System.out.println("Punto 2: " + punto2);

        System.out.println("Punto 3: " + punto3);

        System.out.println("Punto 4: " + punto4);

        // Distancia al centro (0,0)

    System.out.println("Distancia del punto " + punto + " al centro: " + punto.distanciaAlCentro());

    }

    public static void main1(String[] args) {

        Punto punto = new Punto(3, 4);

        System.out.println("El punto es: " + punto);

    }

}
