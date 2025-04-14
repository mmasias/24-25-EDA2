public class Pixel {
    private int x;
    private int y;
    private char color;

    public Pixel(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
}
