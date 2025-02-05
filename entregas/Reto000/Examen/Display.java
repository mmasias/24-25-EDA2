package Examen;

class Display {
    private Frame frame1, frame2;
    private int currentFrame;

    public Display(Frame frame1, Frame frame2) {
        this.frame1 = frame1;
        this.frame2 = frame2;
        this.currentFrame = 1;

    }

    public void switchFrame() {
        currentFrame = (currentFrame == 1) ? 2 : 1;
    }

    public void updateDisplay() {
        System.out.println("Mostrando Frame " + currentFrame + ":");
        if (currentFrame == 1) {
            frame1.render();
        } else {
            frame2.render();
        }
    }

    public char[][] CombinedFrames() {
        char[][] combinedFrame = new char[frame1.height][frame1.width];
        for (int y = 0; y < frame1.height; y++) {
            for (int x = 0; x < frame1.width; x++) {
                char color1 = frame1.getPixel(x, y);
                char color2 = frame2.getPixel(x, y);
                combinedFrame[y][x] = overlay.combineColors(color1, color2);
            }
        }
        return combinedFrame;
    }
}