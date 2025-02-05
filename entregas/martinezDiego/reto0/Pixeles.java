package entregas.martinezDiego.reto0;


class Pixeles {
    private BufferFrame buffer;
    
    public Pixeles(int ancho, int alto) {
        buffer = new BufferFrame(ancho, alto);
    }
    
    public void gestionarNodo(int[][] frame, int x, int y, int color) {
        buffer.editarFrame(frame, x, y, color);
    }
}
