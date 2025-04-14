public class Interfaz {
    private Frame frame1;
    private Frame frame2;

    public Interfaz(Frame frame1, Frame frame2) {
        this.frame1 = frame1;
        this.frame2 = frame2;
    }

    public Frame combinarFrames() {
        int altura = frame1.getAltura();
        int anchura = frame1.getAnchura();
        Frame combinado = new Frame(altura, anchura);

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < anchura; x++) {
                if (y % 2 == 0) {
                    combinado.setPixel(x, y, frame1.getPixelColor(x, y));
                } else {
                    combinado.setPixel(x, y, frame2.getPixelColor(x, y));
                }
            }
        }
        return combinado;
    }
}
