package entregas.Oscar_Reto_000.Ejercicio_2;

class DobleBuffer {
    private Frame frame1;
    private Frame frame2;
    
    public DobleBuffer(int ancho, int alto, int resolucion) {
        frame1 = new Frame(ancho, alto, resolucion);
        frame2 = new Frame(ancho, alto, resolucion);
    }
    
    public Frame getFrameActual(boolean usarPrimero) {
        return usarPrimero ? frame1 : frame2;
    }
}
