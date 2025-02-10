package Ejercicio1;

class Pixel {
    private char[][] atributos;

    public Pixel(int width, int height) {
        atributos = new char[height][width];
    }

    public void setPixel(int x, int y, char value) {
        atributos[y][x] = value;
    }

    public char getPixel(int x, int y) {
        return atributos[y][x];
    }
}