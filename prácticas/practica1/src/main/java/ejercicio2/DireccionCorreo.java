package ejercicio2;

public class DireccionCorreo {

    private String nombre;
    private String apellidos;
    private String usuario;
    private String servidor;

    public DireccionCorreo(String nombre, String apellidos, String usuario, String servidor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.servidor = servidor == null || servidor.isEmpty() ? "esei.uvigo.es" : servidor;
    }

    // Genera usuario automáticamente y usa servidor por defecto
    public DireccionCorreo(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.servidor = "esei.uvigo.es";
        this.usuario = generarUsuario(nombre, apellidos);
    }

    // Genera usuario automáticamente y permite servidor personalizado
    public DireccionCorreo(String nombre, String apellidos, String servidor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.servidor = servidor == null || servidor.isEmpty() ? "esei.uvigo.es" : servidor;
        this.usuario = generarUsuario(nombre, apellidos);
    }

    private String generarUsuario(String nombre, String apellidos) {
        String primerApellido = apellidos.split(" ")[0].toLowerCase();
        return primerApellido + "." + nombre.toLowerCase();
    }

    public String getUsuario() {
        return usuario;
    }

    public String getServidor() {
        return servidor;
    }

    @Override
    public String toString() {
        return "Dirección de correo electrónico: " + usuario + "@" + servidor +
                "\nNombre: " + nombre +
                "\nApellidos: " + apellidos;
    }
}
