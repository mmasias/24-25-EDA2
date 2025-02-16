
class Frame {
    private Pixel[][] pixels;
    public static final int ANCHO = 320;
    public static final int ALTO = 200;
    
    public Frame() {
        pixels = new Pixel[ANCHO][ALTO];
        for (int i = 0; i < ANCHO; i++) {
            for (int j = 0; j < ALTO; j++) {
                pixels[i][j] = new Pixel('.');
            }
        }
    }
    
    public void setPixel(int x, int y, char valor) {
        if (x >= 0 && x < ANCHO && y >= 0 && y < ALTO) {
            pixels[x][y] = new Pixel(valor);
        }
    }
    
    public Pixel getPixel(int x, int y) {
        return pixels[x][y];
    }
}
