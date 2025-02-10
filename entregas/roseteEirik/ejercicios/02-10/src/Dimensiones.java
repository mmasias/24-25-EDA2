public class Dimensiones {

    private int ancho;
    private int alto;

    public Dimensiones(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;    
    }

    public Dimensiones dividirDimensiones(int divisor) {
        return new Dimensiones(ancho / divisor, alto / divisor);
    }

    public int obtenerAncho() {
        return ancho;
    }

    public int obtenerAlto() {
        return alto;
    }
}