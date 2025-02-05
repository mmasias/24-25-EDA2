package Examen;
class Frame {
    public int width, height;
    private Pixel[][] pixelData;

    public Frame(int width, int height) {
        this.width = width;
        this.height = height;
        pixelData = new Pixel[width][height];

        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixelData[i][j] = new Pixel(i, j, '.');
            }
        }
    }

    public void setPixel(int x, int y, char color) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            pixelData[x][y].setColor(color);
        }
    }

    

    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(getPixel(x, y) + " ");
            }
            System.out.println();
        }
    }
}