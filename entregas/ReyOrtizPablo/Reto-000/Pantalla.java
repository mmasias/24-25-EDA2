public class Pantalla {
    private Frame frame1;
    private Frame frame2;
    private int frameActual = 0;

    public Pantalla(Frame frame1, Frame frame2) {
        this.frame1 = frame1;
        this.frame2 = frame2;
    }

    public void cambiarFrame() {
        frameActual = (frameActual + 1) % 2;
    }

    public void actualizarPantalla() {
        if (frameActual == 0) {
            frame1.renderizar();
        } else {
            frame2.renderizar();
        }
    }

    public char[][] combinarFrames() {
        int altura = frame1.getAltura();
        int anchura = frame1.getAnchura();
        char[][] combinado = new char[altura][anchura];
        Entrelazado entrelazado = new Entrelazado();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                char color1 = frame1.getPixel(j, i);
                char color2 = frame2.getPixel(j, i);
                combinado[i][j] = entrelazado.combinarColores(color1, color2);
            }
        }

        return combinado;
    }
}
