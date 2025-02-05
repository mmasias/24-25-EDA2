public class Display {
    private Frame buffer1;
    private Frame buffer2;
    private int frameActual;

    public Display(int x, int y) {
        buffer1 = new Frame(x, y);
        buffer2 = new Frame(x, y);
        frameActual = 1;
    }

    public void cambiarFrame() {
        frameActual = (frameActual == 1) ? 2 : 1;
    }

    public void dibujarPixel(int x, int y, boolean estado, String color) {
        if (frameActual == 1) {
            buffer1.setPixel(x, y, estado, color);
        } else {
            buffer2.setPixel(x, y, estado, color);
        }
    }

    public Frame renderFrame() {
        return (frameActual == 1) ? buffer1 : buffer2;
    }
}
