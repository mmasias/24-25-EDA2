package entregas.castilloCayetano.reto001.src;

class App {
    public static void main(String[] args) {
        int width = 7, height = 3;

        Frame frame1 = new Frame(width, height);
        Frame frame2 = new Frame(width, height);

        frame1.setPixel(1, 1, '#');
        frame1.setPixel(3, 1, '+');
        frame1.setPixel(5, 1, '-');

        frame2.setPixel(3, 1, '#');
        frame2.setPixel(5, 1, '+');

        frame1.printFrame("Mostrando Frame 1:");
        frame2.printFrame("Mostrando Frame 2:");

        TemporalBlending blending = new TemporalBlending(width, height);
        blending.setPixel(1, 1, '#');
        blending.setPixel(3, 1, '+');
        blending.setPixel(5, 1, '-');
        blending.cycleFrames();
        blending.setPixel(3, 1, '#');
        blending.setPixel(5, 1, '+');

        blending.printBlendedFrame();
    }
}