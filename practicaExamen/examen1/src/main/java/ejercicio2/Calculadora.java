package ejercicio2;

import java.util.Scanner;

/*Ejercicio 4

Crea una clase Calculadora que permita realizar operaciones matemáticas mediante 
sobrecarga de métodos. La clase debe tener métodos para:

    Sumar dos números enteros
    Sumar tres números enteros
    Aplicar un descuento porcentual a un precio (recibe precio y porcentaje de descuento)
    Aplicar un descuento fijo a un precio (recibe precio y cantidad fija a descontar)
    Aplicar un descuento porcentual con un límite máximo (recibe precio, porcentaje y descuento máximo permitido)

En vez de probar la clase Calculadora en el método main, 
empleando JUnit 5, crea un CalculadoraTest. Para introducirte en JUnit 5 y 
resolver el ejercicio debes consultar la documentación que te aportamos. 

*/

public class Calculadora {

    public float suma(int a, int b) {
        return a + b;
    }

    public float resta(int a, int b) {

        return a - b;
    }

    public double applyDiscount(float precio, float discount) {

        float finalDiscount = 0;

        finalDiscount = discount / 100;

        precio = precio - precio * finalDiscount;

        return precio;

    }

}
