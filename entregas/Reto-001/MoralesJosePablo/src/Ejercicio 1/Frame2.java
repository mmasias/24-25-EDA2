public class Frame2 {

    private char[][] contenido;
    private Pixel posicion;

    public Frame1(char[][] contenido, Pixel posicion) {
        this.contenido = contenido;
        this.posicion = posicion;
    }

    public char[][] getContenido() {
        return contenido;
    }

    public Pixel getPosicion() {
        return posicion;
    }
}