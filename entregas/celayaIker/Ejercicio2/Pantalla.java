package entregas.celayaIker.Ejercicio2;

class Pantalla {
    private Frame[] pantalla;
    private int frameActual;

    public Pantalla() {
        pantalla = new Frame[2];
        pantalla[0] = new Frame(320, 200);
        pantalla[1] = new Frame(320, 200);
        frameActual = 0;
    }

    public void mostrarFrame(int posicion) {
        frameActual = posicion;
        System.out.println("Mostrando Frame " + (frameActual + 1));
    }

    public void modificarPixel(int frame, int x, int y, int nuevoValor) {
        pantalla[frame].modificarPixel(x, y, nuevoValor);
    }

    public void alternarColores() {
        frameActual = 1 - frameActual;
        mostrarFrame(frameActual);
    }
}
