public class Main {
    public static void main(String[] args) {
        Resolucion resolucion = new Resolucion(7, 3);
        PantallaEntrelazada pantallaEntrelazada = new PantallaEntrelazada(resolucion);
        
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(0, 0), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(1, 0), Pixel.BLANCO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(2, 0), Pixel.BLANCO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(3, 0), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(4, 0), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(5, 0), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(6, 0), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(0, 1), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(1, 1), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(2, 1), Pixel.CYAN);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(3, 1), Pixel.CYAN);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(4, 1), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(5, 1), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(6, 1), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(0, 2), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(1, 2), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(2, 2), Pixel.BLANCO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(3, 2), Pixel.BLANCO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(4, 2), Pixel.BLANCO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(5, 2), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(6, 2), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().siguiente();
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(0, 0), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(1, 0), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(2, 0), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(3, 0), Pixel.BLANCO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(4, 0), Pixel.BLANCO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(5, 0), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(6, 0), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(0, 1), Pixel.CYAN);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(1, 1), Pixel.CYAN);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(2, 1), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(3, 1), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(4, 1), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(5, 1), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(6, 1), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(0, 2), Pixel.BLANCO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(1, 2), Pixel.BLANCO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(2, 2), Pixel.BLANCO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(3, 2), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(4, 2), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(5, 2), Pixel.NEGRO);
        pantallaEntrelazada.getEscena().getFrame().establecerPixel(new Coordenada(6, 2), Pixel.NEGRO);
        pantallaEntrelazada.renderizar();
        
        PantallaSuperpuesta pantallaSuperpuesta = new PantallaSuperpuesta(resolucion);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(0, 0), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(1, 0), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(2, 0), Pixel.BLANCO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(3, 0), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(0, 1), Pixel.CYAN);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(1, 1), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(2, 1), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(3, 1), Pixel.MAGENTA);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(0, 2), Pixel.BLANCO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(1, 2), Pixel.CYAN);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(2, 2), Pixel.MAGENTA);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(3, 2), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().siguiente();
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(0, 0), Pixel.BLANCO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(1, 0), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(2, 0), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(3, 0), Pixel.BLANCO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(0, 1), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(1, 1), Pixel.MAGENTA);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(2, 1), Pixel.BLANCO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(3, 1), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(0, 2), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(1, 2), Pixel.BLANCO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(2, 2), Pixel.CYAN);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(3, 2), Pixel.MAGENTA);
        pantallaSuperpuesta.renderizar();
    
    
    
    
    
    
    
    
    
    
    }   
}
