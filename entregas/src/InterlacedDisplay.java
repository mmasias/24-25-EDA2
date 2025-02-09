public class InterlacedDisplay {
    private int width;
    private int height;
    private DoubleBuffer buffer;

    public InterlacedDisplay(int width, int height) {
        this.width = width;
        this.height = height;
        buffer = new DoubleBuffer(width / 2, height);
    }

    public void reset() {
        buffer.getBackFrame().reset();
        buffer.getCurrentFrame().reset();
    }

    public void setPixel(int x, int y, char color) {
        Frame pixelFrame = buffer.getBackFrame();
        if (x > width / 2) {
            x = x - width / 2;
            pixelFrame = buffer.getCurrentFrame();
        }
        pixelFrame.setPixel(x, y, color);
    }

    public void render() {
        buffer.swap();
        Frame currentFrame = buffer.getCurrentFrame();
        for (int i = 0; i < height; i++) {
            for (int b = 0; b < 2; b++) {
                for (int j = 0; j < width / 2; j++) {
                    System.out.print(currentFrame.getPixel(j, i).getColor());
                }
                buffer.swap();
                currentFrame = buffer.getCurrentFrame();
            }
            System.out.println();
        }
    }
}
