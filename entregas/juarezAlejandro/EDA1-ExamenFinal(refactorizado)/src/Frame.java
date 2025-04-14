public class Frame {
    private Pixel[][] pixeles;
    private Resolucion resolucion;

    public Frame(Resolucion resolucion) {
        this.resolucion = resolucion;
        pixeles = new Pixel[resolucion.obtenerAncho()][resolucion.obtenerAlto()];
        for (int x = 0; x < resolucion.obtenerAncho(); x++) {
            for (int y = 0; y < resolucion.obtenerAlto(); y++) {
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
