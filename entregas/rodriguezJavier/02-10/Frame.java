public class Frame {
    private Pixel[][] pixeles;

    public Frame(Dimension dimension) {
        pixeles = new Pixel[dimension.obtenerAncho()][dimension.obtenerAlto()];
        for (int y = 0; y < dimension.obtenerAlto(); y++) {
            for (int x = 0; x < dimension.obtenerAncho(); x++) {
                pixeles[x][y] = new Pixel();
                pixeles[x][y].establecerColor(0);                
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