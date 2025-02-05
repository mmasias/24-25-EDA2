package entregas.celayaIker.Ejercicio1;

class Pantalla {
    private int posicion;
    private Frame[] pantalla;

    public Pantalla(int numFrames, int frameSize) {
        this.posicion = 0;
        this.pantalla = new Frame[numFrames];
        for (int i = 0; i < numFrames; i++) {
            this.pantalla[i] = new Frame(frameSize);
        }
    }

    public Frame generarFrame() {
        return new Frame(pantalla[0].obtenerFrame().length);
    }

    public void addFrame(Frame nuevoFrame) {
        if (posicion < pantalla.length) {
            pantalla[posicion++] = nuevoFrame;
        } else {
            System.out.println("No se pueden agregar más frames.");
        }
    }

    public void mostrarFrame(int posicion) {
        if (posicion >= 0 && posicion < pantalla.length) {
            System.out.print("Frame " + posicion + ": ");
            pantalla[posicion].imprimir();
        } else {
            System.out.println("Posición fuera de rango.");
        }
    }

    public void modificarPixel(int frameIndex, int pos, int nuevoValor) {
        if (frameIndex >= 0 && frameIndex < pantalla.length) {
            pantalla[frameIndex].modificarPixel(pos, nuevoValor);
        } else {
            System.out.println("Índice de frame fuera de rango.");
        }
    }
}
