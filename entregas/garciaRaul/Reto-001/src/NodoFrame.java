public class NodoFrame {
    private Frame frame;
    private NodoFrame siguiente;

    public NodoFrame(Frame frame) {
        this.frame = frame;
        this.siguiente = null;
    }

    public Frame getFrame() {
        return this.frame;
    }

    public NodoFrame getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(NodoFrame siguiente) {
        this.siguiente = siguiente;
    }
}