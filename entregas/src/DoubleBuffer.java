import java.util.ArrayList;

public class DoubleBuffer {
    private ArrayList<Frame> frame;
    private int currentFrame;

    public DoubleBuffer(int width, int height) {
        frame = new ArrayList<Frame>(2);
        frame.add(new Frame(width, height));
        frame.add(new Frame(width, height));
        currentFrame = 0;
    }

    public Frame getCurrentFrame() {
        return frame.get(currentFrame);
    }

    public Frame getBackFrame() {
        return frame.get((currentFrame + 1) % 2);
    }

    public void swap() {
        currentFrame = (currentFrame + 1) % 2;
    }
}
