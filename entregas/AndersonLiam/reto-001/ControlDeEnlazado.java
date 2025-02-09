public class ControlDeEnlazado {
    private Frame frame1;
    private Frame frame2;
    private Frame frameRestante;

    public void establecerFrames(Frame f1, Frame f2) {
        this.frame1 = f1;
        this.frame2 = f2;
        combinarFrames();
    }

    private void combinarFrames() {
        if (frame1 != null && frame2 != null) {
            int ancho = Math.min(frame1.getAncho(), frame2.getAncho());
            int alto = Math.min(frame1.getAlto(), frame2.getAlto());
            frameRestante = new Frame(ancho, alto);

            for (int i = 0; i < ancho; i++) {
                for (int j = 0; j < alto; j++) {
                    if (i % 2 == 0) {
                        frameRestante.establecerPixel(i, j, frame1.obtenerPixel(i, j).getColor());
                    } else {
                        frameRestante.establecerPixel(i, j, frame2.obtenerPixel(i, j).getColor());
                    }
                }
            }
        }
    }

    public Frame getFrameRestante() {
        return frameRestante;
    }
}