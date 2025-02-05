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
                pixel[i][j].setColor(' ');
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
            return '';
        }
    }

    public void showFrame() {
        for (int i = 0; i < pixel.length; i++) {
            for (int j = 0; j < pixel[i].length; j++) {
                System.out.print(pixel[i][j].getColor() + " ");
            }
            System.out.println();
        }
        System.out.println();
    } 

//combian dos frames para generar un frame 
    public Frame mixFrame(Frame nextFrame) {
        int filas = pixel.length;
        int columnas = pixel[0].length;
        Frame resultado = new Frame(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                char color1 = this.pixel[i][j].getColor();
                char color2 = nextFrame.pixel[i][j].getColor();
                resultado.setPixel(i, j, combinarColores(color1, color2));
            }
        }
        return resultado;
    }
}