package Ejercicio02_17;

abstract class InstrumentoMusical {
    protected String nombre;
    
    public InstrumentoMusical(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract void tocar();

    public void afinar() {
        System.out.println(nombre + " no necesita afinación específica.");
    }
}
