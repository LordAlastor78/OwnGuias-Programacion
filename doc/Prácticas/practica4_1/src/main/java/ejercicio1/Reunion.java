package ejercicio1;

public class Reunion {

   private Fecha fecha;
   private Hora hora;
   private String asunto;
   private String lugar;

   public Reunion(Fecha fecha, Hora hora, String asunto, String lugar) {

      this.fecha = new Fecha(0, 0, 0);
      this.hora = new Hora(0, 0, 0);
      this.asunto = asunto;
      this.lugar = lugar;
   }

}
