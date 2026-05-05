
package ejercicio1;

import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat;

public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Reunion newReunion = new Reunion(null, null, null, leerFecha(sc));

        newReunion.crearFecha(null);

    }

    private static Fecha leerFecha(Scanner sc) {

        System.out.println("""
                Introduce la fecha de la reunion:
                dia/mes/año :
                """);

        System.out.println(" dia:");

        int dia = sc.nextInt();

        System.out.println("mes : ");

        int mes = sc.nextInt();

        System.out.println("año: ");

        int ano = sc.nextInt();

        return new Fecha(dia, mes, ano);

    }

    public static Hora leerHora(Scanner sc) {

        System.out.println("""
                Introduce la fecha de la reunion:
                hora/minuto/segundos :
                """);

        System.out.println(" dia:");

        int horas = sc.nextInt();

        System.out.println("mes : ");

        int minutos = sc.nextInt();

        System.out.println("año: ");

        int segundos = sc.nextInt();

        return new Hora(horas, minutos, segundos);

    }

    public static Asunto leerAsunto(Scanner sc) {

        System.out.println("Introduce el asunto de la reunión: ");

        String asunto = sc.nextLine();

        return new Asunto(asunto);
    }

}
