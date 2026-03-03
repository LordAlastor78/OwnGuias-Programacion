package ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
    
public class OperadorFichero {
    private Path fichero;
    
    public OperadorFichero(Path fichero) {
        //Excepciones : o bien se lanzan o bien se capturan

        if( !Files.exists(fichero) ) {
            /* try { //Esto sería de otra forma"
                Files.createFile(fichero);
            } catch (IOException e) {
                System.out.println("Error al crear el fichero: " + e.getMessage());
            }*/

            throw new IllegalArgumentException("El fichero no existe: " + fichero);
        }
        this.fichero = fichero;
    }
    
    public String leerFichero() throws IOException {
        return new String(Files.readAllBytes(this.fichero));
    }
    
    public void añadirTexto(String texto) throws IOException {
        Files.write(this.fichero, texto.getBytes(), StandardOpenOption.APPEND);
    }
}