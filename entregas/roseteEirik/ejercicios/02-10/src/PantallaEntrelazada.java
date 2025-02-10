
public class PantallaEntrelazada {
    private Dimensiones dimensiones;

    private ListaCircularFrames listaFrames;

    public PantallaEntrelazada(Dimensiones dimensiones) {

        listaFrames = new ListaCircularFrames(2, dimensiones.dividirDimensionAncho(2));
    }

    public void renderizar() {
        for (int fila = 0; fila < dimensiones.obtenerAlto(); fila++) {

            for (int i = 0; i < listaFrames.tamaño(); i++) {
                Frame unFrame = listaFrames.obtenerActual();
                for (int columna = 0; columna < dimensiones.obtenerAncho() / 2; columna++) {
                    Coordenada coordenada = new Coordenada(columna, fila);
                    Pixel pixel = unFrame.obtenerPixel(coordenada);
                    System.out.print(pixel.obtenerColor() + "|");
                }
            }
            System.out.println();
        }
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        
        int dondeEsta = coordenada.obtenerX() > (dimensiones.obtenerAncho() / 2) ? 1 : 0;
        Coordenada coordenadaRelativa = new Coordenada(coordenada.obtenerX()-(dimensiones.obtenerAncho()/2)*dondeEsta,coordenada.obtenerY());

        Frame frame = listaFrames.obtenerFrame(dondeEsta);
        frame.establecerPixel(coordenadaRelativa, color);
    }
}
