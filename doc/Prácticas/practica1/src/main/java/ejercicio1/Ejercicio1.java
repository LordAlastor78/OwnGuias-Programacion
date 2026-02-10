package ejercicio1;

/*Ejercicio 1

Los puntos son coordenadas cartesianas de
dos dimensiones x e y que se expresan como "(x, y)".
Es posible calcular la distancia al origen (que siempre es (0, 0)) 
mediante la raíz cuadrada de la suma de las coordenadas 
al cuadrado. Crea una clase para manejar dicha información. 
*/

public class Ejercicio1 {

    public static void main(String[] args) {

        Punto punto1 = new Punto(3, 4);
        
        System.out.println("La distancia al origen es: " + punto1.distanciaOrigen(3, 4));
        
    }

}
