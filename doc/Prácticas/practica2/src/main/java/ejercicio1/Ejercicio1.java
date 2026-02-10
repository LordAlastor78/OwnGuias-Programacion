package ejercicio1;

public class Ejercicio1 {

    public static void main(String[] args) {
        
    Libro libro1 =  new Libro("1984", "Orwell", "niIdea", 1984);

/*     libro1.setAnho(-57); */

    Libro [] biblioteca = new Libro[10];

    int numLibros = 0;

    biblioteca[0] = new Libro("El Quijote", "Cervantes", "niIdea", 1605);
    numLibros++;
    biblioteca[numLibros] = new Libro("El Señor de los Anillos", "Tolkien", "niIdea", 1954);
    numLibros++;

    if (numLibros == 0) {
        System.out.println("No hay libros en la biblioteca");
    } else {
        for (int i = 0; i < numLibros; i++) {
            System.out.println(biblioteca[i]);
        }
    }

    System.out.println(libro1);

    /*Mejora la encapsulación de la clase
    Libro ocultando la representación interna,
    aunque proveas de acceso a la 
    información de forma adecuada y mantén 
    la clase inmutable.------> use : final (declarar como constante) */





    }

}
