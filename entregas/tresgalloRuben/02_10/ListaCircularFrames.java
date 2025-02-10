
public class ListaCircularFrames {
    private Frame[] frames;
    private int indiceActual;
    private int tamaño;

    public ListaCircularFrames(int ancho, int alto, int tamaño) {
        this.tamaño = tamaño;
        this.frames = new Frame[tamaño];

        for (int i = 0; i < tamaño; i++) {
            frames[i] = new Frame(ancho, alto);
        }

        this.indiceActual = 0;
    }

    public Frame siguiente() {
        indiceActual = (indiceActual + 1) % tamaño;
        return frames[indiceActual];
    }

    public Frame obtenerActual() {
        return frames[indiceActual];
    }

    public Frame obtenerFrame(int numeroFrame) {
        if (numeroFrame >= 0 && numeroFrame < tamaño) {
            return frames[numeroFrame];
        }
        return null;
    }

    public int tamaño() {
        return tamaño;
    }
}
