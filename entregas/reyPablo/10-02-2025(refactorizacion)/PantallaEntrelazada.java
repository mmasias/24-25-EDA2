public class PantallaEntrelazada {
    private int dimension;  // Lado de cada frame (cuadrado)
    private ListaCircularFrames listaFrames;

    public PantallaEntrelazada(int dimension) {
        this.dimension = dimension;
        listaFrames = new ListaCircularFrames(2, dimension);
    }

    public void renderizar() {
        for (int fila = 0; fila < dimension; fila++) {
            for (int i = 0; i < listaFrames.tamaño(); i++) {
                Frame unFrame = listaFrames.obtenerActual();
                for (int columna = 0; columna < dimension; columna++) {
                    Coordenada coordenada = new Coordenada(columna, fila);
                    Pixel pixel = unFrame.obtenerPixel(coordenada);
                    System.out.print(pixel.obtenerColor() + "|");
                }
            }
            System.out.println();
        }
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        int dondeEsta = coordenada.obtenerX() >= dimension ? 1 : 0;
        int nuevaX = coordenada.obtenerX() - (dondeEsta * dimension);
        Coordenada coordenadaRelativa = new Coordenada(nuevaX, coordenada.obtenerY());
        Frame frame = listaFrames.obtenerFrame(dondeEsta);
        frame.establecerPixel(coordenadaRelativa, color);
    }
}
