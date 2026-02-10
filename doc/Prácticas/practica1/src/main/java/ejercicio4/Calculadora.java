package ejercicio4;

public class Calculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    public double sumar(double a, double b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public double multiplicar(int a, double b) {
        return a * b;
    }

    public double dividir(int a, int b) {
        return (double) a / b;
    }

    public double aplicarDescuento(double precio, int porcentaje) {
        return precio - (precio * porcentaje / 100.0);
    }

    public double aplicarDescuento(double precio, double descuentoFijo) {
        return precio - descuentoFijo;
    }

    public double aplicarDescuento(double precio, int porcentaje, double descuentoMaximo) {
        double descuento = precio * porcentaje / 100.0;
        if (descuento > descuentoMaximo) {
            descuento = descuentoMaximo;
        }
        return precio - descuento;
    }
}
