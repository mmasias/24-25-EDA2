
public class Frame {
    private Pixel[][] pixeles;
        private Resolucion resolucion;
    
        public Frame(Resolucion resolucion) {
            this.resolucion = resolucion;
        pixeles = new Pixel[resolucion.obtenerAncho()][resolucion.obtenerAlto()];
        for (int y = 0; y < pixeles.length; y++) {
            for (int x = 0; x < pixeles[y].length; x++) {
                pixeles[y][x] = new Pixel();
                pixeles[y][x].establecerColor(0);
            }
        }
    }

    public Resolucion obtenerResolucion() {
        return resolucion;
    }

    public Pixel obtenerPixel(Coordenada coordenada) {
        return pixeles[coordenada.obtenerX()][coordenada.obtenerY()];
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pixeles[coordenada.obtenerX()][coordenada.obtenerY()].establecerColor(color);
    }
}
