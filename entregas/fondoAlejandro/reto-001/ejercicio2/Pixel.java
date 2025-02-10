package ejercicio2;

class Pixel {
    private char color;

    public Pixel(char color) {
        this.color = color;
    }

    public void establecerColor(char color) {
        this.color = color;
    }

    public char obtenerColor() {
        return color;
    }
}