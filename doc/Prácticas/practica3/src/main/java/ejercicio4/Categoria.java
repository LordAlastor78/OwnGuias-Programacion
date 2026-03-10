package ejercicio4;

public enum Categoria {
    BENJAMIN,
    ALEVIN,
    INFANTIL,
    CADETE,
    JUVENIL,
    SENIOR;

    public static Categoria fromCategoria(int edad) {
        Categoria cat = SENIOR; // Por defecto, si no se cumple ninguna condición

        if (edad <= 8) {
            cat = BENJAMIN;
        } else if (edad <= 10) {
            cat = ALEVIN;
        } else if (edad <= 12) {
            cat = INFANTIL;
        } else if (edad <= 14) {
            cat = CADETE;
        } else if (edad <= 18) {
            cat = JUVENIL;
        }

        return cat;
    }
}
