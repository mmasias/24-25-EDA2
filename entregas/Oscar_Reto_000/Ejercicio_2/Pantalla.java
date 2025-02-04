package entregas.Oscar_Reto_000.Ejercicio_2;

class Pantalla {
    private DobleBuffer buffer;
    private Resultados resultados;
    
    public Pantalla(int ancho, int alto, int resolucion) {
        buffer = new DobleBuffer(ancho, alto, resolucion);
        resultados = new Resultados(buffer.getFrameActual(true), buffer.getFrameActual(false));
    }
    
    public void alternarFrames() {
        System.out.println("Alternando frames...");
    }
    
    public void mostrarResultados() {
        resultados.mostrarResultados();
    }
}
