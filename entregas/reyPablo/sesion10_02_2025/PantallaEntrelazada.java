public class PantallaEntrelazada {
    private Resolucion resolucion;
    private ListaCircularFrames listaFrames;

    public PantallaEntrelazada(Resolucion resolucion) {
        this.resolucion = resolucion;
        int frameAncho = resolucion.getAncho() / 2;
        int frameAlto = resolucion.getAlto();
        listaFrames = new ListaCircularFrames(2, frameAncho, frameAlto);
    }

    public void renderizar() {
        int alto = resolucion.getAlto();
        int frameAncho = resolucion.getAncho() / 2;
        for (int fila = 0; fila < alto; fila++) {
            for (int i = 0; i < listaFrames.tamaño(); i++) {
                Frame unFrame = listaFrames.obtenerActual();
                for (int columna = 0; columna < frameAncho; columna++) {
                    Coordenada coordenada = new Coordenada(columna, fila);
                    Pixel pixel = unFrame.obtenerPixel(coordenada);
                    System.out.print(pixel.obtenerColor() + "|");
                }
            }
            System.out.println();
        }
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        int mitadAncho = resolucion.getAncho() / 2;
        int dondeEsta = coordenada.obtenerX() >= mitadAncho ? 1 : 0;
        int nuevaX = coordenada.obtenerX() - (dondeEsta * mitadAncho);
        Coordenada coordenadaRelativa = new Coordenada(nuevaX, coordenada.obtenerY());
        Frame frame = listaFrames.obtenerFrame(dondeEsta);
        frame.establecerPixel(coordenadaRelativa, color);
    }
}
