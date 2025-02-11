public class Main {
    public static void main(String[] args) {
       /*  Escena escena=new Escena(7, 3, 2);
         escena.getFrame().pintar();
        escena.getFrame().establecerPixel(new Coordenada(0, 0), Pixel.MAGENTA);
        escena.getFrame().establecerPixel(new Coordenada(1, 2), Pixel.BLANCO);
        escena.getFrame().establecerPixel(new Coordenada(0, 2), Pixel.CYAN);
        escena.getFrame().pintar();
        escena.siguiente();
        escena.getFrame().pintar();
        escena.siguiente();
        escena.getFrame().pintar();*/
        PantallaEntrelazada pantalla= new PantallaEntrelazada(7, 3);
        pantalla.getEscena().getFrame().establecerPixel(new Coordenada(0, 0), Pixel.CYAN);
        pantalla.getEscena().siguiente();
        pantalla.getEscena().getFrame().establecerPixel(new Coordenada(0, 0), Pixel.BLANCO);
       // pantalla.renderizar();

        PantallaSuperpuesta pantallaSuperpuesta = new PantallaSuperpuesta(7, 3);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(0, 0), Pixel.MAGENTA);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(6, 2), Pixel.BLANCO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(5, 2), Pixel.MAGENTA);
        pantallaSuperpuesta.getEscena().siguiente();
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(0, 0), Pixel.BLANCO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(6, 2), Pixel.NEGRO);
        pantallaSuperpuesta.getEscena().getFrame().establecerPixel(new Coordenada(5, 2), Pixel.CYAN);
        pantallaSuperpuesta.renderizar();
    
    
    
    
    
    
    
    
    
    
    }   
}
