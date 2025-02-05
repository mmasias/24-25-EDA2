package primerEjercicio;

public class ResultadoCombinado {
    private char[][] contenido;

    public ResultadoCombinado(int ancho, int alto) {
        contenido = new char[ancho][alto];
    }

    public void combinar(Frame1 frame1, Frame2 frame2) {
        for (int i = 0; i < frame1.contenido.length; i++) {
            for (int j = 0; j < frame1.contenido[0].length; j++) {
                System.out.print(frame1.contenido[i][j] + " ");
            }
            System.out.print(" ");
            for (int j = 0; j < frame2.contenido[0].length; j++) {
                System.out.print(frame2.contenido[i][j] + " ");
            }
            System.out.println();
        }
    }
}