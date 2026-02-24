package ejercicio5;

public enum Operacion {
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION;

    public double calcular(double n1, double n2) {
        return switch (this) {
            case SUMA -> n1 + n2;
            case RESTA -> n1 - n2;
            case MULTIPLICACION -> n1 * n2;
            case DIVISION -> n2 == 0 ? Double.NaN : n1 / n2;


            // {
            //     if (n2 == 0) {
            //         System.err.println("No se puede dividir por cero");
            //         yield Double.NaN; // Devuelve NaN para indicar que la operación no es válida
            //     }
            //     yield n1 / n2;
            // }
        };
    }
}
