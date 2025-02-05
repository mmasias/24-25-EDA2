class Node {
    private Buffer buffer;
    private Manager manager;
    private Frame frame;

    public Node(Buffer buffer, Manager manager, Frame frame) {
        this.buffer = buffer;
        this.manager = manager;
        this.frame = frame;
    }

    public void updatePixel(Pixel pixel) {
        manager.updatePixel(pixel);
    }
    
    public void switchFrame() {
        buffer.switchFrame();
    }
    
    public void initialize() {
        frame.clearFrame();
    }

    public void run() {
    }
}