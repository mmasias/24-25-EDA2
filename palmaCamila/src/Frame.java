public class Frame {
    private Pixel[][] pixel;

    public Frame(int filas, int columnas) {
        pixel = new Pixel[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                pixel[i][j] = new Pixel();
            }
        }
    }

    public Pixel[][] getPixel() {
        return pixel;
    }

    public void reset() {
        for (int i = 0; i < pixel.length; i++) {
            for (int j = 0; j < pixel[i].length; j++) {
                pixel[i][j] = new Pixel();
            }
        }
    }

    public void setPixel(int fila, int columna, Pixel nuevoPixel) {
        if (fila >= 0 && fila < pixel.length && columna >= 0 && columna < pixel[0].length) {
            pixel[fila][columna] = nuevoPixel;
        } else {
            System.out.println("Posición fuera de rango.");
        }
    }

    public Pixel findPixel(int fila, int columna) {
        if (fila >= 0 && fila < pixel.length && columna >= 0 && columna < pixel[0].length) {
            return pixel[fila][columna];
        } else {
            System.out.println("Posición fuera de rango.");
            return null;
        }
    }
}
