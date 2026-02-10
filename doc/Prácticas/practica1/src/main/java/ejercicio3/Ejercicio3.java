package ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) {
        // Creamos un objeto Libro usando el constructor
        Libro libro = new Libro("Thinking in Java", "Bruce Eckel", "Prentice Hall", "2007", "0131872486");
        
        // Imprimimos el libro → Java llama automáticamente a toString()
        System.out.println(libro);
    }
}