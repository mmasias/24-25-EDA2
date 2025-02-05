public class Pixel {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;

    private static char[][] generateFrame(int offset) {
        char[][] frame = new char[HEIGHT][WIDTH];
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                frame[y][x] = ((x + y + offset) % 2 == 0) ? '#' : ' ';
            }
        }
        return frame;
    }

    private static char[][] combineFrames(char[][] frame1, char[][] frame2) {
        char[][] combinedFrame = new char[HEIGHT][WIDTH * 2];
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                combinedFrame[y][x * 2] = frame1[y][x];
                combinedFrame[y][x * 2 + 1] = frame2[y][x];
            }
        }
        return combinedFrame;
    }

    private static void printFrame(char[][] frame) {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < frame[y].length; x++) {
                System.out.print(frame[y][x]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] frame1 = generateFrame(0);
        char[][] frame2 = generateFrame(1);

        char[][] combinedFrame = combineFrames(frame1, frame2);

        printFrame(combinedFrame);
    }
}