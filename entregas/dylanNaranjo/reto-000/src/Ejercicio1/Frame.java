package Ejercicio1;

class Frame {
    private char[][] atributos;

    public Frame(int width, int height) {
        atributos = new char[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                atributos[y][x] = '.';
            }
        }
    }

    public void setPixel(int x, int y, char value) {
        atributos[y][x] = value;
    }

    public char getPixel(int x, int y) {
        return atributos[y][x];
    }
}
