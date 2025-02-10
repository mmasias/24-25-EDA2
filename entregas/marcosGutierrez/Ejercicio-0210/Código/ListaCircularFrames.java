
public class ListaCircularFrames {

    private Frame[] frames;
    private int indiceActual;
    private int tamaño;

    public ListaCircularFrames(int tamaño, int ancho, int alto) {
        this.tamaño = tamaño;
        this.frames = new Frame[tamaño];
        for (int i = 0; i < tamaño; i++) {
            frames[i] = new Frame(ancho, alto);
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
        return frames[indicePorDevolver];
    }

    public Frame obtenerFrame(int i) {
        return frames[i];
    }

    public int tamaño(){
        return tamaño;
    }

}
