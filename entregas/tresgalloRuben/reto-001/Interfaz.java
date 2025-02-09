public class Interfaz {
    private Frame frame1, frame2;
    private int frameActual;
    private Superposicion superposicion;

    public Interfaz(Frame frame1, Frame frame2) {
        this.frame1 = frame1;
        this.frame2 = frame2;
        this.frameActual = 1;
        this.superposicion = new Superposicion();
    }

    public void cambiarFrame() {
        frameActual = (frameActual == 1) ? 2 : 1;
    }

    public void actualizarPantalla() {
        if (frameActual == 1) {
            frame1.renderizar();
        } else {
            frame2.renderizar();
        }
    }

    public char[][] combinarFrames() {
        int altura = frame1.getPixeles().length;
        int anchura = frame1.getPixeles()[0].length;
        char[][] resultado = new char[altura][anchura];

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                char color1 = frame1.getPixeles()[i][j].getColor();
                char color2 = frame2.getPixeles()[i][j].getColor();
                resultado[i][j] = superposicion.combinarColores(color1, color2);
            }
        }
        return resultado;
    }
}
