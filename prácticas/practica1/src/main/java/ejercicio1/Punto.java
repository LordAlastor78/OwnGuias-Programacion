package ejercicio1;

public class Punto {

    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanciaAlOrigen() {
        return Math.sqrt(x * x + y * y);
    }

    //distancia al centro (0,0)
    public double distanciaAlCentro() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}