package Ejercicio02_17;

class Guitarra extends InstrumentoMusical {
    public Guitarra(String nombre) {
        super(nombre);
    }
    
    @Override
    public void tocar() {
        System.out.println("La guitarra " + nombre + " está sonando con acordes.");
    }
    
}