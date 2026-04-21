package ejercicio2;

import java.util.List;
import java.util.Scanner;

public class Programa {

    private Scanner scanner = new Scanner(System.in);

    private List<IOperacion> operaciones = List.of(
            new OperacionSaludar(),
            new OperacionFecha(),
            new OperacionSalida(),
            new OperacionChiste());

    private void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        for (int i = 0; i < operaciones.size(); i++) {
            System.out.println((i + 1) + ". " + operaciones.get(i).getDescripcion());
        }
        System.out.print("Elige una opción: ");
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero();

            if (opcion > 0 && opcion <= operaciones.size()) {
                operaciones.get(opcion - 1).ejecutar();
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Por favor, introduce un número: ");
            }
        }
    }
}