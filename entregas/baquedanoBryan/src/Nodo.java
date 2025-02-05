public class Nodo {
    
    public Frame dato;
    public Nodo siguiente;
    public Nodo anterior;

    public Nodo(Frame dato, Nodo siguiente, Nodo anterior){
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Nodo getNodo() {
        return this;
    }

    
}
