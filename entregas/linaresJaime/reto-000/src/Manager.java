class Manager {
    private Buffer buffer;

    public Manager(Buffer buffer) {
        this.buffer = buffer;
    }

    public void updatePixel(Pixel pixel) {
        buffer.getCurrentFrame().addPixel(pixel);
    }
}
