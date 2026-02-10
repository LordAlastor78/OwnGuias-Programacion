package ejercicio5;

public class Vehiculo {

    private int maxPasajeros;
    private double capacidadDeposito;
    private double consumoMedio;

    public Vehiculo(int maxPasajeros, double capacidadDeposito, double consumoMedio) {
        this.maxPasajeros = maxPasajeros;
        this.capacidadDeposito = capacidadDeposito;
        this.consumoMedio = consumoMedio;
    }

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public void setMaxPasajeros(int maxPasajeros) {
        this.maxPasajeros = maxPasajeros;
    }

    public double getCapacidadDeposito() {
        return capacidadDeposito;
    }

    public void setCapacidadDeposito(double capacidadDeposito) {
        this.capacidadDeposito = capacidadDeposito;
    }

    public double getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    public double distanciaConDepositoLleno() {
        return distanciaConLitros(capacidadDeposito);
    }

    public double distanciaConLitros(double litros) {
        if (consumoMedio <= 0) {
            return 0.0;
        }
        return (litros / consumoMedio) * 100.0;
    }
}
