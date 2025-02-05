package primerEjercicio;

public class Frame1 {
    private char[][] contenido;

    private void posicionFrame(Pixel pixel) {
        contenido = pixel.listaElementos();
    }
}