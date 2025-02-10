package ejercicio2;

class Frame {
    private Pixel[][] pixeles;

    public Frame(int ancho, int alto) {
        pixeles = new Pixel[alto][ancho];
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                pixeles[y][x] = new Pixel('.');
            }
        }
    }

    public void establecerPixel(Coordenada coordenada, char color) {
        pixeles[coordenada.obtenerY()][coordenada.obtenerX()].establecerColor(color);
    }

    public Pixel obtenerPixel(Coordenada coordenada) {
        return pixeles[coordenada.obtenerY()][coordenada.obtenerX()];
    }

    public char[][] obtenerPixeles() {
        char[][] salida = new char[pixeles.length][pixeles[0].length];
        for (int y = 0; y < pixeles.length; y++) {
            for (int x = 0; x < pixeles[0].length; x++) {
                salida[y][x] = pixeles[y][x].obtenerColor();
            }
        }
        return salida;
    }
}