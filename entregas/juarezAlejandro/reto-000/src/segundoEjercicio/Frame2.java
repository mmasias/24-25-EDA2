package segundoEjercicio;

public class Frame2 {
    private char[][] contenido;

    private void posicionFrame(Pixel pixel, ColoresCompuestos colores) {
        contenido = pixel.listaElementos();
    }
}