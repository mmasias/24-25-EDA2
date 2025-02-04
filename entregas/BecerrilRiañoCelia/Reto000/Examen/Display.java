package Examen;
class Display {
    private Frame frame1, frame2;
    private int currentFrame;
    private SuperposicionTemporal overlay;

    public Display(Frame frame1, Frame frame2) {
        this.frame1 = frame1;
        this.frame2 = frame2;
        this.currentFrame = 1; // Inicia con el primer frame
        this.overlay = new SuperposicionTemporal();
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

    public void renderCombinedFrames() {
        System.out.println("Frame Combinado:");
        for (int y = 0; y < frame1.height; y++) {
            for (int x = 0; x < frame1.width; x++) {
                char color1 = frame1.getPixel(x, y);
                char color2 = frame2.getPixel(x, y);
                System.out.print(overlay.combineColors(color1, color2) + " ");
            }
            System.out.println();
        }
    }
}