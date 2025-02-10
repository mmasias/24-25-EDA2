class GestorPantalla {
    private PantallaEntrelazada pantallaEntrelazada;

    public GestorPantalla(Resolucion resolucion) {
        pantallaEntrelazada = new PantallaEntrelazada(resolucion);
    }

    public GestorPantalla(int ancho, int alto) {
        this(new Resolucion(ancho, alto));
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pantallaEntrelazada.establecerPixel(coordenada, color);
    }

    public void renderizar() {
        pantallaEntrelazada.renderizar();
    }
}
