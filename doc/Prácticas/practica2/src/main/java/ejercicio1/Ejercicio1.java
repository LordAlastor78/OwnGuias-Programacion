package ejercicio1;

public class Ejercicio1 {

    // Añade el siguiente método estático en la clase principal para leer los datos
    // de un libro por teclado y utiliza este método para añadir algún libro más al
    // vector.

    public static TipoLibro leerTipoLibro(java.util.Scanner sc) {
        TipoLibro[] tipos = TipoLibro.values();
        TipoLibro tipoSeleccionado = null;

        while (tipoSeleccionado == null) {
            System.out.println("Selecciona el tipo de libro:");

            for (int i = 0; i < tipos.length; i++) {
               System.out.println((i + 1) + ".- " + tipos[i]);
            }

            int opcion = Integer.parseInt(sc.nextLine());
            if (opcion > 0 && opcion <= tipos.length) {
                tipoSeleccionado = tipos[opcion - 1];
            } else {
                System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
        return tipoSeleccionado;
    }


    public static Libro creaLibro() {


        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            System.out.println("Introduce el título del libro:");

            String titulo = sc.nextLine();

            System.out.println("Introduce los autores del libro:");

            String autores = sc.nextLine();

            System.out.println("Introduce la editorial del libro:");

            String editorial = sc.nextLine();

            System.out.println("Introduce el año de publicación del libro:");

            int anho = sc.nextInt();

            sc.nextLine(); // Consume the newline character
            return new Libro(titulo, autores, editorial, anho, leerTipoLibro(sc)); 
        }
    }

    public static void main(String[] args) {

        Libro libro1 = new Libro("1984", "Orwell", "niIdea", 1984, TipoLibro.NOVELA);

        /* libro1.setAnho(-57); */

        Libro[] biblioteca = new Libro[10];

        int numLibros = 0;

        biblioteca[0] = new Libro("El Quijote", "Cervantes", "niIdea", 1605);
        numLibros++;
        biblioteca[numLibros] = new Libro("El Señor de los Anillos", "Tolkien", "niIdea", 1954);
        numLibros++;

        biblioteca[numLibros++] = creaLibro();

        if (numLibros == 0) {
            System.out.println("No hay libros en la biblioteca");
        } else {
            for (int i = 0; i < numLibros; i++) {
                System.out.println(biblioteca[i]);
                System.out.println((biblioteca[i].getTitulo()));
            }
        }

        System.out.println(libro1);

        /*
         * Mejora la encapsulación de la clase
         * Libro ocultando la representación interna,
         * aunque proveas de acceso a la
         * información de forma adecuada y mantén
         * la clase inmutable.------> use : final (declarar como constante)
         */

    }
}
