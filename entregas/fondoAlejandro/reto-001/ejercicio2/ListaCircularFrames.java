package ejercicio2;

class ListaCircularFrames {
    private Frame[] frames;
    private int indiceActual;

    public ListaCircularFrames(int cantidadFrames, int ancho, int alto) {
        frames = new Frame[cantidadFrames];
        for (int i = 0; i < cantidadFrames; i++) {
            frames[i] = new Frame(ancho, alto);
        }
        indiceActual = 0;
    }

    public Frame obtenerFrame(int indice) {
        return frames[indice];
    }

    public void siguiente() {
        indiceActual = (indiceActual + 1) % frames.length;
    }
}