package ejercicios.Ejercicio_12_02.Ejercicio_2;

public class Frame {
    private Pixel[][] pixeles;
    public Frame(Dimension dimension) {
        pixeles = new Pixel[dimension.obtenerAncho()][dimension.obtenerAlto()];
        for (int x = 0; x < pixeles.length; x++) {
            for (int y = 0; y < pixeles[x].length; y++) {
                pixeles[x][y] = new Pixel();
            }
        }
    }
    public Pixel obtenerPixel(Coordenada c) { return pixeles[c.obtenerX()][c.obtenerY()]; }
    public void establecerPixel(Coordenada c, int color) { pixeles[c.obtenerX()][c.obtenerY()].establecerColor(color); }
}