package segundoEjercicio;

public class Frame {
    private char[][] contenido;

    private Frame(int ancho, int alto, char[][] contenidoInicial) {
        contenido = new char[ancho][alto];
        for (int i = 0; i < contenidoInicial.length; i++) {
            System.arraycopy(contenidoInicial[i], 0, contenido[i], 0, contenidoInicial[i].length);
        }
    }

    public static Frame crearFrame1() {
        return new Frame(3, 4, new char[][] {
                { '.', '.', '#', '.' },
                { '+', '.', '.', '*' },
                { '#', '+', '*', '.' }
        });
    }

    public static Frame crearFrame2() {
        return new Frame(3, 4, new char[][] {
                { '#', '.', '.', '#' },
                { '.', '*', '+', '.' },
                { '.', '#', '+', '*' }
        });
    }

    public void posicionFrame(Pixel pixel, ColoresCompuestos colores) {
        contenido = pixel.listaElementos();
    }

    public void posicionFrame() {
        for (char[] fila : contenido) {
            for (char pixel : fila) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    public char[][] getContenido() {
        return contenido;
    }
}