
public class GestorPantalla {
    private PantallaEntrelazada pantalla;

    public GestorPantalla(int ancho, int alto, int tamaño) {
        this.pantalla = new PantallaEntrelazada(ancho, alto, tamaño);
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pantalla.establecerPixel(coordenada, color);
    }

    public void renderizar() {
        pantalla.renderizar();
    }
}
