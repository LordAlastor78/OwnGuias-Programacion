
package ejercicio3;

public class Tren {

    /*
     * Ejercicio 3
     * 
     * siguiente / anterior
     * 0..1
     * 0..1
     * 0..1
     * 0..1
     * 0..1
     * 0..1
     * 0..1
     * 0..1
     * 
     * Tren
     * 
     * Vagon
     * 
     * Queremos representar un tren. El tren tiene vagones. Representa esto mediante
     * una clase Tren, que almacena los CV de potencia de su locomotora (un entero)
     * y que está compuesto por cero o un vagones (clase Vagon, que tiene un nombre,
     * p.ej: "A Coruña"),
     * Tarea 1
     * 
     * Implementa las clases Tren y Vagon mediante asociación, unidireccional entre
     * Tren y su primer Vagon, siendo la multiplicidad como sigue:
     * 
     * Tren -> Vagon: 0 .. 1
     * Vagon -> Tren: 0 .. 1
     * 
     * La clase Tren debe ser mutable para establecer el primer Vagon.
     * Tarea 2
     * 
     * Implementa la relación reflexiva (o recursiva) entre Vagon consigo mismo,
     * mediante composición débil, bidireccional (un Vagon también tiene su
     * anterior), siendo la multiplicidad como sigue:
     * 
     * Vagon -> Vagon: 0 .. 1 (siguiente vagón)
     * Vagon -> Vagon: 0 .. 1 (anterior vagón)
     * 
     * La clase Vagon es también mutable, ya que vagones pueden conectarse y
     * desconectarse con su siguiente una vez creados.
     * 
     * Para implementar la relación bidireccional y para garantizar la consistencia
     * entre el siguiente y anterior, no permitas cambiar el anterior de un Vagon
     * desde su interfaz pública, aunque sí debes permitir obtener el anterior de un
     * Vagon.
     * 
     * Al cambiar el siguiente de un Vagon (actual) por otro (nuevo_siguiente) (o
     * por null), si actual tenía previamente un siguiente (viejo_siguiente), éste
     * debe quedar con su anterior a null automáticamente, para mantener la
     * consistencia de la relación bidireccional.
     * Además, si el nuevo_siguiente ya tenía un anterior
     * (viejo_anterior_del_nuevo_siguiente), también habrá que desconectarlo
     * completamente de aquél, haciendo que el siguiente de
     * viejo_anterior_del_nuevo_siguiente sea null.
     * 
     * Tarea 3
     * 
     * Implementa en Vagon un método cuantosMeSiguen() que devuelva el número de
     * vagones que le siguen (sin contarse a sí mismo), e implementa en Tren un
     * método getNumVagones() que devuelva el número total de vagones del tren,
     * usando cuantosMeSiguen().
     * Tarea 4
     * 
     * Implementa un test de unidad para Tren que cree un tren con 4 vagones:
     * "A Coruña", "Lugo", "Ourense", "Pontevedra" y comprueba a través de un
     * recorrido que sus vagones son los esperados.
     * Implementa un test de unidad para getNumVagones() que verifique que el número
     * de vagones de ese tren es 4.
     * 
     */

    private String nombreTren;
    private Vagon vagon;
    private final float cvPotencia;

    public Tren(float cvPotencia, Vagon vagon, String nombreTren) {
        this.cvPotencia = cvPotencia;
        this.vagon = vagon;
        this.nombreTren = nombreTren;
    }

    public String getNombreTren() {
        return nombreTren;
    }

    public void setNombreTren(String nombreTren) {
        this.nombreTren = nombreTren;
    }

    public Vagon getVagon() {
        return vagon;
    }

    public void setVagon(Vagon vagon) {
        this.vagon = vagon;
    }

    public float getCvPotencia() {
        return cvPotencia;
    }

    // ahora métodos de logica compleja

    public static Tren crearTren(float cvPotencia, String nombreTren) {

        return new Tren(cvPotencia, null, nombreTren);
    }

    public Vagon getNumVagones() {
        if (vagon == null) {
            
            return null;
        } else {
            return vagon.cuantosMeSiguen(vagon);
        }
    }

}
