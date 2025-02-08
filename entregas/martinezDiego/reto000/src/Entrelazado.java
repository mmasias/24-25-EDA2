package entregas.martinezDiego.reto0.src;

class Entrelazado {
    private Lista lista;
    private BufferFrame buffer;
    
    public Entrelazado(int ancho, int alto) {
        lista = new Lista();
        lista.anadirNodo(ancho, alto);
        lista.anadirNodo(ancho, alto);
        buffer = new BufferFrame(ancho, alto);
    }
    
    public void editarFrame(int x, int y, int color) {
        Nodo actual = lista.obtenerNodo();
        buffer.editarFrame(actual.frame, x, y, color);
    }
    
    public void imprimirPrimerFrame() {
        System.out.println("Primer Frame:");
        imprimirFrame(buffer.convertirPrimerFrame());
    }
    
    public void imprimirSegundoFrame() {
        System.out.println("Segundo Frame:");
        imprimirFrame(buffer.convertirSegundoFrame());
    }
    
    private void imprimirFrame(int[][] frame) {
        for (int[] fila : frame) {
            for (int pixel : fila) {
                System.out.print(pixel == 0 ? "." : "#");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Entrelazado entrelazado = new Entrelazado(10, 5);
        entrelazado.editarFrame(2, 2, 1);
        entrelazado.editarFrame(7, 3, 1);
        entrelazado.imprimirPrimerFrame();
        entrelazado.imprimirSegundoFrame();
    }
}
