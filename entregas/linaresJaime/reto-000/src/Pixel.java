class Pixel {
    private int x, y, color;

    public Pixel(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}