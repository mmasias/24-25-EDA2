public class GestorPantalla {
    private final Resolucion resolucion;
    
    public GestorPantalla(Resolucion resolucion) {
        this.resolucion = resolucion;
    }
    
    public void setPixel(Coordenada coordenada, int color) {
        resolucion.setPixel(coordenada, color);
    }
    
    public void renderizar() {
        resolucion.renderizar();
    }
}