import java.util.HashMap;
import java.util.Map;

public class Renderer {
    private static final String RESET_COLOR = "\033[0m";
    private static final String BLACK = "\033[39m";
    private static final String WHITE = "\033[37m";
    private static final String CYAN = "\033[36m";
    private static final String MAGENTA = "\033[35m";

    private static final Map<Character, String> colorMap = new HashMap<>();

    static {
        colorMap.put('#', BLACK);
        colorMap.put('@', WHITE);
        colorMap.put('*', CYAN);
        colorMap.put('+', MAGENTA);
    }

    public enum RenderMode {
        COLOR,
        EXTENDED
    }

    private Frame leftFrame;
    private Frame rightFrame;
    private RenderMode mode = RenderMode.COLOR;

    public void setMode(RenderMode mode) {
        this.mode = mode;
    }

    public void renderFrames(Frame frame) {
        renderColorMode(frame);
    }

    public void renderFrames(Frame left, Frame right) {
        if (left == null || right == null) {
            return;
        }
        this.leftFrame = left;
        this.rightFrame = right;
        renderExtendedMode(leftFrame, rightFrame);
    }

    private void renderColorMode(Frame frame) {
        char[][] content = frame.getFrame();
        for (int y = 0; y < content.length; y++) {
            for (int x = 0; x < content[y].length; x++) {
                char pixel = content[y][x];
                String colorCode = getColorCode(pixel);
                System.out.print(colorCode + pixel + RESET_COLOR);
            }
            System.out.println();
        }
    }

    private void renderExtendedMode(Frame left, Frame right) {
        char[][] leftContent = left.getFrame();
        char[][] rightContent = right.getFrame();

        System.out.println("+" + "-".repeat(leftContent[0].length) + "+" +
                "-".repeat(rightContent[0].length) + "+");

        for (int y = 0; y < leftContent.length; y++) {
            System.out.print("|");

            for (int x = 0; x < leftContent[y].length; x++) {
                System.out.print(leftContent[y][x]);
            }

            System.out.print("|");

            for (int x = 0; x < rightContent[y].length; x++) {
                System.out.print(rightContent[y][x]);
            }

            System.out.println("|");
        }

        System.out.println("+" + "-".repeat(leftContent[0].length) + "+" +
                "-".repeat(rightContent[0].length) + "+");
    }

    private String getColorCode(char pixel) {
        return colorMap.getOrDefault(pixel, RESET_COLOR);
    }
}