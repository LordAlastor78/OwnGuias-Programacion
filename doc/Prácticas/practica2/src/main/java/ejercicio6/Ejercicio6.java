package ejercicio6;

public class Ejercicio6 {

    private double parteReal;
    private double parteImaginaria;

    public Ejercicio6(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    @Override
    public String toString() {
        return String.format("(%.2f + %.2fi)", parteReal, parteImaginaria);

    }

    public Ejercicio6 sumar(Ejercicio6 otro) {
        double nuevaParteReal = this.parteReal + otro.parteReal;
        double nuevaParteImaginaria = this.parteImaginaria + otro.parteImaginaria;
        return new Ejercicio6(nuevaParteReal, nuevaParteImaginaria);
    }

    public double getParteReal() {
        return parteReal;
    }

    public double getParteImaginaria() {
        return parteImaginaria;
    }

    public double valorAbsoluto() {
        return Math.sqrt(parteReal * parteReal + parteImaginaria * parteImaginaria);
    }

    public Ejercicio6 multiplicarporReal(double real) {
        double nuevaParteReal = this.parteReal * real;
        double nuevaParteImaginaria = this.parteImaginaria * real;
        return new Ejercicio6(nuevaParteReal, nuevaParteImaginaria);
    }

    // Metodo factoría
    public static Ejercicio6 real(double real) {
        return new Ejercicio6(real, 0);
    }

}