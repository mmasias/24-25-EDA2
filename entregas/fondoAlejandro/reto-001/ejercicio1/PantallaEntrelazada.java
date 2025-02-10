package ejercicio1;

class PantallaEntrelazada {
    private ListaCircularFrames listaFrames;
    private int ancho;
    private int alto;

    public PantallaEntrelazada(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        listaFrames = new ListaCircularFrames(2, ancho, alto);
    }

    public void establecerPixel(Coordenada coordenada, int color, int frameIndex) {
        listaFrames.obtenerFrame(frameIndex).establecerPixel(coordenada, color);
    }

    public void cambiarFrameActivo() {
        listaFrames.siguiente();
    }

    public void renderizarFrame(int indice) {
        Frame frame = listaFrames.obtenerFrame(indice);
        Pixel[][] pixeles = frame.obtenerPixeles();
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                System.out.print(pixeles[y][x].obtenerColor() + " ");
            }
            System.out.println();
        }
    }

    public Pixel[][] obtenerSalidaEntrelazada() {
        Pixel[][] salida = new Pixel[alto][ancho * 2];
        Frame frame1 = listaFrames.obtenerFrame(0);
        Frame frame2 = listaFrames.obtenerFrame(1);

        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                salida[y][x] = frame1.obtenerPixel(new Coordenada(x, y));
                salida[y][x + ancho] = frame2.obtenerPixel(new Coordenada(x, y));
            }
        }
        return salida;
    }
}