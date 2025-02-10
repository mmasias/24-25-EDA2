class GestorPantalla {
    private PantallaEntrelazada pantallaEntrelazada;

    public GestorPantalla(int ancho, int alto) {
        pantallaEntrelazada = new PantallaEntrelazada(ancho, alto);
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pantallaEntrelazada.establecerPixel(coordenada, color);
    }

    public void renderizar() {
        pantallaEntrelazada.renderizar();
    }
}
