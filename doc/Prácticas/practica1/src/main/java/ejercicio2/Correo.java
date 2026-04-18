package ejercicio2;

public class Correo {

    private String nombre;
    private String apellidos;
    private String usuario;
    private String servidor;

    public Correo(String nombre, String apellidos, String usuario, String servidor) { //constructor completo
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.servidor = servidor;
    }

    public Correo(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.servidor = "esei.uvigo.es";

        String primerApellido = "";
        if (apellidos != null) {
            String[] partes = apellidos.trim().split("\\s+");
            if (partes.length > 0) {
                primerApellido = partes[0];
            }
        }

        char inicial = ' ';
        if (nombre != null && !nombre.trim().isEmpty()) {
            inicial = nombre.trim().charAt(0);
        }

        this.usuario = (primerApellido + inicial).toLowerCase();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getServidor() {
        return servidor;
    }

    @Override
    public String toString() {
        return apellidos + ", " + nombre + ": " + usuario + "@" + servidor;
    }
}
