public class InputManager {
    private Buffer buffer = new Buffer();

    public void UpdatePixel(int x, int y, int color) {
        Frame activeFrame = (buffer.getActiveFrame() == 1) ? buffer.getFrame1() : buffer.getFrame2();
        Pixel p = new Pixel();
        p.setColor(color);
        activeFrame.SetPixel(x, y, p);
    }
}
