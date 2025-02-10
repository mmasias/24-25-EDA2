
public class Frame {
    private Pixel[][] pixeles;
    private Dimension dimension;

    public Frame(int ancho, int alto) {
        this.dimension = new Dimension(ancho, alto);
        this.pixeles = new Pixel[alto][ancho];


        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                pixeles[y][x] = new Pixel(0);
            }
        }
    }

    public Pixel getPixel(Coordenada coordenada) {
        return pixeles[coordenada.getY()][coordenada.getX()];
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pixeles[coordenada.getY()][coordenada.getX()].setColor(color);
    }

    public void renderizar() {
        for (int y = 0; y < dimension.getAlto(); y++) {
            for (int x = 0; x < dimension.getAncho(); x++) {
                System.out.print(getPixel(new Coordenada(x, y)).getColor() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
