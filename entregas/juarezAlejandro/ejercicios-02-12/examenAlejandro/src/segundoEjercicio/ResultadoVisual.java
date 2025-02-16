package segundoEjercicio;

public class ResultadoVisual {
    private char[][] contenido;

    public ResultadoVisual(int ancho, int alto) {
        contenido = new char[ancho][alto];
    }

    public void combinar(Frame frame1, Frame frame2) {
        char[][] f1 = frame1.getContenido();
        char[][] f2 = frame2.getContenido();

        for (int i = 0; i < f1.length; i++) {
            for (int j = 0; j < f1[0].length; j++) {
                contenido[i][j] = combinarColores(f1[i][j], f2[i][j]);
            }
        }
        mostrarResultado();
    }

    private char combinarColores(char c1, char c2) {
        return switch ("" + c1 + c2) {
            case ".." -> '.';
            case ".#", "#." -> '@';
            case ".+", "+." -> ':';
            case ".*", "*." -> ';';
            case "##" -> '#';
            case "#+", "+#" -> '=';
            case "#*", "*#" -> '&';
            case "++" -> '+';
            case "+*", "*+" -> '$';
            case "**" -> '*';
            default -> '?';
        };
    }

    private void mostrarResultado() {
        for (char[] fila : contenido) {
            for (char pixel : fila) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}