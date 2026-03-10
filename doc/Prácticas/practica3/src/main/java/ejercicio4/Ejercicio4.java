package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int maxDeportistas;
        int numDeportistas = 0;
        Deportista[] club;

        int opcion = 0;
        int posicion;

        do {
            maxDeportistas = leeEntero("Introduce el número máximo de deportistas: ", teclado);
        } while (maxDeportistas <= 0);

        club = new Deportista[maxDeportistas];

        do {
            try {
                opcion = menu(teclado);
                switch (opcion) {
                    case 1 -> {
                        añadirDeportista(teclado, club, numDeportistas);
                        numDeportistas++;
                    }
                    case 2 -> {
                        System.out.println(mostrarDeportistas(club, numDeportistas));
                    }
                    case 3 -> {
                        posicion = leeEntero("Introduce la posición del deportista (1-" + numDeportistas + "): ",
                                teclado);
                        System.out.println(obtenerDeportistaPorPosicion(club, numDeportistas, posicion));
                    }
                    case 4 -> {
                        System.out.println(obtenerEstadisticas(club, numDeportistas));
                    }
                }
            } catch (IllegalArgumentException exc) {
                System.err.println(exc.getMessage());
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.err.println(exc.getMessage());
            } 

        } while (opcion != 0);

    }

    private static int menu(Scanner teclado) {
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Añadir deportista");
            System.out.println("2. Mostrar deportistas");
            System.out.println("3. Obtener un deportista por posicion");
            System.out.println("4. Estadisticas");
            System.out.println("0. Salir");

            opcion = leeEntero("Selecciona una opción: ", teclado);
        } while (opcion < 0 || opcion > 4);

        return opcion;
    }

    private static Deportista leeDeportista(Scanner teclado) {
        String dni;
        String nombre;
        int edad;

        dni = leeCadena("Introduce el DNI del deportista: ", teclado);

        nombre = leeCadena("Introduce el nombre del deportista: ", teclado);

        do {
            edad = leeEntero("Introduce la edad del deportista: ", teclado);
        } while (edad < 0);

        return new Deportista(dni, nombre, edad);
    }

    private static void añadirDeportista(Scanner teclado, Deportista[] club, int numDeportistas) {
	// Comprobar si el vector esta lleno.
	// En el caso de que este lleno lanzar una excepción
	// En el caso de que no este lleno leer el deportista del teclado y añadirlo al vector
        

    }

    private static StringBuilder mostrarDeportistas(Deportista[] club, int numDeportistas) {
        StringBuilder toReturn = new StringBuilder();

	// Comprobar si el vector tiene deportistas
	// Si tiene recorrer los deportistas del vector y concatener sus datos en el StringBuilder
   
        return toReturn;
    }

    private static Deportista obtenerDeportistaPorPosicion(Deportista[] club, int numDeportistas, int posicion) {
	// Comprobar si la posición es correcta
	// Si la posición no corresponde a ningún deportista existente, lanzar una excepción
	// Si la posición si corresponde a un deportista devolver dicho objeto deportista
       
    }

    private static String obtenerEstadisticas(Deportista[] club, int numDeportistas) {
        StringBuilder toReturn = new StringBuilder();

	// Devolver el número total de deportistas
	// Devolver el número de plazas libres en el club
	// Devolver el número de deportistas por categoría

       
        return toReturn.toString();
    }

    private static int leeEntero(String mensaje, Scanner teclado) {
        int numero = 0;
        boolean esValido = false;

        do {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(System.console().readLine());
                esValido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error: Entrada no válida. Por favor, introduce un número entero.");
            }
        } while (esValido == false);

        return numero;
    }

    private static String leeCadena(String mensaje, Scanner teclado) {
        String cadena;

        do {
            System.out.print(mensaje);
            cadena = teclado.nextLine().trim();
        } while (cadena == null || cadena.isBlank());

        return cadena;
    }
}
