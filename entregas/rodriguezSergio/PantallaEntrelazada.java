
public class PantallaEntrelazada {
    private int ancho;
    private int alto;

    private ListaCircularFrames listaFrames;

    public PantallaEntrelazada(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        listaFrames = new ListaCircularFrames(2, ancho / 2, alto);
    }

    public void renderizar() {
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
        
        int dondeEsta = coordenada.obtenerX() > (ancho / 2) ? 1 : 0;
        Coordenada coordenadaRelativa = new Coordenada(coordenada.obtenerX()-(ancho/2)*dondeEsta,coordenada.obtenerY());

        Frame frame = listaFrames.obtenerFrame(dondeEsta);
        frame.establecerPixel(coordenadaRelativa, color);
    }
}
