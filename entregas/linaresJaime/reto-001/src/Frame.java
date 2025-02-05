class Frame {
    private Pixel[][] pixels;
    private int width, height;

    public Frame(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new Pixel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = new Pixel(0);
            }
        }
    }

    public void establecerPixel(int x, int y, int color) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            pixels[x][y].setColor(color);
        }
    }

    public Pixel getPixel(int x, int y) {
        return pixels[x][y];
    }

    public void limpiarFrame() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j].setColor(0);
            }
        }
    }
}
