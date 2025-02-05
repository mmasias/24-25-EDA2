package primerEjercicio;

public class Pixel {
    private char[][] elementos;

    public Pixel(int ancho, int alto) {
        elementos = new char[ancho][alto];
    }

    public char[][] listaElementos() {
        return elementos;
    }
}