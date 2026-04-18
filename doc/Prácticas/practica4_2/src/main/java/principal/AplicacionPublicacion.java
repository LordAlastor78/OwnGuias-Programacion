package principal;

import ejercicio1.Autor;
import ejercicio2.Articulo;
import ejercicio2.ComunicacionEnCongreso;
import ejercicio2.Libro;
import ejercicio2.Publicacion;

import java.util.ArrayList;
import java.util.List;

public class AplicacionPublicacion {

    public static void main(String[] args) {

        Autor autor1 = new Autor("0000-0001-2345-6789", "Pérez", "Ana", "Universidad de Vigo");
        Autor autor2 = new Autor("0000-0002-9876-5432", "García", "Luis", "Universidad Complutense");
        Autor autor3 = new Autor("0000-0003-1111-2222", "Martínez", "Sara", "Universidad de Sevilla");

        Articulo articulo = new Articulo("Un artículo sobre Java", 2024, "Revista de Programación", 10, 5, 15, autor1,
                12);
        Libro libro = new Libro("Un libro sobre Java", 2023, "Editorial de Programación", "Madrid", autor2, 5);
        ComunicacionEnCongreso comunicacion = new ComunicacionEnCongreso("Una comunicación sobre Java", 2022,
                "Congreso de Programación", "Barcelona", "Dr. Programador", autor3, 3);

        List<Publicacion> publicaciones = new ArrayList<>();
        publicaciones.add(articulo);
        publicaciones.add(libro);
        publicaciones.add(comunicacion);

        // Recorremos la lista de Publicacion usando polimorfismo.
        // Cada elemento elige su propio toString() según su clase.
        for (Publicacion publicacion : publicaciones) {
            System.out.println(publicacion);
            System.out.println("-----------------------------");
        }

        /*
         * Vamos a ver castings ( conversión de tipos) para acceder a métodos
         * específicos de cada clase.
         * 
         * if ( p instanciaOf Articulo ) {
         * Articulo a2 = (Articulo) p; // Casting explícito
         * a2 = (Articulo) p; // Casting explícito
         * System.out.println("Revista: " + a2.getNombreRevista());
         * }
         * 
         * 
         * else
         * System.out.println("P ahora es un libro o una comunicación, no un artículo."
         * );
         * 
         */

    }

}