public class Main {
    public static void main(String[] args) {
        PantallaEntrelazada pantalla = new PantallaEntrelazada(7, 3);
        pantalla.getEscena().getFrame().establecerPixel(new Coordenada(0, 0), Pixel.CYAN);
        pantalla.getEscena().getFrame().establecerPixel(new Coordenada(6, 2), Pixel.GRIS);
        pantalla.getEscena().siguiente();
        pantalla.getEscena().getFrame().establecerPixel(new Coordenada(6, 2), Pixel.BLANCO);
        pantalla.getEscena().getFrame().establecerPixel(new Coordenada(0, 0), Pixel.MAGENTA);
        pantalla.getEscena().siguiente();
        pantalla.renderizar();

    }
}