
public class Frame {
    private Pixel[][] pixeles;

    public Frame(Dimensiones dimensiones) {
        pixeles = new Pixel[dimensiones.obtenerAncho()][dimensiones.obtenerAlto()];
        for (int y = 0; y < pixeles.length; y++) {
            for (int x = 0; x < pixeles[y].length; x++) {
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
