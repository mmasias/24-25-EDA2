public class Renderer {
    private Object frame;

    public void Show(Object frame) {
        this.frame = frame;

        if (frame instanceof Frame) {
            Frame f = (Frame) frame;
            char[][] combined = f.frame();
            for (int y = 0; y < combined.length; y++) {
                for (int x = 0; x < combined[y].length; x++) {
                    char pixel = combined[y][x];
                    String colorCode = getColorCode(pixel);
                    System.out.print(colorCode + pixel + "\033[0m");
                }
                System.out.println();
            }
        } else {
            System.out.println("Critical Error: Invalid frame type.");
        }
    }

    private String getColorCode(char pixel) {
        switch (pixel) {
            case Pixel.NEGRO:
                return "\033[39m";
            case Pixel.BLANCO:
                return "\033[37m";
            case Pixel.CYAN:
                return "\033[36m";
            case Pixel.MAGENTA:
                return "\033[35m";
            default:
                return "\033[0m";
        }
    }
}