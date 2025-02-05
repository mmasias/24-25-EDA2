class Manager {
    private Buffer buffer;

    public Manager(Buffer buffer) {
        this.buffer = buffer;
    }

    public void establecerPixel(int x, int y, int color) {
        buffer.getCurrentFrame().establecerPixel(x, y, color);
    }
}