package primerEjercicio;

public class ResultadoCombinado {
    private char[][] contenido;

    private void combinar(Frame1 frame1, Frame2 frame2) {
        for (int i = 0; i < contenido.length; i++) {
            for (int j = 0; j < contenido[0].length; j++) {
                System.out.print(frame1.contenido[i][j] + " ");
            }
            System.out.print(" ");
            for (int j = 0; j < contenido[0].length; j++) {
                System.out.print(frame2.contenido[i][j] + " ");
            }
            System.out.println();
        }
    }
}