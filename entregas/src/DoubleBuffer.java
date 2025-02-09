public class DoubleBuffer {
    private Frame[] frame;
    private int currentFrame;

    public DoubleBuffer(int width, int height) {
        frame = new Frame[2];
        frame[0] = new Frame(width, height);
        frame[1] = new Frame(width, height);
        currentFrame = 0;
    }

    public Frame getCurrentFrame() {
        return frame[currentFrame];
    }

    public Frame getBackFrame() {
        return frame[(currentFrame + 1) % 2];
    }

    public void swap() {
        currentFrame = (currentFrame + 1) % 2;
    }
}
