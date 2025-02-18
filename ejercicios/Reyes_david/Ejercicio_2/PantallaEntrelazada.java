package ejercicios.Reyes_david.Ejercicio_2;

public class PantallaEntrelazada {
    private Dimension dimension;
    private ListaCircularFrames listaFrames;
    public PantallaEntrelazada(Dimension dimension) {
        this.dimension = dimension;
        listaFrames = new ListaCircularFrames(2, dimension.dividir());
    }
    public void establecerPixel(Coordenada c, int color) {
        int lado = c.obtenerX() >= dimension.obtenerAncho() / 2 ? 1 : 0;
        Coordenada cRelativa = new Coordenada(c.obtenerX() - lado * (dimension.obtenerAncho() / 2), c.obtenerY());
        listaFrames.obtenerActual().establecerPixel(cRelativa, color);
    }
    public void renderizar() {
        for (int y = 0; y < dimension.obtenerAlto(); y++) {
            for (int i = 0; i < 2; i++) {
                Frame f = listaFrames.obtenerActual();
                for (int x = 0; x < dimension.obtenerAncho() / 2; x++) {
                    System.out.print(f.obtenerPixel(new Coordenada(x, y)).obtenerColor() + "|");
                }
            }
            System.out.println();
        }
    }
}