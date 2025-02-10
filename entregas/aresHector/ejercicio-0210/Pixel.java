public class Pixel {

    private int x, y;
    private int color;

    public Pixel(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void establecerColor(int color) {
        this.color = color;
    }

    public int obtenerColor() {
        return color;
    }

    public int obtenerX() {
        return x;
    }

    public int obtenerY() {
        return y;
    }
}
