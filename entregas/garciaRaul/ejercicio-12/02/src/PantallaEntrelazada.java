public class PantallaEntrelazada {
    Resolucion resolucion;

    private ListaCircularFrames listaFrames;

    public PantallaEntrelazada(Resolucion resolucion) {
        this.resolucion = resolucion;
        listaFrames = new ListaCircularFrames(2, resolucion.getAncho() / 2, resolucion.getAlto());
    }

    public void renderizar() {
        int alto = resolucion.getAlto();
        int ancho = resolucion.getAncho();
        for (int fila = 0; fila < alto; fila++) {

            for (int i = 0; i < listaFrames.tamaño(); i++) {
                Frame unFrame = listaFrames.obtenerActual();
                for (int columna = 0; columna < ancho / 2; columna++) {
                    Coordenada coordenada = new Coordenada(columna, fila);
                    Pixel pixel = unFrame.obtenerPixel(coordenada);
                    System.out.print(pixel.obtenerColor() + "|");
                }
            }
            System.out.println();
        }
    }

    public void establecerPixel(Coordenada coordenada, int color) {
        int ancho = resolucion.getAncho();

        int dondeEsta = coordenada.obtenerX() > (ancho / 2) ? 1 : 0;
        Coordenada coordenadaRelativa = new Coordenada(coordenada.obtenerX()-(ancho/2)*dondeEsta,coordenada.obtenerY());

        Frame frame = listaFrames.obtenerFrame(dondeEsta);
        frame.establecerPixel(coordenadaRelativa, color);
    }
}