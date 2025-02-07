package primerEjercicio;

public class Frame1 {
    char[][] contenido;

    public Frame1(int ancho, int alto) {
        contenido = new char[][] {
                { '.', '.', '.', '#', '#', '.', '.' },
                { '+', '+', '.', '.', '.', '.', '.' },
                { '#', '#', '#', '.', '.', '.', '.' }
        };
    }

    public void posicionFrame(Pixel pixel) {
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
}