class Nodo {
    private Frame dato;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo(Frame dato){
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public Nodo getAnterior(){
        return this.anterior;
    }
    
    public Nodo getSiguiente(){
        return this.siguiente;
    }

    public Frame getFrame(){
        return this.dato;
    }

    public void enlazarAnterior(Nodo anterior){
        this.anterior = anterior;
    }

    public void enlazarSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
}