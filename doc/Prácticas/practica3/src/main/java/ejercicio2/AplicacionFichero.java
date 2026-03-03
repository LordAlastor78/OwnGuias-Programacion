package ejercicio2;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Path;
import java.util.Scanner;

public class AplicacionFichero {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        OperadorFichero operadorFichero = null;
        
        try {
            // Tarea 4: Bucle para insistir hasta obtener un fichero válido
            boolean ficheroValido = false;
            while (!ficheroValido) {
                try {
                    System.out.println("Indica la ruta al fichero a operar: ");
                    String rutaFichero = entrada.nextLine();
                    
                    Path fichero = Path.of(rutaFichero);
                    operadorFichero = new OperadorFichero(fichero);
                    ficheroValido = true;
                    
                    System.out.println("Contenidos del fichero: " + fichero);
                    System.out.println(operadorFichero.leerFichero());
                    
                } catch (IllegalArgumentException e) {
                    // Tarea 4: Capturar excepción del constructor (fichero no existe)
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Por favor, intenta con otra ruta.");
                }
            }
            
            // Tarea 3: Controlar excepciones específicas
            String linea = null;
            do {
                System.out.println("Añadamos una línea al fichero (línea vacía si quieres terminar): ");
                linea = entrada.nextLine().trim();
                if (linea.length() > 0) {
                    operadorFichero.añadirTexto(linea + "\n");
                    System.out.println("Línea añadida");
                }
                
            } while (linea.length() > 0);
            
            System.out.println("Contenidos del fichero actualizado: ");
            System.out.println(operadorFichero.leerFichero());
            
        } catch (AccessDeniedException e) {
            // Tarea 3: Mensaje específico para acceso denegado
            System.out.println("Error: Acceso denegado al fichero. Verifica los permisos.");
            
        } catch (IOException e) {
            // Tarea 3: Mensaje genérico para otras excepciones de IO
            System.out.println("Error de entrada/salida: " + e.getMessage());
            
        } finally {
            // Tarea 5: Cerrar el Scanner siempre y mostrar mensaje final
            entrada.close();
            System.out.println("Que tengas un buen día");
        }
    }
}
