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
        pantalla.renderizar();
    }
}
