package entregas.PinedaOscar.Reto_000.Ejercicio_1;
class Pantalla {
    private DobleBuffer buffer;
    
    public Pantalla(int ancho, int alto, int resolucion) {
        buffer = new DobleBuffer(ancho, alto, resolucion);
    }
    
    public void alternarFrames() {
        
        System.out.println("Alternando frames...");
    }
}