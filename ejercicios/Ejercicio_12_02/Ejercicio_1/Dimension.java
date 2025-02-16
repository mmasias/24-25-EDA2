package ejercicios.Ejercicio_12_02.Ejercicio_1;

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

    public Dimension dividir() {
        int nuevoAncho = this.ancho / 2;
        int nuevoAlto = this.alto;
        return new Dimension(nuevoAncho, nuevoAlto);

    }

}