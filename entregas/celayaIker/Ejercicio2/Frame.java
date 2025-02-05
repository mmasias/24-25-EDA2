package entregas.celayaIker.Ejercicio2;

class Frame {
    private Pixel[][] frame;

    public Frame(int width, int height) {
        frame = new Pixel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                frame[i][j] = new Pixel();
            }
        }
    }

    public void modificarPixel(int x, int y, int nuevoValor) {
        frame[x][y].setDato(nuevoValor);
    }

    public Pixel[][] obtenerFrame() {
        return frame;
    }
}
