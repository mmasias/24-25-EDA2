class GestorPantalla {
    private PantallaEntrelazada pantallaEntrelazada;

    public GestorPantalla(Dimension dimension) {
        pantallaEntrelazada = new PantallaEntrelazada(dimension);
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pantallaEntrelazada.establecerPixel(coordenada, color);
    }

    public void renderizar() {
        pantallaEntrelazada.renderizar();
    }
}
