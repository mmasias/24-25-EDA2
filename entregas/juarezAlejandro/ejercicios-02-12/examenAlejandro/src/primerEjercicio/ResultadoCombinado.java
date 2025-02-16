package primerEjercicio;

public class ResultadoCombinado {
    private char[][] contenido;

    public ResultadoCombinado(int ancho, int alto) {
        contenido = new char[ancho][alto];
    }

    public void combinar(Frame frame1, Frame frame2) {
        for (int i = 0; i < frame1.getContenido().length; i++) {
            for (int j = 0; j < frame1.getContenido()[0].length; j++) {
                System.out.print(frame1.getContenido()[i][j] + " ");
            }
            System.out.print("");
            for (int j = 0; j < frame2.getContenido()[0].length; j++) {
                System.out.print(frame2.getContenido()[i][j] + " ");
            }
            System.out.println();
        }
    }
}