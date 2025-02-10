package ejercicio2;

class GestorPantalla {
    private PantallaEntrelazada pantallaEntrelazada;

    public GestorPantalla(int ancho, int alto) {
        pantallaEntrelazada = new PantallaEntrelazada(ancho, alto);
    }

    public void establecerPixelFrame1(Coordenada coordenada, char color) {
        pantallaEntrelazada.establecerPixel(coordenada, color, 0);
    }

    public void establecerPixelFrame2(Coordenada coordenada, char color) {
        pantallaEntrelazada.establecerPixel(coordenada, color, 1);
    }

    public void cambiarFrame() {
        pantallaEntrelazada.cambiarFrameActivo();
    }

    public void renderizarFrame(int indice) {
        pantallaEntrelazada.renderizarFrame(indice);
    }

    public char[][] obtenerSalidaEntrelazada() {
        return pantallaEntrelazada.obtenerSalidaEntrelazada();
    }
}