public class BufferPantalla {
    private int ancho;
    private int alto;
    private String[][] frame1;
    private String[][] frame2;

    public BufferPantalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.frame1 = new String[alto][ancho];
        this.frame2 = new String[alto][ancho];
        inicializarFrames("Blanco");
    }

    private void inicializarFrames(String color) {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                frame1[i][j] = color;
                frame2[i][j] = color;
            }
        }
    }

    public void actualizarPixel(String[][] frame, int x, int y, String color) {
        if (x >= 0 && x < ancho && y >= 0 && y < alto) {
            frame[y][x] = color;
        }
    }

    public void aplicarSuperposicionTemporal(SuperposicionTemporal superposicionTemporal) {
        String[][] resultado = superposicionTemporal.superposicionTemporal(frame1, frame2);
        mostrarPantalla(resultado);
    }

    private void mostrarPantalla(String[][] frame) {
        for (String[] fila : frame) {
            for (String pixel : fila) {
                System.out.print((pixel.length() > 6 ? pixel.substring(0, 6) : pixel) + "\t");
            }
            System.out.println();
        }
    }

    public String[][] getFrame1() {
        return frame1;
    }

    public String[][] getFrame2() {
        return frame2;
    }
}
