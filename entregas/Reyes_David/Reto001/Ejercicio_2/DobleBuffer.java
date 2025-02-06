package entregas.Reyes_David.Reto001.Ejercicio_2;

public class DobleBuffer {
    private Frame frame1;
    private Frame frame2;
    private Frame resultado;

    public DobleBuffer(int filas, int columnas) {
        this.frame1 = new Frame(filas, columnas);
        this.frame2 = new Frame(filas, columnas);
        this.resultado = new Frame(filas, columnas);
    }

    public void combinarFrames() {
        Pixel[][] matriz1 = frame1.getMatriz();
        Pixel[][] matriz2 = frame2.getMatriz();
        Pixel[][] matrizResultado = resultado.getMatriz();

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                char combinado = Pixel.combinarColores(matriz1[i][j].getColor(), matriz2[i][j].getColor());
                matrizResultado[i][j].setColor(combinado);
            }
        }
    }

    public Frame getFrame1() {
        return frame1;
    }

    public Frame getFrame2() {
        return frame2;
    }

    public Frame getResultado() {
        return resultado;
    }
}
