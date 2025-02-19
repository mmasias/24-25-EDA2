package Ejercicio02_17;

class Violin extends InstrumentoMusical {
    public Violin(String nombre) {
        super(nombre);
    }
    
    @Override
    public void tocar() {
        System.out.println("El violín " + nombre + " produce un sonido armonioso.");
    }
}
