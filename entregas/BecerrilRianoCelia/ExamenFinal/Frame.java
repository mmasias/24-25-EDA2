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
                columna.add(new Pixel(x, y, 0));
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

    public Resolucion obtenerResolucion() {
        return resolucion;
    }
}