package entregas.castilloCayetano.reto001.src;

class Frame {
    private int width, height;
    private Pixel[][] pixels;

    public Frame(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new Pixel[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = new Pixel('.');
            }
        }
    }

    public void setPixel(int x, int y, char color) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            pixels[y][x].setColor(color);
        }
    }

    public char getPixel(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return pixels[y][x].getColor();
        }
        return '.';
    }

    public void printFrame(String title) {
        System.out.println(title);
        for (Pixel[] row : pixels) {
            for (Pixel pixel : row) {
                System.out.print(pixel.getColor() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}