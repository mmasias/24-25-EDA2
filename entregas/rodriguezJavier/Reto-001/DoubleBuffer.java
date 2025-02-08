class DobleBuffer {

    private Frame[] frames;
    private Frame activeFrame;

    public DobleBuffer(int numberOfFrames, int width, int height) {
        frames = new Frame[numberOfFrames];
        for (int i = 0; i < numberOfFrames; i++) {
            frames[i] = new Frame(width, height);
        }
        activeFrame = frames[0];
    }

    public void switchFrame(int index) {
        if (index >= 0 && index < frames.length) {
            activeFrame = frames[index];
        }
    }

    public Frame getActiveFrame() {
        return activeFrame;
    }

    public Frame combineFrames(){
        return activeFrame;
    }
}