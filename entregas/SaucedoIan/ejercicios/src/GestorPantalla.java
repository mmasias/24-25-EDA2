class GestorPantalla {
    private PantallaEntrelazada pantallaEntrelazada;
    private Dimension dimension;

    public GestorPantalla(int ancho, int alto) {
        this.dimension = new Dimension(ancho, alto);
        this.pantallaEntrelazada = new PantallaEntrelazada(this.dimension);
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pantallaEntrelazada.establecerPixel(coordenada, color);
    }

    public void renderizar() {
        pantallaEntrelazada.renderizar();
    }

    public Dimension obtenerDimension() {
        return dimension;
    }
}