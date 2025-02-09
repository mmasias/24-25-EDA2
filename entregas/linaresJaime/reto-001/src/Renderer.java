class Renderer {
    private Buffer buffer;

    public Renderer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void renderizar() {
        Frame frame = buffer.getCurrentFrame();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 8; x++) {
                System.out.print(frame.getPixel(x, y).getColor() + " ");
            }
            System.out.println();
        }
    }
}