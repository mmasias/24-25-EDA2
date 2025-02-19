package Ejercicio02_17;

class Piano extends InstrumentoMusical {
    public Piano(String nombre) {
        super(nombre);
    }
    
    @Override
    public void tocar() {
        System.out.println("El piano " + nombre + " está tocando una melodía.");
    }
}
