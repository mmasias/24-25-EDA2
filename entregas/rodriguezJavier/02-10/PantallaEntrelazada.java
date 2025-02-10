public class PantallaEntrelazada {
    private Dimension dimension;

    private ListaCircularFrames listaFrames;

    public PantallaEntrelazada(Dimension dimension) {
        this.dimension = dimension;
        listaFrames = new ListaCircularFrames(2, new Dimension(dimension.obtenerAncho() / 2, dimension.obtenerAlto()));
    }

    public void renderizar() {
        for (int fila = 0; fila < dimension.obtenerAlto(); fila++) {

            for (int i = 0; i < listaFrames.tamaño(); i++) {
                Frame unFrame = listaFrames.obtenerActual();
                for (int columna = 0; columna < dimension.obtenerAncho() / 2; columna++) {
                    Coordenada coordenada = new Coordenada(columna, fila);
                    Pixel pixel = unFrame.obtenerPixel(coordenada);
                    System.out.print(pixel.obtenerColor() + "|");
                }
            }
            System.out.println();
        }
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        
        int dondeEsta = coordenada.obtenerX() > (dimension.obtenerAncho() / 2) ? 1 : 0;
        Coordenada coordenadaRelativa = new Coordenada(coordenada.obtenerX()-(dimension.obtenerAncho()/2)*dondeEsta, coordenada.obtenerY());

        Frame frame = listaFrames.obtenerFrame(dondeEsta);
        frame.establecerPixel(coordenadaRelativa, color);
    }
}