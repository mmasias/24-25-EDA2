package entregas.celayaIker.Ejercicio2;

class Frame {
    private Pixel[][] frame;
    private int width;
    private int height;

    public Frame(int width, int height) {
        this.width = width;
        this.height = height;
        frame = new Pixel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                frame[i][j] = new Pixel();  // Inicializa cada píxel con valor por defecto (0)
            }
        }
    }

    public void modificarPixel(int x, int y, int nuevoValor) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            frame[x][y].setDato(nuevoValor);
        } else {
            System.out.println("Coordenadas fuera de rango.");
        }
    }

    public Pixel[][] obtenerFrame() {
        return frame;
    }

    public void imprimir() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(frame[x][y].obtenerDato() + " ");
            }
            System.out.println();
        }
    }
}
