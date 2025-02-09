public class Frame {
    private char[][] frame1;
    private char[][] frame2;

    public Frame() {
        frame1 = new char[10][20];
        frame2 = new char[10][20];
    }

    public void updatePixel(int frameNumber, int x, int y, char value) {
        if (frameNumber == 1) {
            frame1[y][x] = value;
        } else if (frameNumber == 2) {
            frame2[y][x] = value;
        }
    }

    public char[][] frame() {
        char[][] combined = new char[10][40];
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 20; x++) {
                combined[y][x] = frame1[y][x];
                combined[y][x + 20] = frame2[y][x];
            }
        }
        return combined;
    }
}
