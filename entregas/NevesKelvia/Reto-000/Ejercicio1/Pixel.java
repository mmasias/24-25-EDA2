package entregas.NevesKelvia.Ejercicio1;

class Pixel extends Representacion {
    Pixel() {
        super();
    }

    char getPixel(int row, int col) {
        if (row >= 0 && row < frames.length && col >= 0 && col < frames[0].length) {
            return frames[row][col];
        }
        return ' ';
    }
}
