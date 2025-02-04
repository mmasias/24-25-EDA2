package segundoEjercicio;

public class ResultadoVisual {
    private char[][] contenido;

    public ResultadoVisual(int ancho, int alto) {
        contenido = new char[ancho][2 * alto];
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

/*
 * package segundoEjercicio;
 * 
 * public class ResultadoVisual {
 * private char[][] contenido;
 * 
 * public ResultadoVisual(int ancho, int alto) {
 * contenido = new char[ancho][alto];
 * }
 * 
 * public void combinar(Frame1 frame1, Frame2 frame2) {
 * char[][] f1 = frame1.contenido;
 * char[][] f2 = frame2.contenido;
 * 
 * for (int i = 0; i < f1.length; i++) {
 * for (int j = 0; j < f1[0].length; j++) {
 * contenido[i][j] = combinarColores(f1[i][j], f2[i][j]);
 * }
 * }
 * mostrarResultado();
 * }
 * 
 * private char combinarColores(char c1, char c2) {
 * return switch ("" + c1 + c2) {
 * case ".." -> '.';
 * case ".#", "#." -> '@';
 * case ".+", "+." -> ':';
 * case ".*", "*." -> ';';
 * case "##" -> '#';
 * case "#+", "+#" -> '=';
 * case "#*", "*#" -> '&';
 * case "++" -> '+';
 * case "+*", "*+" -> '$';
 * case "**" -> '*';
 * default -> '?';
 * };
 * }
 * 
 * private void mostrarResultado() {
 * for (char[] fila : contenido) {
 * for (char pixel : fila) {
 * System.out.print(pixel + " ");
 * }
 * System.out.println();
 * }
 * }
 * }
 */