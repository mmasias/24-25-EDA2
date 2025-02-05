class Buffer {
    private Frame frame1, frame2;
    private int activeFrame;
    private boolean running;

    public Buffer() {
        frame1 = new Frame();
        frame2 = new Frame();
        activeFrame = 1;
    }

    public void switchFrame() {
        activeFrame = (activeFrame == 1) ? 2 : 1;
    }

    public Frame getCurrentFrame() {
        return (activeFrame == 1) ? frame1 : frame2;
    }

    public void toggleFrame() {
        switchFrame();
    }

    public void start() {
        running = true;
    }
    
    public void stop() {
        running = false;
    }
}

