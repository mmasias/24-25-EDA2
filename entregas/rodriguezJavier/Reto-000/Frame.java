class Frame {

    private Pixel[][] pixels;
    private int x, y;

    public Frame(int x, int y) {
        this.x = x;
        this.y = y;
        this.pixels = new Pixel[x][y];
    }

    public Pixel getPixel(int x, int y) {
        return pixels[x][y];
    }

    public void setPixel(int x, int y, Pixel pixel) {
        pixels[x][y] = pixel;
    }
}