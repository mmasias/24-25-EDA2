public class Frame {
    
    private Pixel[][] pixeles;

    public Frame(Resolucion resolucion) {
        pixeles = new Pixel[resolucion.obtenerAncho()][resolucion.obtenerAlto()];
        for (int y = 0; y < resolucion.obtenerAncho(); y++) {
            for (int x = 0; x < resolucion.obtenerAlto(); x++) {
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