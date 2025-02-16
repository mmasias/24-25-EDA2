public class Resolucion {
    private int ancho;
    private int alto;

    public Resolucion(int ancho, int alto) {
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