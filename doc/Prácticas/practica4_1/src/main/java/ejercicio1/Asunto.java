package ejercicio1;

public class Asunto {

    private final String asuntoString;

    public Asunto(String asuntoString) {

        if (asuntoString == null || asuntoString.isBlank()) {

            throw new NullPointerException("No puede estar vacío / ser null");
        }
        this.asuntoString = asuntoString;
    }

}
