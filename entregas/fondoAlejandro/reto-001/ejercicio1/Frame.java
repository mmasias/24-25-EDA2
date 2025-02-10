package ejercicio1;

class Frame {
    private Pixel[][] pixeles;

    public Frame(int ancho, int alto) {
        pixeles = new Pixel[alto][ancho];
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                pixeles[y][x] = new Pixel();
            }
        }
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pixeles[coordenada.obtenerY()][coordenada.obtenerX()].establecerColor(color);
    }

    public Pixel obtenerPixel(Coordenada coordenada) {
        return pixeles[coordenada.obtenerY()][coordenada.obtenerX()];
    }

    public Pixel[][] obtenerPixeles() {
        return pixeles;
    }
}