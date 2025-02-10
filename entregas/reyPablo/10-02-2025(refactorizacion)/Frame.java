public class Frame {
    private Pixel[][] pixeles;

    public Frame(int dimension) {
        pixeles = new Pixel[dimension][dimension];
        for (int y = 0; y < dimension; y++) {
            for (int x = 0; x < dimension; x++) {
                pixeles[y][x] = new Pixel();
                pixeles[y][x].establecerColor(0);                
            }
        }        
    }

    public Pixel obtenerPixel(Coordenada coordenada) {
        return pixeles[coordenada.obtenerX()][coordenada.obtenerY()];
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pixeles[coordenada.obtenerX()][coordenada.obtenerY()].establecerColor(color);
    }
}
