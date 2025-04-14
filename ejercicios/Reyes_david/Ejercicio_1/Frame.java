package ejercicios.Reyes_david.Ejercicio_1;


public class Frame {
    private Pixel[][] pixeles;

    public Frame(Dimension dimension) {
        pixeles = new Pixel[dimension.obtenerAncho()][dimension.obtenerAlto()];
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