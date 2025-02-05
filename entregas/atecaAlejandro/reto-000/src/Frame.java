public class Frame {
    private int x;
    private int y;
    private Pixel[][] pixels;

    public Frame(int x, int y) {
        this.x = x;
        this.y = y;
        this.pixels = new Pixel[x][y];
        clearFrame(false, "negro");
    }

    public void setPixel(int x, int y, boolean estado, String color) {
        if (x >= 0 && x < this.x && y >= 0 && y < this.y) {
            pixels[x][y] = new Pixel(estado, color);
        }
    }

    public Pixel getPixel(int x, int y) {
        if (x >= 0 && x < this.x && y >= 0 && y < this.y) {
            return pixels[x][y];
        }
        return null;
    }

    public void clearFrame(boolean estado, String color) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                pixels[i][j] = new Pixel(estado, color);
            }
        }
    }
}