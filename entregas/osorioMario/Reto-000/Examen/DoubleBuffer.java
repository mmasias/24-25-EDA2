public class DoubleBuffer {
    private Frame buffer1, buffer2;
    private boolean useBuffer1 = true;

    public DoubleBuffer(int width, int height) {
        buffer1 = new Frame(width, height);
        buffer2 = new Frame(width, height);
    }

    public void swapBuffers() {
        useBuffer1 = !useBuffer1;
    }

    public Frame getCurrentBuffer() {
        return useBuffer1 ? buffer1 : buffer2;
    }
}
