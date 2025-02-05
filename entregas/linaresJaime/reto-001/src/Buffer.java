import java.util.ArrayList;
import java.util.List;

class Buffer {
    private List<Frame> frames;
    private int currentIndex;

    public Buffer(int width, int height) {
        frames = new ArrayList<>();
        frames.add(new Frame(width, height));
        frames.add(new Frame(width, height));
        currentIndex = 0;
    }

    public Frame getCurrentFrame() {
        return frames.get(currentIndex);
    }

    public void toggleFrame() {
        currentIndex = (currentIndex + 1) % frames.size();
    }
}