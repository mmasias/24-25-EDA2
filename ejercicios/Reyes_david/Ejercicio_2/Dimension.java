package ejercicios.Reyes_david.Ejercicio_2;

public class Dimension {
    private int ancho, alto;
    public Dimension(int ancho, int alto) { this.ancho = ancho; this.alto = alto; }
    public int obtenerAncho() { return ancho; }
    public int obtenerAlto() { return alto; }
    public Dimension dividir() { return new Dimension(ancho / 2, alto); }
}
