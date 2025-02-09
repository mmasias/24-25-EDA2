import java.util.Stack;

public class DoubleBuffer {
    private Stack<Frame> buffers = new Stack<>();

    public DoubleBuffer(int width, int height) {
        buffers.push(new Frame(width, height));
        buffers.push(new Frame(width, height));
    }

    public void swapBuffers() {
        buffers.push(buffers.pop()); // Alterna los buffers
    }

    public Frame getCurrentBuffer() {
        return buffers.peek();
    }
}
