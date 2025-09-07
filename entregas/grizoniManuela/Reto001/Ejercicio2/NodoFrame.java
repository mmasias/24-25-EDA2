package Reto001.Ejercicio2;

public class NodoFrame {
    private NodoFrame anterior;
    private NodoFrame siguiente;
    private Frame frame;

    public NodoFrame(Frame frame) {
        this.frame = frame;
        this.anterior = null;
        this.siguiente = null;
    }

    public NodoFrame getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoFrame anterior) {
        this.anterior = anterior;
    }

    public NodoFrame getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoFrame siguiente) {
        this.siguiente = siguiente;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }
}

