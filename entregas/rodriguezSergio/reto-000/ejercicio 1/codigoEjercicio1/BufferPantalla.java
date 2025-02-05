public class BufferPantalla {
    private int[][] alturaFrame;
    private int[][] anchuraFrame;
    private int[][] frame1;
    private int[][] frame2;
    private int[][] frameCombinado;

    public BufferPantalla(int filas, int columnas) {
        this.alturaFrame = new int[filas][columnas];
        this.anchuraFrame = new int[filas][columnas];
        this.frame1 = new int[filas][columnas];
        this.frame2 = new int[filas][columnas];
        this.frameCombinado = new int[filas][columnas];
    }

    public void combinarFrames() {
        for (int i = 0; i < frame1.length; i++) {
            for (int j = 0; j < frame1[i].length; j++) {
                frameCombinado[i][j] = (frame1[i][j] + frame2[i][j]) / 2;
            }
        }
    }

    public void actualizarPixel(int[][] frame, int x, int y, int valor) {
        if (x >= 0 && x < frame.length && y >= 0 && y < frame[0].length) {
            frame[x][y] = valor;
        } else {
            System.out.println("Coordenadas fuera de rango.");
        }
    }

    public void mostrarPantalla() {
        for (int i = 0; i < frameCombinado.length; i++) {
            for (int j = 0; j < frameCombinado[i].length; j++) {
                System.out.print(frameCombinado[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] obtenerFrameCombinado() {
        return frameCombinado;
    }

    public int[][] getFrame1() {
        return frame1;
    }

    public int[][] getFrame2() {
        return frame2;
    }
}
