package ejercicio1;

public class MensajeApp extends Mensaje {

    public MensajeApp(TipoNotificacion tipo, String texto) {
        super(tipo, texto); // super es el constructor de la clase padre, en este caso, Mensaje
        
    }

    @Override
    void enviar() {
        System.out.println("[Enviando mensaje por app: ]" + getTexto());
    }

}
