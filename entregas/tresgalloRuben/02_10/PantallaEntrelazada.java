
public class PantallaEntrelazada {
    private Dimension dimension;
    private ListaCircularFrames listaFrames;

    public PantallaEntrelazada(int ancho, int alto, int tamaño) {
        this.dimension = new Dimension(ancho, alto);
        this.listaFrames = new ListaCircularFrames(ancho, alto, tamaño);
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        listaFrames.obtenerActual().establecerPixel(coordenada, color);
    }

    public void renderizar() {
        listaFrames.obtenerActual().renderizar();
    }
}
