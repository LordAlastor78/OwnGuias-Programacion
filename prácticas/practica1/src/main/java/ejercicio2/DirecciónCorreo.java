package ejercicio2;

public class DirecciónCorreo {

    String nombre;

    String apellidos;

    String usuario;

    String servidor = "esei.uvigo.es";

    public DirecciónCorreo(String nombre, String apellidos, String usuario, String servidor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.servidor = servidor;

    }

    @Override

    public String toString() {
        return "Dirección de correo electrónico: " + usuario + "@" + servidor +
                "\nNombre: " + nombre +
                "\nApellidos: " + apellidos;
    }

    DirecciónCorreo(String nombre, String apellidos, String usuario) {

        final String SERVIDOR = "esei.uvigo.es";
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = apellidos.split(" ")[0].toLowerCase() + "." + nombre.toLowerCase();

        this.servidor = SERVIDOR;
    }

}


