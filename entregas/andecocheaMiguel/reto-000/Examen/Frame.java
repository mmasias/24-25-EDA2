public class Frame {
    private Pixel pixel;
    private Pixel[][] pixels = new Pixel[10][10]; 

    public void SetPixel(int x, int y, Pixel pixel) {
        pixels[x][y] = pixel;
    }

    public Pixel GetPixel(int x, int y) {
        return pixels[x][y];
    }

    public void ClearFrame() {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                pixels[i][j] = new Pixel();
            }
        }
    }
}