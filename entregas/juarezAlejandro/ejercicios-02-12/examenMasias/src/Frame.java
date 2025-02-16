import java.util.ArrayList;

public class Frame {
    private ArrayList<ArrayList<Pixel>> pixeles;
    private Resolucion resolucion;

    public Frame(Resolucion resolucion) {
        this.resolucion = resolucion;
        pixeles = new ArrayList<>(resolucion.obtenerAncho());
        for (int x = 0; x < resolucion.obtenerAncho(); x++) {
            ArrayList<Pixel> columna = new ArrayList<>(resolucion.obtenerAlto());
            for (int y = 0; y < resolucion.obtenerAlto(); y++) {
                Pixel pixel = new Pixel();
                pixel.establecerColor(0);
                columna.add(pixel);
            }
            pixeles.add(columna);
        }
    }

    public Pixel obtenerPixel(Coordenada coordenada) {
        return pixeles.get(coordenada.obtenerX()).get(coordenada.obtenerY());
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        pixeles.get(coordenada.obtenerX()).get(coordenada.obtenerY()).establecerColor(color);
    }
}