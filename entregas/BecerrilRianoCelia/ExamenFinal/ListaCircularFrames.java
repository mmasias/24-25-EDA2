import java.util.ArrayList;

public class ListaCircularFrames {

    private ArrayList<Frame> frames;
    private int indiceActual;
    private int tamaño;

    public ListaCircularFrames(int tamaño, Resolucion resolucion) {
        this.tamaño = tamaño;
        this.frames = new ArrayList<>(tamaño);
        for (int i = 0; i < tamaño; i++) {
            frames.add(new Frame(resolucion));
        }
        indiceActual = 0;
    }

    public void siguiente() {
        indiceActual++;
        indiceActual = indiceActual >= tamaño ? 0 : indiceActual;
    }

    public Frame obtenerActual() {
        int indicePorDevolver = indiceActual;
        this.siguiente();
        return frames.get(indicePorDevolver);
    }

    public Frame obtenerFrame(int i) {
        return frames.get(i);
    }

    public int tamaño(){
        return tamaño;
    }
}