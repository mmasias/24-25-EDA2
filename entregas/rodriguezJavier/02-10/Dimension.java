public class Dimension {
    private int ancho;
    private int alto;

    public Dimension(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public int obtenerAncho() {
        return ancho;
    }

    public int obtenerAlto() {
        return alto;
    }
}