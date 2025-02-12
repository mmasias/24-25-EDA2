
public class NodoFrame extends Frame{
    
    private NodoFrame siguiente;

    public NodoFrame(){
        super();
        this.siguiente = null;
    }

    public NodoFrame getSiguiente(){
        return this.siguiente;
    }

    public void setSiguiente(NodoFrame nodo){
        this.siguiente = nodo;
    }

}