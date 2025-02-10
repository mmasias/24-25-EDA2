class GestorPantalla {
    private PantallaEntrelazada pantallaEntrelazada;

    public GestorPantalla(Dimensiones dimensiones) {
        pantallaEntrelazada = new PantallaEntrelazada(dimensiones);
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pantallaEntrelazada.establecerPixel(coordenada, color);
    }

    public void renderizar() {
        pantallaEntrelazada.renderizar();
    }
}
