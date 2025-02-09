public class GestorPantalla {
    private PantallaEntrelazada pantalla;

    public GestorPantalla(int ancho, int alto){
        pantalla = new PantallaEntrelazada(ancho, alto);   
    }
    public void establecerPixel(Coordenada coordenada, int color,int frame){
        pantalla.establecerPixel(coordenada, color,frame);
    }
    public void renderizar(){
        pantalla.renderizar();
    }
}
