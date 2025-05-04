class GestorPantalla {
    PantallaEntrelazada pantalla;
    
    public GestorPantalla(int ancho, int alto) {
        this.pantalla = new PantallaEntrelazada(ancho, alto);
    }
    
    public void establecerPixel(Coordenada coordenada, int color) {
        pantalla.establecerPixel(coordenada, color);
    }
    
    public void renderizar() {
        pantalla.renderizar();
    }
}
