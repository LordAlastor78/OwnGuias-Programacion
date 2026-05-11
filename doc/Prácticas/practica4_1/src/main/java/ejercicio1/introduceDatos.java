package ejercicio1;

import java.util.Scanner;

// Por convención, los nombres de clase empiezan en mayúscula
public class IntroduceDatos {

    // Todo el código ejecutable debe estar DENTRO de un método
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                        --Creacion de reuniones---
                Introduzca el lugar donde se celebrará la reunion,
                la hora y finalmente el asunto
                """);

        System.out.println("Introduzca la fecha en este formato : dd/mm/aaaa");
        String fechaScan = sc.nextLine();

        // dividimos con un array
        String[] partesFecha = fechaScan.split("/");

        if (partesFecha.length != 3) {
            System.err.println(" Problema en el guardado de la fecha, revise el formato.");
            return; // Salimos del método main
        }

        try {
            int diaScan = Integer.parseInt(partesFecha[0]);
            int mesScan = Integer.parseInt(partesFecha[1]);
            int anioScan = Integer.parseInt(partesFecha[2]);

            // Imprimimos para verificar
            System.out.println("Día: " + diaScan + ", Mes: " + mesScan + ", Año: " + anioScan);

        } catch (NumberFormatException e) {
            System.err.println(" Los componentes de fecha deben ser numéricos");
            return; // Salimos del método main
        }

        // Aquí continuaría el resto de tu lógica...
        // No hay 'return 0;' al final de main en Java (a diferencia de C)
    }
}