public class Frame {
    private Pixel[][]pixeles;

    public Frame(int ancho, int alto){
        pixeles = new Pixel[ancho][alto];
    }

    public Pixel obtenerPixel(Coordenada coordenada){
        return pixeles[coordenada.obtenerX()][coordenada.obtenerY()];
    }

    public void establecerPixel(Coordenada coordenada, int color){
        Pixel pixel = new Pixel();

        pixel.establecerColor(color);
        pixeles[coordenada.obtenerY()][coordenada.obtenerX()] = pixel;
    }

    public Pixel[][] getPixeles(){
        return pixeles;
    }
}
