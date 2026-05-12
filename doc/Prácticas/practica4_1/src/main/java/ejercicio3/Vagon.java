package ejercicio3;

public class Vagon {
    private final String nombre;
    private Vagon siguiente; // mutable
    private Vagon anterior; // mutable, pero NO accesible desde fuera

    public Vagon(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre obligatorio");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Vagon getSiguiente() {
        return siguiente;
    }

    public Vagon getAnterior() {
        return anterior;
    } // sí se puede leer

    public void agregarVagon(Vagon vagon) {
        if (vagon == null) {
            throw new IllegalArgumentException("Vagón obligatorio");
        }
        if (this.siguiente != null) {
            throw new IllegalStateException("Ya hay un vagón siguiente");
        }
        this.siguiente = vagon;
        vagon.anterior = this;
    }

    public Vagon crearVagon(String nombre) {
        return new Vagon(nombre);
        
    }

    public Vagon cuantosMeSiguen(Vagon vagon){

        
        if (vagon.getSiguiente() == null) {
            return vagon;
        } else {

            for (Vagon v = vagon.getSiguiente(); v != null; v = v.getSiguiente()) {
                if (v.getSiguiente() == null) {
                    return v;
                }
            }
           
                return vagon.cuantosMeSiguen(vagon.getSiguiente());
        }


    }




}