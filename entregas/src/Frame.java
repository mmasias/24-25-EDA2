public class Frame {
    private Pixel[][] pixel;

    public Frame(int width, int height) {
        pixel = new Pixel[height][width];
        for (int i = 0; i < pixel.length; i++) {
            for (int j = 0; j < pixel[i].length; j++) {
                pixel[i][j] = new Pixel();
            }
        }
    }

    public void reset() {
        for (int i = 0; i < pixel.length; i++) {
            for (int j = 0; j < pixel[i].length; j++) {
                this.setPixel(j, i, ' ');
            }
        }
    }

    public void setPixel(int x, int y, char color) {
        pixel[y][x].setColor(color);
    }

    public Pixel getPixel(int x, int y) {
        return new Pixel(pixel[y][x].getColor());
    }
}
