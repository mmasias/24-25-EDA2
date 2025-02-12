
public class PantallaEntrelazada {
    
    private Resolucion resolucion;
    private ListaCircularFrames listaFrames;

    public PantallaEntrelazada(Resolucion resolucion) {
        this.resolucion = resolucion;
        listaFrames = new ListaCircularFrames(2, new Resolucion(resolucion.getMitadAncho(), resolucion.getAlto()));
    }

    public void renderizar() {
        for (int fila = 0; fila < resolucion.getAlto(); fila++) {

            for (int i = 0; i < listaFrames.tamaño(); i++) {
                Frame unFrame = listaFrames.obtenerActual();
                for (int columna = 0; columna < resolucion.getMitadAncho(); columna++) {
                    Coordenada coordenada = new Coordenada(columna, fila);
                    Pixel pixel = unFrame.obtenerPixel(coordenada);
                    System.out.print(pixel.obtenerColor() + "|");
                }
            }
            System.out.println();
        }
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        
        int dondeEsta = coordenada.obtenerX() > (resolucion.getMitadAncho()) ? 1 : 0;
        Coordenada coordenadaRelativa = new Coordenada(coordenada.obtenerX()-(resolucion.getMitadAncho())*dondeEsta,coordenada.obtenerY());

        Frame frame = listaFrames.obtenerFrame(dondeEsta);
        frame.establecerPixel(coordenadaRelativa, color);
    }
}