public class Frame {
    private Pixel[][] pixels;
    private int ancho;
    private int alto;

    public Frame(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pixels = new Pixel[ancho][alto];
        inicializarPixels();
    }

    private void inicializarPixels() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixels[i][j] = new Pixel(i, j, "blanco");
            }
        }
    }

    public Pixel obtenerPixel(int x, int y) {
        if (x >= 0 && x < ancho && y >= 0 && y < alto) {
            return pixels[x][y];
        }
        return null;
    }

    public void establecerPixel(int x, int y, String color) {
        if (x >= 0 && x < ancho && y >= 0 && y < alto) {
            pixels[x][y].setColor(color);
        }
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}