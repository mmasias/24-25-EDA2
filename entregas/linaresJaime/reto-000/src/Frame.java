import java.util.ArrayList;
import java.util.List;

    class Frame {
    private List<Pixel> pixels = new ArrayList<>();

    public void addPixel(Pixel pixel) {
        pixels.add(pixel);
    }

    public Pixel getPixel(int index) {
        return pixels.get(index);
    }

    public void clearFrame() {
        pixels.clear();
    }
}

