package ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) {
        Articulo cosa1 = new Articulo("Ratón", 20, TipoIVA.GENERAL);
        Articulo cosa2 = new Articulo("Libro", 15, TipoIVA.REDUCIDO);
        Articulo cosa3 = new Articulo("Medicamento", 10, TipoIVA.SUPERREDUCIDO);

        System.out.println(cosa1);  // Ratón: 24.20 €
        System.out.println(cosa2);  // Libro: 16.50 €
        System.out.println(cosa3);  // Medicamento: 10.40 €
    }
}