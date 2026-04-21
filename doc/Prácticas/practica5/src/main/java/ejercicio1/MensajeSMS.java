package ejercicio1;

public class MensajeSMS extends Mensaje {

    public MensajeSMS(TipoNotificacion tipo, String texto) {
        super(tipo, texto);
        //TODO Auto-generated constructor stub
    }

    @Override
    void enviar() {
        System.out.println("[Enviando mensaje por SMS: ]" + getTexto());
    }

}
