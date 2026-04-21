package ejercicio1;

abstract class Mensaje {

    private TipoNotificacion tipo;
    private String texto;

    public Mensaje(TipoNotificacion tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public TipoNotificacion getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }

    abstract void enviar();
    

}