public class Escena {
    private int indiceActual;
    private Frame[] frames;

    public Escena(int anchura, int altura, int numeroFrames) {
        this.frames = new Frame[numeroFrames];
        for (int i = 0; i < frames.length; i++) {
            this.frames[i] = new Frame(anchura, altura);
        }
        this.indiceActual = 0;
    }

    public void siguiente() {

        this.indiceActual = (this.indiceActual + 1) % frames.length;

    }

    public Frame getFrame() {

        return this.frames[indiceActual];

    }

    public Frame getFrame(int indice) {

        if (indice > 0 && indice < frames.length) {
            return this.frames[indice];
        }
        return null;
    }

    public int numeroFrames() {
        return frames.length;
    }
}