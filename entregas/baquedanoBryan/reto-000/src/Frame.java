public class Frame {
    
    private Pixel[][] pixeles;
    
    public Frame(int filas, int columnas) {
        this.pixeles = new Pixel[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.pixeles[i][j] = new Pixel('#', '.', '+');
            }
        }
    }
    
}
