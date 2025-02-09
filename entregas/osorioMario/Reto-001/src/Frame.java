import java.util.*;

public class Frame {
    private List<List<String>> pixels;

    public Frame(int width, int height) {
        pixels = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> row = new ArrayList<>(Collections.nCopies(width, " "));
            pixels.add(row);
        }
    }

    public void updatePixel(int x, int y, String color) {
        if (y < pixels.size() && x < pixels.get(y).size()) {
            pixels.get(y).set(x, color);
        }
    }

    public void fill(String color) {
        for (List<String> row : pixels) {
            Collections.fill(row, color);
        }
    }

    public void display() {
        for (List<String> row : pixels) {
            System.out.println(String.join(" ", row));
        }
        System.out.println();
    }
}
