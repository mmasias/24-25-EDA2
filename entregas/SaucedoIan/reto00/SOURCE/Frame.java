public class Frame {
    private static final int HEIGHT = 10;
    private static final int WIDTH = 20;

    private char[][] frame;

    public Frame() {
        frame = new char[HEIGHT][WIDTH];
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                frame[y][x] = ' ';
            }
        }
    }

    public void updatePixel(int x, int y, char value) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            frame[y][x] = value;
        }
    }

    public char[][] getFrame() {
        return frame;
    }
}