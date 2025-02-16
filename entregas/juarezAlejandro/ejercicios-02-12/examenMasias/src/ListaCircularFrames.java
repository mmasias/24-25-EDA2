import java.util.ArrayList;

public class ListaCircularFrames {
    private ArrayList<Frame> frames;
    private int indiceActual;

    public ListaCircularFrames(int tamaño, Resolucion resolucion) {
        frames = new ArrayList<>(tamaño);
        for (int i = 0; i < tamaño; i++) {
            frames.add(new Frame(resolucion));
        }
        indiceActual = 0;
    }

    public void siguiente() {
        indiceActual = (indiceActual + 1) % frames.size();
    }

    public Frame obtenerActual() {
        int indicePorDevolver = indiceActual;
        siguiente();
        return frames.get(indicePorDevolver);
    }

    public Frame obtenerFrame(int i) {
        return frames.get(i);
    }

    public int tamaño() {
        return frames.size();
    }
}