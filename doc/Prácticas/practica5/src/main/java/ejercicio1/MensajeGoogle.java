package ejercicio1;

public class MensajeGoogle extends Mensaje {

    public MensajeGoogle(TipoNotificacion tipo, String texto) {
        super(tipo, texto);
        // TODO Auto-generated constructor stub
    }

    @Override
    void enviar() {
        System.out.println("[Enviando mensaje por Google: ]" + getTexto());
    }

}
