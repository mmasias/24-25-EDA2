public class Resolucion {
    private final int ancho;
    private final int alto;
    private final Pixel[][] frameIzquierdo;
    private final Pixel[][] frameDerecho;
    
    public Resolucion(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        
        frameIzquierdo = new Pixel[ancho/2][alto];
        frameDerecho = new Pixel[ancho/2][alto];
        
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho/2; x++) {
                frameIzquierdo[x][y] = new Pixel();
                frameDerecho[x][y] = new Pixel();
            }
        }
    }
    
    public void setPixel(Coordenada coordenada, int color) {
        if (coordenada.getX() >= ancho/2) {
            frameDerecho[coordenada.getX() - ancho/2][coordenada.getY()].setColor(color);
        } else {
            frameIzquierdo[coordenada.getX()][coordenada.getY()].setColor(color);
        }
    }
    
    public void renderizar() {
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho/2; x++) {
                System.out.print(frameIzquierdo[x][y].getColor() + "|");
            }
            for (int x = 0; x < ancho/2; x++) {
                System.out.print(frameDerecho[x][y].getColor() + "|");
            }
            System.out.println();
        }
    }
}