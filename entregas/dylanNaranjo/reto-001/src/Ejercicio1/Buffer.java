package Ejercicio1;

class Buffer {
    private Frame currentFrame;
    private Frame backFrame;

    public Buffer(Frame frame1, Frame frame2) {
        this.currentFrame = frame1;
        this.backFrame = frame2;
    }

    public void swap() {
        Frame temp = currentFrame;
        currentFrame = backFrame;
        backFrame = temp;
    }

    public Frame getCurrentFrame() {
        return currentFrame;
    }

    public void mostrarFrameElegido(Resultado resultado) {
        resultado.combinar(currentFrame, backFrame);
        resultado.mostrarResultado();
    }
}