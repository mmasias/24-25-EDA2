package entregas.celayaIker.Ejercicio2;

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

    public void imprimir() {
        for (int i = 0; i < pantalla.length; i++) {
            System.out.print("Frame " + i + ": ");
            for (Pixel p : pantalla[i].obtenerFrame()) {
                System.out.print(p.obtenerDato() + " ");
            }
            System.out.println();
        }
    }

    public Frame traducir(Frame origen, Frame destino) {
        int size = origen.obtenerFrame().length;
        Frame nuevoFrame = new Frame(size);
        for (int i = 0; i < size; i++) {
            nuevoFrame.modificarPixel(i, (origen.obtenerFrame()[i].obtenerDato() + destino.obtenerFrame()[i].obtenerDato()) / 2);
        }
        return nuevoFrame;
    }
}
