package ejercicio1;

public class MensajeEmail extends Mensaje {


    public MensajeEmail(TipoNotificacion tipo, String texto) {
        super(tipo, texto);
        //TODO Auto-generated constructor stub
    }

    @Override
    void enviar() {
        System.out.println("[Enviando mensaje por email: ]" + getTexto());
    }



}
