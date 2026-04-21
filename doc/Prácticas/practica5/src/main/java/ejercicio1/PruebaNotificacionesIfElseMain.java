package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class PruebaNotificacionesIfElseMain {

    public static void main(String[] args) { // main es el punto de entrada de la aplicación

        List<Mensaje> mensajes = new ArrayList<>();

        mensajes.add(new MensajeEmail(TipoNotificacion.EMAIL,
                "Este es el contenido del email."));

        mensajes.add(new MensajeSMS(TipoNotificacion.SMS,
                "Este es el contenido del SMS."));

        mensajes.add(new MensajeApp(TipoNotificacion.APP,
                "Este es el contenido de la notificación de la app."));
        mensajes.add(new MensajeGoogle(TipoNotificacion.GOOGLE,
                "Este es el contenido de la notificación de Google."));

        for (Mensaje mensaje : mensajes) {
            // Cada mensaje lleva un prefijo distinto
            /*
             * if (mensaje.getTipo() == TipoNotificacion.EMAIL) {
             * System.out.println("[Email] " + mensaje.getTexto());
             * } else if (mensaje.getTipo() == TipoNotificacion.SMS) {
             * System.out.println("[SMS] " + mensaje.getTexto());
             * } else if (mensaje.getTipo() == TipoNotificacion.APP) {
             * System.out.println("[App] " + mensaje.getTexto());
             * }
             */
            mensaje.enviar(); // comprueba el tipo de mensaje y lo envía por el canal correspondiente, sin
                              // necesidad de usar if-else para cada tipo de notificación. Esto hace que el
                              // código sea más limpio, fácil de mantener y extensible, ya que si se agrega un
                              // nuevo tipo de notificación, solo se necesita crear una nueva clase que
                              // extienda de Mensaje y sobrescriba el método enviar(), sin necesidad de
                              // modificar el código existente.
        }
    }
}