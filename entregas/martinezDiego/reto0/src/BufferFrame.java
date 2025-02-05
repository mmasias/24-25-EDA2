package entregas.martinezDiego.reto0.src;

class BufferFrame {
    private int[][] primerFrame;
    private int[][] segundoFrame;
    
    public BufferFrame(int ancho, int alto) {
        primerFrame = new int[alto][ancho];
        segundoFrame = new int[alto][ancho];
    }
    
    public void editarFrame(int[][] frame, int x, int y, int color) {
        frame[y][x] = color;
    }
    
    public int[][] convertirPrimerFrame() {
        return primerFrame;
    }
    
    public int[][] convertirSegundoFrame() {
        return segundoFrame;
    }
}