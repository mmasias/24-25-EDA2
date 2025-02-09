public class Nodo {
    private Frame dato;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Frame dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Frame getDato() {
        return dato;
    }

    public void setDato(Frame dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getNodo() {
        return this;
    }
}
