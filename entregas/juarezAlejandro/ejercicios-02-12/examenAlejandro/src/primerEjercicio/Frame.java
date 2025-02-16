package primerEjercicio;

public class Frame {
    private char[][] contenido;

    public Frame(char[][] contenido) {
        this.contenido = contenido;
    }

    public static Frame crearFrame1() {
        char[][] contenidoFrame1 = {
                { '.', '.', '.', '#', '#', '.', '.' },
                { '+', '+', '.', '.', '.', '.', '.' },
                { '#', '#', '#', '.', '.', '.', '.' }
        };
        return new Frame(contenidoFrame1);
    }

    public static Frame crearFrame2() {
        char[][] contenidoFrame2 = {
                { '.', '#', '#', '.', '.', '.', '.' },
                { '.', '.', '+', '+', '.', '.', '.' },
                { '.', '.', '#', '#', '#', '.', '.' }
        };
        return new Frame(contenidoFrame2);
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