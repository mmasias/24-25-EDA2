package ejercicio1;

public class Pantalla {
    private Frame[] pantalla;
    private int frameActual;
    private final int WIDTH = 320;
    private final int HEIGHT = 200;

    public Pantalla() {
        pantalla = new Frame[2];
        pantalla[0] = new Frame(WIDTH, HEIGHT);
        pantalla[1] = new Frame(WIDTH, HEIGHT);
        frameActual = 0;
    }

    public void mostrarFrame(int posicion) {
        if (posicion >= 0 && posicion < pantalla.length) {
            frameActual = posicion;
            System.out.println("Mostrando Frame " + (frameActual + 1));
        } else {
            System.out.println("Índice de frame inválido.");
        }
    }

    public void modificarPixel(int frame, int pos, int nuevoValor) {
        if (frame >= 0 && frame < pantalla.length) {
            pantalla[frame].modificarPixel(pos, nuevoValor);
        } else {
            System.out.println("Índice de frame inválido.");
        }
    }

    public void alternarFrames() {
        frameActual = 1 - frameActual;
        mostrarFrame(frameActual);
    }
}