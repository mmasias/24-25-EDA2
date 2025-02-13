import java.util.ArrayDeque;

public class Frame {
    
    private ArrayDeque<Pixel[]> pixeles;

    public Frame(Resolucion resolucion) {
        pixeles = new ArrayDeque<>();
        for (int y = 0; y < resolucion.obtenerAlto(); y++) {
            Pixel[] fila = new Pixel[resolucion.obtenerAncho()];
            for (int x = 0; x < resolucion.obtenerAncho(); x++) {
                fila[x] = new Pixel();
                fila[x].establecerColor(0);
            }
            pixeles.add(fila);
        }
    }

    public Pixel obtenerPixel(Coordenada coordenada) {
        return pixeles.toArray(new Pixel[0][])[coordenada.obtenerY()][coordenada.obtenerX()];
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pixeles.toArray(new Pixel[0][])[coordenada.obtenerY()][coordenada.obtenerX()].establecerColor(color);
    }
}