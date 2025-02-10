package ejercicio2;

class PantallaEntrelazada {
    private ListaCircularFrames listaFrames;
    private int ancho;
    private int alto;

    public PantallaEntrelazada(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        listaFrames = new ListaCircularFrames(2, ancho, alto);
    }

    public void establecerPixel(Coordenada coordenada, char color, int frameIndex) {
        listaFrames.obtenerFrame(frameIndex).establecerPixel(coordenada, color);
    }

    public void cambiarFrameActivo() {
        listaFrames.siguiente();
    }

    public void renderizarFrame(int indice) {
        Frame frame = listaFrames.obtenerFrame(indice);
        char[][] pixeles = frame.obtenerPixeles();
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                System.out.print(pixeles[y][x] + " ");
            }
            System.out.println();
        }
    }

    public char[][] obtenerSalidaEntrelazada() {
        char[][] salida = new char[alto][ancho];
        Frame frame1 = listaFrames.obtenerFrame(0);
        Frame frame2 = listaFrames.obtenerFrame(1);

        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                char color1 = frame1.obtenerPixel(new Coordenada(x, y)).obtenerColor();
                char color2 = frame2.obtenerPixel(new Coordenada(x, y)).obtenerColor();
                salida[y][x] = combinarColores(color1, color2);
            }
        }
        return salida;
    }

    private char combinarColores(char color1, char color2) {
        String combinacion = "" + color1 + color2;
        return switch (combinacion) {
            case ".." -> '.';
            case "##" -> '#';
            case "++" -> '+';
            case "**" -> '*';
            case ".#" -> '@'; case "#." -> '@';
            case ".+" -> ':'; case "+." -> ':';
            case ".*" -> ';'; case "*." -> ';';
            case "#+" -> '='; case "+#" -> '=';
            case "#*" -> '&'; case "*#" -> '&';
            case "+*" -> '$'; case "*+" -> '$';
            default -> '?';
        };
    }
}