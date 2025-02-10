package entregas.castilloCayetano.reto001.src;

import java.util.LinkedList;
import java.util.Queue;

class TemporalBlending {
    private Queue<Frame> frames;
    private static final int FRAME_BUFFER_SIZE = 2;
    private int width, height;

    public TemporalBlending(int width, int height) {
        this.width = width;
        this.height = height;
        frames = new LinkedList<>();
        for (int i = 0; i < FRAME_BUFFER_SIZE; i++) {
            frames.add(new Frame(width, height));
        }
    }

    public void setPixel(int x, int y, char color) {
        if (!frames.isEmpty()) {
            frames.peek().setPixel(x, y, color);
        }
    }

    public void cycleFrames() {
        frames.add(frames.poll());
    }

    public void printBlendedFrame() {
        Frame frame1 = frames.poll();
        Frame frame2 = frames.peek();
        frames.add(frame1);

        System.out.println("Frame Combinado:");
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(Pixel.blendColors(frame1.getPixel(x, y), frame2.getPixel(x, y)) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}